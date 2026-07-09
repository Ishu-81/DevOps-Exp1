package com.example.registration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int age;
    private String dob;
    private String college;
    private String department;
    private String year;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String emergency;
    private String gender;
    private String address;
    private String notes;

    public User(){}

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname=firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname=lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone=phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob=dob;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college=college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department=department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year=year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state=state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country=country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode=pincode;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency=emergency;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender=gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes=notes;
    }

}