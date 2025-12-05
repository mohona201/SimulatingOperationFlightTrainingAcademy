package oop.simulatingoperationflighttrainingacademy.Madhu.User_2;

import java.io.Serializable;
import java.time.LocalDate;

public class Suspension  implements Serializable {
    private int patientId;
    private String patientName;
    private String recentIncident;
    private String incidentType;
    private String suspensionDescription;
    private LocalDate incidentDetail;


    public Suspension(int patientId, String patientName, String recentIncident, String incidentType, String suspensionDescription, LocalDate incidentDetail) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.recentIncident = recentIncident;
        this.incidentType = incidentType;
        this.suspensionDescription = suspensionDescription;
        this.incidentDetail = incidentDetail;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getRecentIncident() {
        return recentIncident;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public String getSuspensionDescription() {
        return suspensionDescription;
    }

    public LocalDate getIncidentDetail() {
        return incidentDetail;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setRecentIncident(String recentIncident) {
        this.recentIncident = recentIncident;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public void setSuspensionDescription(String suspensionDescription) {
        this.suspensionDescription = suspensionDescription;
    }

    public void setIncidentDetail(LocalDate incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    @Override
    public String toString() {
        return "Suspension{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", recentIncident='" + recentIncident + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", suspensionDescription='" + suspensionDescription + '\'' +
                ", incidentDetail=" + incidentDetail +
                '}';
    }
}
