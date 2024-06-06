module com.example.icachatviewer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.icachatviewer to javafx.fxml;
    opens com.example.icachatviewer.data to javafx.fxml;
    opens com.example.icachatviewer.ui to javafx.fxml;

    exports com.example.icachatviewer;
    exports com.example.icachatviewer.data;
    exports com.example.icachatviewer.ui;
}
