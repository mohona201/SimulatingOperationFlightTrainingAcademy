package oop.simulatingoperationflighttrainingacademy.Madhu.User_1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MedicalCheckUp {
    private String doctorName,appointmentType,timeSlot;
    private LocalDate appointmentDate;
    private LocalDateTime appointmentTime;


    public MedicalCheckUp(String doctorName, String appointmentType, String timeSlot, LocalDate appointmentDate, LocalDateTime appointmentTime) {
        this.doctorName = doctorName;
        this.appointmentType = appointmentType;
        this.timeSlot = timeSlot;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "MedicalCheckUp{" +
                "doctorName='" + doctorName + '\'' +
                ", appointmentType='" + appointmentType + '\'' +
                ", timeSlot='" + timeSlot + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
}
