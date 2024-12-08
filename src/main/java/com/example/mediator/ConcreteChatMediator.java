package com.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteChatMediator {
    private Map<String, ChatClient> clients = new HashMap<>();
    private Map<String, ChatClientController> controllers = new HashMap<>();

    /**
     * Sends a message from the sender to the recipient.
     * If the recipient is "All", the message is broadcasted to all clients except the sender.
     */
    public void sendMessage(String message, String sender, String recipient) {
        if (recipient.equalsIgnoreCase("All")) {
            for (ChatClient client : clients.values()) {
                if (!client.getUsername().equalsIgnoreCase(sender)) {
                    client.receiveMessage(sender, message);
                }
            }
        } else {
            ChatClient recipientClient = clients.get(recipient);
            if (recipientClient != null) {
                recipientClient.receiveMessage(sender, message);
            }
        }
    }

    /**
     * Registers a chat client with the mediator.
     *
     * @param client the chat client to register
     */
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }

    /**
     * Registers a controller associated with a username.
     *
     * @param username   the username of the controller
     * @param controller the controller to register
     */
    public void registerController(String username, ChatClientController controller) {
        controllers.put(username, controller);
    }

    /**
     * Retrieves the controller associated with a given username.
     *
     * @param username the username of the controller
     * @return the controller associated with the username
     */
    public ChatClientController getController(String username) {
        return controllers.get(username);
    }
}

