package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class PreFlight implements Serializable {
    private Integer patientId;
    private String patientName;
    private LocalDate date;

    public PreFlight(Integer patientId, String patientName, LocalDate date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.date = date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PreFlight{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", date=" + date +
                '}';
    }
}

