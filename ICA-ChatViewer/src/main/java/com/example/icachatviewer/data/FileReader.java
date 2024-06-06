package com.example.icachatviewer.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public FileReader() {

    }

    public List<ChatMessage> parse(File file) throws IOException, InvalidFormatException {
        List<ChatMessage> messages = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            String timestamp = null;
            String nickname = null;
            String content = null;
            boolean expectingEmptyLine = false;
            boolean lastLineEmpty = false;

            while ((line = reader.readLine()) != null) {
                lastLineEmpty = false;
                if (line.startsWith("Time:")) {
                    if (timestamp != null || nickname != null || content != null) {
                        throw new InvalidFormatException("Incomplete message found before a new timestamp.");
                    }
                    if (!line.matches("Time:\\d{2}:\\d{2}:\\d{2}")) {
                        throw new InvalidFormatException("Timestamp line is incorrectly formatted.");
                    }
                    timestamp = line.substring(5).trim();
                    expectingEmptyLine = false;
                } else if (line.startsWith("Name:")) {
                    if (!line.matches("Name:.+")) {
                        throw new InvalidFormatException("Name line is incorrectly formatted.");
                    }
                    nickname = line.substring(5).trim();
                    expectingEmptyLine = false;
                } else if (line.startsWith("Message:")) {
                    if (line.length() > 8 && line.charAt(8) == ' ') {
                        throw new InvalidFormatException("Message line is incorrectly formatted.");
                    }
                    content = line.substring(8).trim();
                    if (timestamp != null && nickname != null && content != null) {
                        messages.add(new ChatMessage(timestamp, nickname, content));
                        timestamp = null;
                        nickname = null;
                        content = null;
                        expectingEmptyLine = true; // After a complete message, expect an empty line
                    }
                } else if (line.trim().isEmpty()) {
                    if (!expectingEmptyLine) {
                        throw new InvalidFormatException("Unexpected empty line within a message block.");
                    }
                    lastLineEmpty = true;
                    expectingEmptyLine = false; // Reset after a valid empty line
                } else {
                    throw new InvalidFormatException("Unexpected content found in the file.");
                }
            }

            // Check if there are remaining non-null values indicating a partially parsed message
            if (timestamp != null || nickname != null || content != null) {
                throw new InvalidFormatException("File ended unexpectedly with incomplete message data.");
            }

            // Check if the last line was an empty line
            if (lastLineEmpty) {
                throw new InvalidFormatException("There should be no empty lines after the last message block.");
            }
        }
        return messages;
    }
}


