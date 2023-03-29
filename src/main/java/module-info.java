module com.example.databasgui_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;



    opens com.example.databasgui_ny to javafx.fxml;
    opens com.example.databasgui_ny.mainGUI to javafx.fxml;
    exports com.example.databasgui_ny;
    exports com.example.databasgui_ny.mainGUI;
}