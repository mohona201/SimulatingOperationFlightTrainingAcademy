package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;

public class Leave {
    private String studentName;
    private Integer studentId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

    public Leave(String studentName, Integer studentId, LocalDate startDate, LocalDate endDate, String reason) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "studentName='" + studentName + '\'' +
                ", studentId=" + studentId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reason='" + reason + '\'' +
                '}';
    }
}

