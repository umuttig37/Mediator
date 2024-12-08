package com.example.protoype;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatApplication extends Application {
    private ConcreteChatMediator mediator;

    @Override
    public void start(Stage primaryStage) {
        mediator = new ConcreteChatMediator();

        createClientWindow("Umut");
        createClientWindow("Efe");
        createClientWindow("Siiri");
    }

    private void createClientWindow(String username) {
        Stage stage = new Stage();
        ChatClientController controller = new ChatClientController(username, mediator);

        stage.setTitle("Chat Client - " + username);
        stage.setScene(controller.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}