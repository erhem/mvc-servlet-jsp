/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.controller;

import com.untar.connection.DBConn;
import com.untar.helper.BiodataHelper;
import com.untar.model.Biodata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erhem
 */
public class RegistrationConfirmController extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate_string = request.getParameter("birthDate");
        String city =  request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String gpa = request.getParameter("gpa");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String skill_asp = request.getParameter("skill_asp");
        String skill_java = request.getParameter("skill_java");
        String skill_php = request.getParameter("skill_php");
        //String createDate_string = request.getParameter("createDate");
        //String updateDate_string = request.getParameter("updateDate");
        //String currentDate_string = request.getParameter("currentDate");
        
        // source : http://stackoverflow.com/questions/5687826/convert-mm-dd-yyyy-to-yyyy-mm-dd
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
        java.util.Date birthDate = null;
        try {
            birthDate = formatter.parse(birthDate_string);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Convert from string to java.sql.Date
        // source : http://stackoverflow.com/questions/17647474/convert-string-to-sql-date
        //java.sql.Date SqlBirthDate = java.sql.Date.valueOf(sqlBirthDate_string);
        //java.sql.Date CurrentDate = java.sql.Date.valueOf(currentDate_string);
        //System.out.println("birth date string = " + birthDate_string);
        
        // Get Current Time in ICT (Indo China Time)
        DateFormat formatter2 = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
        java.util.Date date = new java.util.Date();
        formatter2.setTimeZone(TimeZone.getTimeZone("Asia/Bangkok"));
        java.util.Date CurrentDate = null;
        try {
            CurrentDate = (java.util.Date) formatter2.parse(date.toString());
            //System.out.println("Current Date = " + CurrentDate);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Biodata biodata = new Biodata();
        biodata.setUsername(userName);
        biodata.setFirstName(firstName);
        biodata.setLastName(lastName);
        biodata.setBirthDate(birthDate);
        biodata.setCreateDate(CurrentDate);
        biodata.setUpdateDate(CurrentDate);
        biodata.setCity(city);
        biodata.setState(state);
        biodata.setCountry(country);
        biodata.setGpa(Double.valueOf(gpa));
        biodata.setGender(gender);
        biodata.setPhoneNumber(phoneNumber);
        biodata.setEmail(email);
        biodata.setPassword(password);
        biodata.setSkill_Asp(skill_asp);
        biodata.setSkill_Java(skill_java);
        biodata.setSkill_Php(skill_php);
        
        DBConn dbConn = null;
        
        try {
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            //System.out.println("insert biodata = " + biodataHelper.insertBiodata(biodata));
            RequestDispatcher rd = null;
            int idMember = biodataHelper.insertBiodata(biodata);
            if(idMember != 0) {
                int idActivity = biodataHelper.insertActivity(biodata, "Register", idMember);
                if(biodataHelper.insertAssigneeActivity(idMember, idActivity)) {
                    request.setAttribute("msg", "Successfully Registered");
                    rd = request.getRequestDispatcher("MemberArea");
                }    
            } else {
                request.setAttribute("from", "register");
                request.setAttribute("msg", "Registration Failed ! Please check your data");
                rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
            }
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrationConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrationConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        }
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editprofile.jsp");
        //rd.forward(request, response);        
    }
}


/*
            PrintWriter out = response.getWriter();
            out.println("username = " + userName);
            out.println("firstName = " + firstName);
            out.println("lastName = " + lastName);
            out.println("birthDate = " + birthDate);
            out.println("createDate = " + createDate);
            out.println("updateDate = " + updateDate);
            out.println("city = " + city);
            out.println("state = " + state);
            out.println("country = " + country);
            out.println("gpa= " + gpa);
            out.println("gender = " + gender);
            out.println("phone number = " + phoneNumber);
            out.println("email = " + email);
            out.println("password = " + password);
            out.println("skill_asp = " + skill_asp);
            out.println("skill_java = " + skill_java);
            out.println("skill_php = " + skill_php);
        */ 
        
