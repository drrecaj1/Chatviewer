# Chat Viewer Application

## Overview
The Chat Viewer application allows users to load and view chat conversations stored in a specific file format. The conversations are displayed in a formatted manner with timestamps, nicknames, and message content, including emoticons. This application provides an intuitive interface for viewing and managing chat logs.

## Installation Instructions
1. **Download the Application**
   - Obtain the Chat Viewer application package from the provided link or distribution medium.

2. **Install Java**
   - Ensure that Java Development Kit (JDK) 21 or higher is installed on your system. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html).

3. **Set Up Environment in IntelliJ IDEA CE**
   - Open IntelliJ IDEA Community Edition.
   - Click on `File` -> `Open` and navigate to the directory where the Chat Viewer project is located. Select the project and click `OK`.
   - IntelliJ IDEA will open the project and may take a few moments to index and set up the environment.

4. **Ensure Maven is Configured**
   - In the Project tool window, you should see the `pom.xml` file. Double-click to open it.
   - IntelliJ IDEA should automatically recognize the `pom.xml` file and import the Maven project. If it doesn't, right-click on the `pom.xml` file and select `Add as Maven Project`.
   - Wait for IntelliJ IDEA to download all the necessary dependencies. You can check the progress in the bottom status bar.

5. **Run the Application**
   - In the Project tool window, navigate to `src/main/java/com/example/icachatviewer/ChatViewer.java`.
   - Right-click on the `ChatViewer.java` file and select `Run 'ChatViewer.main()'`. IntelliJ IDEA will compile and run the application.
   - Alternatively, you can set up a run configuration:
     1. Click on `Run` -> `Edit Configurations...`.
     2. Click the `+` icon and select `Application`.
     3. Name the configuration `ChatViewer`.
     4. Set the `Main class` to `com.example.icachatviewer.ChatViewer`.
     5. Ensure the `Use classpath of module` is set to your project module.
     6. Click `OK`.
   - Click the green run button in the top-right corner to run the application.

## Usage Guide

### Launching the Application
1. **Start the Application**
   - Follow the steps in the "Run the Application" section to start the Chat Viewer.

### Opening a Chat Log File
1. **Open the Welcome Page**
   - Upon launching the application, you will be greeted with a welcoming page.
   - Click the "Open" button to select a chat log file.

2. **Select a File**
   - A file dialog will appear. Navigate to the directory containing your chat log file (with a ".msg" extension).
   - Select the file and click "Open."

3. **View the Conversation**
   - The chat conversation will be displayed in the main window.
   - Each message is formatted with a timestamp, nickname, and content. Emoticons are replaced with corresponding images.

4. **Go Back to Welcome Page**
   - If you want to open a different file, click the "Go Back" button to return to the welcoming page.

### Customizing the View
1. **Change Background Color**
   - Click the "Change Background" button to select a different background color for the application.
   - Choose your preferred image from your device and apply it to customize the look of the application.

## Features
- **File Selection**: Easily open chat log files using the file dialog.
- **Formatted Display**: View messages with clear formatting, including timestamps, nicknames (in different colors for easy distinction), and content.
- **Emoticon Support**: Emoticons in messages are replaced with corresponding images.
- **Dynamic Content Update**: Add new messages or change existing ones in real-time without needing to reload the application.
- **Customizable Background**: Change the background color of the application to suit your preferences.
- **Navigation**: Go back to the welcoming page to open different chat log files without restarting the application.

## Troubleshooting

### Common Issues and Solutions
- **File Not Opening**
  - **Solution**: Ensure the file has a ".msg" extension and follows the specified format. Verify that the file path is correct and the file is accessible.
  
- **Incorrect Formatting**
  - **Solution**: Check if the file lines start with "Time:", "Name:", and "Message:". Ensure there are no empty lines within message blocks and the file ends correctly without an empty line.

- **Application Errors**
  - **Solution**: If an error message appears, read the error description for details. Common issues include file format errors or unexpected content. Correct the issues in the file and try opening it again.

- **Display Issues**
  - **Solution**: If messages are not displayed correctly, resize the window or scroll to view all content. Ensure the `TextFlow` component is not obstructed.

### Contact Support
If you encounter any issues that are not covered in this documentation, please contact support at [support@example.com](mailto:support@example.com) for further assistance.

By following this user documentation, you should be able to effectively install, use, and troubleshoot the Chat Viewer application, enhancing your experience in viewing and managing chat conversations.
