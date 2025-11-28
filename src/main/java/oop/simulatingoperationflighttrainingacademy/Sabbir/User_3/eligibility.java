package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

public class eligibility {
    private String studentId;
    private String studentName;
    private String examName;
    private String eligibilityStatus;
    private String remarks;

    public eligibility(String studentId, String studentName, String examName, String eligibilityStatus, String remarks) {
        this.studentId = studentId;
        this.studentName = studentName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
                ", studentName='" + studentName + '\'' +
                ", examName='" + examName + '\'' +
                ", eligibilityStatus='" + eligibilityStatus + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
