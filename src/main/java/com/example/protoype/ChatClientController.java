package com.example.protoype;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ChatClientController {
    private String username;
    private ChatClient client;

    private VBox layout;
    private TextArea chatArea;
    private TextField messageField;
    private TextField recipientField;
    private Button sendButton;

    public ChatClientController(String username, ConcreteChatMediator mediator) {
        this.username = username;
        this.client = new ChatClient(username, mediator);
        initializeUI();
    }

    private void initializeUI() {
        chatArea = new TextArea();
        chatArea.setEditable(false);

        messageField = new TextField();
        messageField.setPromptText("Type your message...");

        recipientField = new TextField();
        recipientField.setPromptText("Recipient (use 'All' for broadcast)");

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        layout = new VBox(10, chatArea, messageField, recipientField, sendButton);
        layout.setPrefSize(400, 300);
    }

    private void sendMessage() {
        String message = messageField.getText();
        String recipient = recipientField.getText();

        if (!message.isEmpty() && !recipient.isEmpty()) {
            client.sendMessage(recipient, message);
            chatArea.appendText("Me to " + recipient + ": " + message + "\n");
            messageField.clear();
        } else {
            chatArea.appendText("Please enter both a message and recipient.\n");
        }
    }

    public void displayMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }

    public Scene getScene() {
        return new Scene(layout);
    }
}

