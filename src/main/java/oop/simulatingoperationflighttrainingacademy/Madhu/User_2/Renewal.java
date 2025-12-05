package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Renewal implements Serializable {
    private Integer studentId;
    private String studentName, remarks, doctorName;
    private LocalDate renewalDate;
    private LocalDate NewClearanceDate;
    private LocalDate nextDue;

    public Renewal(Integer studentId, String studentName, String remarks, String doctorName, LocalDate renewalDate, LocalDate newClearanceDate, LocalDate nextDue) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.remarks = remarks;
        this.doctorName = doctorName;
        this.renewalDate = renewalDate;
        NewClearanceDate = newClearanceDate;
        this.nextDue = nextDue;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public LocalDate getNewClearanceDate() {
        return NewClearanceDate;
    }

    public LocalDate getNextDue() {
        return nextDue;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public void setNewClearanceDate(LocalDate newClearanceDate) {
        NewClearanceDate = newClearanceDate;
    }

    public void setNextDue(LocalDate nextDue) {
        this.nextDue = nextDue;
    }

    @Override
    public String toString() {
        return "Renewal{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", renewalDate=" + renewalDate +
                ", NewClearanceDate=" + NewClearanceDate +
                ", nextDue=" + nextDue +
                '}';
    }
}

