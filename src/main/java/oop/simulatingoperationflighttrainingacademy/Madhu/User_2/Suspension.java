package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Suspension  implements Serializable {
    private Integer patientId;
    private String patientName;
    private String description;
    private String incidentType;
    private String suspensionDescription;
    private LocalDate date;


    public Suspension(Integer patientId, String patientName, String description, String incidentType, String suspensionDescription, LocalDate date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.description = description;
        this.incidentType = incidentType;
        this.suspensionDescription = suspensionDescription;
        this.date = date;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDescription() {
        return description;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getSuspensionDescription() {
        return suspensionDescription;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setSuspensionDescription(String suspensionDescription) {
        this.suspensionDescription = suspensionDescription;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Suspension{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", description='" + description + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", suspensionDescription='" + suspensionDescription + '\'' +
                ", date=" + date +
                '}';
    }
}

