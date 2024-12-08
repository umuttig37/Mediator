module com.example.protoype {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mediator to javafx.fxml;
    exports com.example.mediator;
}