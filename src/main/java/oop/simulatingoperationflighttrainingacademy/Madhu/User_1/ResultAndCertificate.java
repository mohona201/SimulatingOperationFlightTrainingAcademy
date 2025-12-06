package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.io.Serializable;
import java.time.LocalDate;

public class ResultAndCertificate implements Serializable {

    private String examName,status;
    private Integer score;
    private Integer exmId;
    private LocalDate date;


    public ResultAndCertificate(String examName, String status, Integer score, Integer exmId, LocalDate date) {
        this.examName = examName;
        this.status = status;
        this.score = score;
        this.exmId = exmId;
        this.date = date;
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

    public Integer getExmId() {
        return exmId;
    }

    public LocalDate getDate() {
        return date;
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

    public void setExmId(Integer exmId) {
        this.exmId = exmId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ResultAndCertificate{" +
                "examName='" + examName + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                ", exmId=" + exmId +
                ", date=" + date +
                '}';
    }
}
