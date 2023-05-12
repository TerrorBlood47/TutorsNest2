module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
//    requires javafx.web;//DID IT TO MAKE WEBVIEW AVAILABLE


    opens com.example.javaproject to javafx.fxml;
    exports com.example.javaproject;
}