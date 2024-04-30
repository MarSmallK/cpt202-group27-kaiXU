/*package com.example.demo.pojo;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@Entity
public class i_appointment {
    private String customerName;
    private String telephoneNumber;
    private Integer appointedTrainerID;
    private LocalDateTime appointedTime;

    public i_appointment() {
    }

    public i_appointment(String customerName, String telephoneNumber, Integer appointedTrainerID, LocalDateTime appointedTime) {
        this.customerName = customerName;
        this.telephoneNumber = telephoneNumber;
        this.appointedTrainerID = appointedTrainerID;
        this.appointedTime = appointedTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getAppointedTrainerID() {
        return appointedTrainerID;
    }

    public void setAppointedTrainerID(Integer appointedTrainerID) {
        this.appointedTrainerID = appointedTrainerID;
    }

    public LocalDateTime getAppointedTime() {
        return appointedTime;
    }

    public void setAppointedTime(LocalDateTime appointedTime) {
        this.appointedTime = appointedTime;
    }

    @Override
    public String toString() {
        return "i_appointment{" +
                "customerName='" + customerName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", appointedTrainerID=" + appointedTrainerID +
                ", appointedTime=" + appointedTime +
                '}';
    }
}*/
package group27.xukai.cpt202b.entity;

import java.time.LocalDateTime;

public class IndividualAppointment {

    private Integer AppointmentID;

    private Integer MemberID;
    private String MemberName;

    private Integer AppointedTrainerID;
   private LocalDateTime AppointedTime;

    public IndividualAppointment() {}

    public IndividualAppointment(Integer appointmentID, Integer memberID, String memberName, Integer appointedTrainerID,LocalDateTime appointedTime)
    {
        AppointmentID = appointmentID;
        MemberID = memberID;
        MemberName = memberName;
        AppointedTrainerID = appointedTrainerID;
       AppointedTime = appointedTime;
    }

    public Integer getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        AppointmentID = appointmentID;
    }

    public Integer getMemberID() {
        return MemberID;
    }

    public void setMemberID(Integer memberID) {
        MemberID = memberID;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public Integer getAppointedTrainerID() {
        return AppointedTrainerID;
    }

    public void setAppointedTrainerID(Integer appointedTrainerID) {
        AppointedTrainerID = appointedTrainerID;
    }

   public LocalDateTime getAppointedTime() {
        return AppointedTime;
    }

    public void setAppointedTime(LocalDateTime appointedTime) {
        AppointedTime = appointedTime;
    }

    @Override
    public String toString() {
        return "i_appointment{" +
                "AppointmentID=" + AppointmentID +
                ", MemberID=" + MemberID +
                ", MemberName='" + MemberName + '\'' +
                ", AppointedTrainerID=" + AppointedTrainerID
                +
                ", AppointedTime=" + AppointedTime +
                '}';

    }


}
