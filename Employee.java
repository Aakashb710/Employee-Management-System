package com.example.test.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Employee-Details")
public class Employee
{
    @Id
    @Column(name = "Emp-Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "Emp-Firstname")
    private String firstname;

    @Column(name = "Emp-Middlename")
    private String middlename;

    @Column(name = "Emp-Lastname")
    private String lastname;

    @Column(name = "Emp-address")
    private String address;

    @Column(name = "Emp-Jobrole")
    private String jobrole;

    @Column(name = "Emp-Gender")
    private String gender;

    @Column(name = "Emp-Phone")
    private String phoneNo;

    @Column(name = "Emp-MaritalStatus")
    private String maritalStatus;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getMiddlename() {
        return middlename;
    }
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }


    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String getJobrole() {
        return jobrole;
    }
    public void setJobrole(String jobrole) {
        this.jobrole = jobrole;
    }


    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }



    public Employee(int id, String firstname, String middlename, String lastname, String address, String jobrole, String gender, String phoneNo, String maritalStatus) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address = address;
        this.jobrole = jobrole;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.maritalStatus = maritalStatus;
    }


    public Employee() {
        super();
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", jobrole='" + jobrole + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}
