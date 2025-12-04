package oop.simulatingoperationflighttrainingacademy;

public class studentData {
    public String studentId;
    public String studentName;
    public Integer completedHours;
    public String endorsementStatus;
    public String feeStatus;
    public String medicalStatus;

    public studentData(String studentId, String studentName, Integer completedHours, String endorsementStatus, String feeStatus, String medicalStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.completedHours = completedHours;
        this.endorsementStatus = endorsementStatus;
        this.feeStatus = feeStatus;
        this.medicalStatus = medicalStatus;
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

    public Integer getCompletedHours() {
        return completedHours;
    }

    public void setCompletedHours(Integer completedHours) {
        this.completedHours = completedHours;
    }

    public String getEndorsementStatus() {
        return endorsementStatus;
    }

    public void setEndorsementStatus(String endorsementStatus) {
        this.endorsementStatus = endorsementStatus;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    @Override
    public String toString() {
        return "studentData{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", completedHours=" + completedHours +
                ", endorsementStatus='" + endorsementStatus + '\'' +
                ", feeStatus='" + feeStatus + '\'' +
                ", medicalStatus='" + medicalStatus + '\'' +
                '}';
    }
}
