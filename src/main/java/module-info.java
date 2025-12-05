module oop.simulatingoperationflighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    //requires oop.simulatingoperationflighttrainingacademy;
    // requires oop.simulatingoperationflighttrainingacademy;
//    requires oop.simulatingoperationflighttrainingacademy;

    opens oop.simulatingoperationflighttrainingacademy to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy;

    opens oop.simulatingoperationflighttrainingacademy.Madhu.User_1 to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

    opens oop.simulatingoperationflighttrainingacademy.Madhu.User_2 to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

    opens oop.simulatingoperationflighttrainingacademy.Sabbir.User_3 to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;
    opens oop.simulatingoperationflighttrainingacademy.Sabbir.User_4 to javafx.fxml;
    exports oop.simulatingoperationflighttrainingacademy.Sabbir.User_4;
    exports oop.simulatingoperationflighttrainingacademy.Mubin.User5;
    opens oop.simulatingoperationflighttrainingacademy.Mubin.User5 to javafx.fxml;
//    exports;
//    opens to;
}
