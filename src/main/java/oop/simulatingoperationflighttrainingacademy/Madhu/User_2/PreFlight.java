package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class PreFlight implements Serializable {
    private Integer patientId;
    private String patientName;
    private String status;
    private LocalDate date;

    public PreFlight(Integer patientId, String patientName, String status, LocalDate date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.status = status;
        this.date = date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreFlight{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}

