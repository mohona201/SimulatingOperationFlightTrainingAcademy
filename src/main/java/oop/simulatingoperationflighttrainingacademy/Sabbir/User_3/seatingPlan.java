package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import java.io.Serializable;

public class seatingPlan implements Serializable {
    private String studentId;
    private String studentName;
    private String examName;
    private String examDate;
    private String room;
    private String row;
    private String seatNumber;
    private String planType;

    public seatingPlan(String studentId, String studentName,
                       String examName, String examDate,
                       String room, String row,
                       String seatNumber, String planType) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.examName = examName;
        this.examDate = examDate;
        this.room = room;
        this.row = row;
        this.seatNumber = seatNumber;
        this.planType = planType;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    @Override
    public String toString() {
        return "seatingPlan{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", examName='" + examName + '\'' +
                ", examDate='" + examDate + '\'' +
                ", room='" + room + '\'' +
                ", row='" + row + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", planType='" + planType + '\'' +
                '}';
    }
}
