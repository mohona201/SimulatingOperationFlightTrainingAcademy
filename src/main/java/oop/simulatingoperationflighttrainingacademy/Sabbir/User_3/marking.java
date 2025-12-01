package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

public class marking {
    String studentId;
    String studentName;
    Integer score;
    String remarks;
    String passFailStatus;


    public marking(String studentId, String studentName, Integer score, String remarks, String passFailStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.score = score;
        this.remarks = remarks;
        this.passFailStatus = passFailStatus;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPassFailStatus() {
        return passFailStatus;
    }

    public void setPassFailStatus(String passFailStatus) {
        this.passFailStatus = passFailStatus;
    }

    @Override
    public String toString() {
        return "marking{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", score=" + score +
                ", remarks='" + remarks + '\'' +
                ", passFailStatus='" + passFailStatus + '\'' +
                '}';
    }
}
