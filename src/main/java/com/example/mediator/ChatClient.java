package com.example.mediator;

public class ChatClient {
    private String username;
    private ConcreteChatMediator mediator;

    public ChatClient(String username, ConcreteChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String recipient, String message) {
        mediator.sendMessage(message, username, recipient);
    }

    public void receiveMessage(String sender, String message) {
        // Notify the associated controller
        ChatClientController controller = mediator.getController(username);
        if (controller != null) {
            controller.displayMessage(sender, message);
        }
    }
}


