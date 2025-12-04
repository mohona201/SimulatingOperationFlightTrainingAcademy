package oop.simulatingoperationflighttrainingacademy.Sabbir.User_3;

import java.io.Serializable;

public class examCandidate implements Serializable {
    private String studentId;
    private String studentName;
    private String exam;

    public examCandidate(String studentId, String studentName, String exam) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.exam = exam;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getExam() {
        return exam;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "examCandidate{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", exam='" + exam + '\'' +
                '}';
    }
}
