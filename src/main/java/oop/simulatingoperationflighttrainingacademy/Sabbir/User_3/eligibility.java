package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import java.io.Serializable;

public class eligibility implements Serializable {
    private String studentId;
    private String examName;
    private String eligibilityStatus;
    private String remarks;

    public eligibility(String studentId, String studentName, String examName, String eligibilityStatus) {
        this.studentId = studentId;
        this.examName = examName;
        this.eligibilityStatus = eligibilityStatus;
        this.remarks = remarks;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getEligibilityStatus() {
        return eligibilityStatus;
    }

    public void setEligibilityStatus(String eligibilityStatus) {
        this.eligibilityStatus = eligibilityStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "eligibility{" +
                "studentId='" + studentId + '\'' +
                ", examName='" + examName + '\'' +
                ", eligibilityStatus='" + eligibilityStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
