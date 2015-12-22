/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erhem
 */
public class Biodata {
    private Integer idNo;
    private String Username;
    private String FirstName;
    private String LastName;
    private String Password;
    private Date BirthDate;
    private Date CreateDate;
    private Date UpdateDate;
    private String Gender;
    private String PhoneNumber;
    private String City;
    private String State;
    private String Country;
    private double Gpa;
    private String Email;
    private String Skill_Java;
    private String Skill_Php;
    private String Skill_Asp;
    //private java.sql.Date SqlBirthDate;
    //private java.sql.Date CurrentDate;
    
    public Biodata() {
        
    }

    public Biodata(Integer idNo, String Username, String FirstName, String LastName, String Password, Date BirthDate, Date CreateDate, Date UpdateDate, String Gender, String PhoneNumber, String City, String State, String Country, double Gpa, String Email, String Skill_Java, String Skill_Php, String Skill_Asp) {
        this.idNo = idNo;
        this.Username = Username;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.BirthDate = BirthDate;
        this.CreateDate = CreateDate;
        this.UpdateDate = UpdateDate;
        this.Gender = Gender;
        this.PhoneNumber = PhoneNumber;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.Gpa = Gpa;
        this.Email = Email;
        this.Skill_Java = Skill_Java;
        this.Skill_Php = Skill_Php;
        this.Skill_Asp = Skill_Asp;
    }


    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date UpdateDate) {
        this.UpdateDate = UpdateDate;
    }
    
    public Integer getIdNo() {
        return idNo;
    }

    public void setIdNo(Integer idNo) {
        this.idNo = idNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public double getGpa() {
        return Gpa;
    }

    public void setGpa(double Gpa) {
        this.Gpa = Gpa;
    }

    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getSkill_Java() {
        return Skill_Java;
    }

    public void setSkill_Java(String Skill_Java) {
        this.Skill_Java = Skill_Java;
    }

    public String getSkill_Php() {
        return Skill_Php;
    }

    public void setSkill_Php(String Skill_Php) {
        this.Skill_Php = Skill_Php;
    }

    public String getSkill_Asp() {
        return Skill_Asp;
    }

    public void setSkill_Asp(String Skill_Asp) {
        this.Skill_Asp = Skill_Asp;
    }
    
    /*
    public java.sql.Date getSqlBirthDate() {
        java.sql.Date birthDate = new java.sql.Date(BirthDate.getTime());
        return birthDate;
    }
    
    public java.sql.Date getCurrentDate() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        return date;
    }
    

    public java.sql.Date getSqlBirthDate() {
        return SqlBirthDate;
    }

    public void setSqlBirthDate(java.sql.Date SqlBirthDate) {
        this.SqlBirthDate = SqlBirthDate;
    }

    public java.sql.Date getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(java.sql.Date CurrentDate) {
        this.CurrentDate = CurrentDate;
    }
    */
}
