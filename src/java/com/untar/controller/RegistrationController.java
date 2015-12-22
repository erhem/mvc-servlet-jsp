/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.controller;

import com.untar.model.Biodata;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
public class RegistrationController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register.jsp");
        rd.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate_string = request.getParameter("birthDate");
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String gpa = request.getParameter("gpa");
        String email = request.getParameter("email");
        String skill_asp= request.getParameter("skill_asp");
        String skill_java = request.getParameter("skill_java");
        String skill_php = request.getParameter("skill_php");
        
        
        // source : http://stackoverflow.com/questions/5687826/convert-mm-dd-yyyy-to-yyyy-mm-dd
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date birthDate = null;
        try {
            birthDate = formatter.parse(birthDate_string);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
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
        */
         
        
        Biodata biodata = new Biodata();
        biodata.setUsername(userName);
        biodata.setPassword(password);
        biodata.setFirstName(firstName);
        biodata.setLastName(lastName);
        biodata.setBirthDate(birthDate);
        biodata.setGender(gender);
        biodata.setPhoneNumber(phoneNo);
        biodata.setCity(city);
        biodata.setState(state);
        biodata.setCountry("Indonesia");
        biodata.setGpa(Double.valueOf(gpa));
        biodata.setEmail(email);
        biodata.setSkill_Asp(skill_asp);
        biodata.setSkill_Java(skill_java);
        biodata.setSkill_Php(skill_php);
        //biodata.setCreateDate(CurrentDate);
        //biodata.setUpdateDate(CurrentDate);
        //biodata.setCurrentDate(new java.sql.Date(System.currentTimeMillis()));
        //biodata.setSqlBirthDate(new java.sql.Date(birthDate.getTime()));
        
        request.setAttribute("biodata", biodata);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/register_confirm.jsp");
        rd.forward(request, response);
    }
    
}

/*
        PrintWriter out = response.getWriter();
        out.println("userName = " +  userName);
        out.println("password = " + password);
        out.println("firstName = " + firstName);
        out.println("lastName = " + lastName);
        out.println("birthDate = " + birthDate);
        out.println("gender = " +  gender);
        out.println("phoneNo = " + phoneNo);
        out.println("city = " + city);
        out.println("state = " + state);
        out.println("country = " + country);
        out.println("gpa = " + gpa);
        out.println("email = " + email);
        out.println("skill_asp_string = " + skill_asp_string);
        out.println("skill_java_string = " + skill_java_string);
        out.println("skill_php_string = " + skill_php_string);
        out.println("skill_asp = " + skill_asp);
        out.println("skill java = " + skill_java);
        out.println("skill php = " + skill_php);
        */