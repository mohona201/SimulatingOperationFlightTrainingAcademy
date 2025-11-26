module oop.simulatingoperationflighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires oop.simulatingoperationflighttrainingacademy;


    opens oop.simulatingoperationflighttrainingacademy to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy;
    exports oop.simulatingoperationflighttrainingacademy.Madhu;
    opens oop.simulatingoperationflighttrainingacademy.Madhu to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy.Madhu.User_1;
    opens oop.simulatingoperationflighttrainingacademy.Madhu.User_1 to javafx.fxml;
}