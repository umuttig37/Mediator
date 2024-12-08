module com.example.protoype {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.protoype to javafx.fxml;
    exports com.example.protoype;
}