module com.example.co_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.jetbrains.annotations;

    opens com.example.co_project to javafx.fxml;
    exports com.example.co_project;
}