module com.example.databasgui_v2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires junit;


    opens com.example.databasgui_ny to javafx.fxml;
    opens com.example.databasgui_ny.mainGUI to javafx.fxml;
    opens com.example.databasgui_ny.entities to org.hibernate.orm.core, javafx.base;
    exports com.example.databasgui_ny;
    exports com.example.databasgui_ny.mainGUI;
    exports com.example.databasgui_ny.test;
}