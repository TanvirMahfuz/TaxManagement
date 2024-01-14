package com.example.demo.JavaClasses;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
@Component
@Entity
public class User {

    @Id
    int id;
    private int taxId;

    public int getTaxId() {
        return taxId;
    }

    public void setTaxId(int taxId) {
        this.taxId = taxId;
    }


    @Column(name="UserName")
    String name;


    @ManyToOne
    @JoinColumn(name = "lawyerID")
    Lawyer lawyer;

    public Lawyer getLawyer() {
        return lawyer;
    }
    @ManyToOne
    @JoinColumn(name = "adminID")
    Admin admin;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLawyer(Lawyer lawyer){
        this.lawyer=lawyer;
        lawyer.addUsers(this);
    }

    String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    private String gender="unknown";
    private String phone="unknown";
    private String nationality="unknown";
    private String Religion="unknown";
    private String division="unknown";
    private String city="unknown";
    private String zipcode="unknown";

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String religion) {
        Religion = religion;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}