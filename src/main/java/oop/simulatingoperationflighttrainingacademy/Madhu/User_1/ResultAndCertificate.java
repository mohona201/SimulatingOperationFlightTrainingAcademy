package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.io.Serializable;

public class ResultAndCertificate implements Serializable {

    private String examName,status;
    private Integer score;

    public ResultAndCertificate(String examName, String status, Integer score) {
        this.examName = examName;
        this.status = status;
        this.score = score;
    }

    public String getExamName() {
        return examName;
    }

    public String getStatus() {
        return status;
    }

    public Integer getScore() {
        return score;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ResultAndCertificate{" +
                "examName='" + examName + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                '}';
    }
}
