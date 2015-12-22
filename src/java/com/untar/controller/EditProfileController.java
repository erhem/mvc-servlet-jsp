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
import javax.servlet.http.HttpSession;

/**
 *
 * @author erhem
 */
public class EditProfileController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer idNo = (Integer) session.getAttribute("sessionlogin");
        DBConn dbConn = null;
        try {
            
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            Biodata biodata = biodataHelper.getBiodata(idNo);
            request.setAttribute("member", biodata);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editprofile.jsp");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        } 
        
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String idNo = request.getParameter("idNo");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate_string = request.getParameter("birthDate");
        String createDate_string = request.getParameter("createDate");
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
        
        System.out.println("create date string = " + createDate_string);
        // source : http://stackoverflow.com/questions/5687826/convert-mm-dd-yyyy-to-yyyy-mm-dd
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date birthDate = null;
        java.util.Date createDate = null;
        try {
            birthDate = formatter.parse(birthDate_string);
            createDate = formatter2.parse(createDate_string);
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
        biodata.setIdNo(Integer.valueOf(idNo));
        biodata.setUsername(userName);
        biodata.setPassword(password);
        biodata.setFirstName(firstName);
        biodata.setLastName(lastName);
        biodata.setBirthDate(birthDate);
        biodata.setCreateDate(createDate);
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
        //biodata.setUpdateDate(CurrentDate);
        
        request.setAttribute("member", biodata);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editprofile_confirm.jsp");
        rd.forward(request, response);
    }
}


        /*
        PrintWriter out = response.getWriter();
        out.println("idNo = " + idNo);
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
        out.println("skill_asp = " + skill_asp);
        out.println("skill java = " + skill_java);
        out.println("skill php = " + skill_php);
        out.println("current date = " + CurrentDate);
        */

        /*
        PrintWriter out = response.getWriter();
        out.println("idNo = " + biodata.getIdNo());
        out.println("userName = " +  biodata.getUsername());
        out.println("password = " + biodata.getPassword());
        out.println("firstName = " + biodata.getFirstName());
        out.println("lastName = " + biodata.getLastName());
        out.println("birthDate = " + biodata.getBirthDate());
        out.println("gender = " +  biodata.getGender());
        out.println("phoneNo = " + biodata.getPhoneNumber());
        out.println("city = " + biodata.getCity());
        out.println("state = " + biodata.getState());
        out.println("country = " + biodata.getCountry());
        out.println("gpa = " + biodata.getGpa());
        out.println("email = " + biodata.getEmail());
        out.println("skill_asp = " + biodata.getSkill_Asp());
        out.println("skill java = " + biodata.getSkill_Java());
        out.println("skill php = " + biodata.getSkill_Php());
        out.println("current date = " + biodata.getUpdateDate());
        */