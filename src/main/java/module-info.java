module oop.simulatingoperationflighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop.simulatingoperationflighttrainingacademy to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy;
    exports oop.simulatingoperationflighttrainingacademy.Madhu;
    opens oop.simulatingoperationflighttrainingacademy.Madhu to javafx.fxml;
}