package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Renewal implements Serializable {
    private  Integer studentId;
    private String  studentName , remark ,  doctorName;
    private LocalDate nextDue;
    private LocalDate renewalDate;

}
