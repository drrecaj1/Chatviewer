package com.example.icachatviewer.ui;

import com.example.icachatviewer.data.ChatMessage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class MessageDisplay {
    private final Image smileHappy = new Image(getClass().getResourceAsStream("/com/example/icachatviewer/smile_happy.gif"));
    private final Image smileSad = new Image(getClass().getResourceAsStream("/com/example/icachatviewer/smile_sad.gif"));

    public void showMessages(TextFlow textFlow, List<ChatMessage> messages) {
        textFlow.getChildren().clear();
        String previousNickname = "...";

        for (ChatMessage message : messages) {
            Text timestamp = new Text("[" + message.getTimestamp() + "] ");
            timestamp.getStyleClass().add("timestamp");

            Text nickname;
            if (message.getNickname().equals(previousNickname)) {
                nickname = new Text("...");
            } else {
                nickname = new Text(message.getNickname() + ": ");
                previousNickname = message.getNickname();
            }
            nickname.getStyleClass().add(message.getNickname().equalsIgnoreCase("Adam") ? "nickname-adam" : "nickname-bob");

            // Replace emoticons with images in content
            String contentText = message.getContent();
            textFlow.getChildren().addAll(timestamp, nickname);

            int index = 0;
            while (index < contentText.length()) {
                int happyIndex = contentText.indexOf(":)", index);
                int sadIndex = contentText.indexOf(":(", index);

                if (happyIndex == -1 && sadIndex == -1) {
                    textFlow.getChildren().add(new Text(contentText.substring(index)));
                    break;
                }

                if (happyIndex != -1 && (sadIndex == -1 || happyIndex < sadIndex)) {
                    if (happyIndex > index) {
                        textFlow.getChildren().add(new Text(contentText.substring(index, happyIndex)));
                    }
                    ImageView happyImage = new ImageView(smileHappy);
                    happyImage.setFitHeight(15);
                    happyImage.setFitWidth(15);
                    textFlow.getChildren().add(happyImage);
                    index = happyIndex + 2;
                } else {
                    if (sadIndex > index) {
                        textFlow.getChildren().add(new Text(contentText.substring(index, sadIndex)));
                    }
                    ImageView sadImage = new ImageView(smileSad);
                    sadImage.setFitHeight(15);
                    sadImage.setFitWidth(15);
                    textFlow.getChildren().add(sadImage);
                    index = sadIndex + 2;
                }
            }
            textFlow.getChildren().add(new Text("\n"));
        }
    }
}
