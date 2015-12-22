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
public class EditProfileConfirmController extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String idNo = request.getParameter("idNo");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate_string = request.getParameter("birthDate");
        String createDate_string = request.getParameter("createDate");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String skill_asp = request.getParameter("skill_asp");
        String skill_java = request.getParameter("skill_java");
        String skill_php = request.getParameter("skill_php");
        String gpa = request.getParameter("gpa");
        String country = request.getParameter("country");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        
        //String currentDate = request.getParameter("currentDate");
        
        
        // source : http://stackoverflow.com/questions/5687826/convert-mm-dd-yyyy-to-yyyy-mm-dd
        DateFormat formatter = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
        java.util.Date birthDate = null;
        java.util.Date createDate = null;
        try {
            birthDate = formatter.parse(birthDate_string);
            createDate = formatter.parse(createDate_string);
        } catch (ParseException ex) {
            Logger.getLogger(RegistrationConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        biodata.setIdNo(Integer.valueOf(idNo));
        biodata.setUsername(userName);
        biodata.setPassword(password);
        biodata.setFirstName(firstName);
        biodata.setLastName(lastName);
        biodata.setBirthDate(birthDate);
        biodata.setGender(gender);
        biodata.setPhoneNumber(phoneNumber);
        biodata.setEmail(email);
        biodata.setSkill_Asp(skill_asp);
        biodata.setSkill_Java(skill_java);
        biodata.setSkill_Php(skill_php);
        biodata.setGpa(Double.valueOf(gpa));
        biodata.setCountry(country);
        biodata.setState(state);
        biodata.setCity(city);
        biodata.setCreateDate(createDate);
        biodata.setUpdateDate(CurrentDate);
        System.out.println("Edit confirm = " + biodata.getUpdateDate());
        
        DBConn dbConn = null;
        try {
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            RequestDispatcher rd ; 
            if(biodataHelper.update(biodata)) {
                int idMember = Integer.valueOf(idNo);
                int idActivity = biodataHelper.insertActivity(biodata, "Update",idMember );
                if(biodataHelper.insertAssigneeActivity(idMember, idActivity)) {
                    request.setAttribute("success", "1");
                    request.setAttribute("msg", "Successfully Updated");
                }   
            } else {
                request.setAttribute("success", "0");
                request.setAttribute("msg", "Update Failed");
            }
            rd = request.getRequestDispatcher("MemberArea");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProfileConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileConfirmController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        }
    }
}


/*
        PrintWriter out = response.getWriter();
        out.println("idNo = " + idNo);
        out.println("userName = " + userName);
        out.println("password = " + password);
        out.println("firstName = " + firstName);
        out.println("lastName = " + lastName);
        out.println("birthDate = " + birthDate);
        out.println("gender = " + gender);
        out.println("phoneNumber = " + phoneNumber);
        out.println("email = " + email);
        out.println("skill_asp = " + skill_asp);
        out.println("skill_java = " + skill_java);
        out.println("skill_php = " + skill_php);
        out.println("gpa = " + gpa);
        out.println("country = " + country);
        out.println("state = " + state);
        out.println("city = " + city);
        out.println("Current date = " + CurrentDate);
*/


/*
        PrintWriter out = response.getWriter();
        out.println("idNo = " + biodata.getIdNo());
        out.println("userName = " + biodata.getUsername());
        out.println("password = " + biodata.getPassword());
        out.println("firstName = " + biodata.getFirstName());
        out.println("lastName = " + biodata.getLastName());
        out.println("birthDate = " + biodata.getBirthDate());
        out.println("gender = " + biodata.getGender());
        out.println("phoneNumber = " + biodata.getPhoneNumber());
        out.println("email = " + biodata.getEmail());
        out.println("skill_asp = " + biodata.getSkill_Asp());
        out.println("skill_java = " + biodata.getSkill_Java());
        out.println("skill_php = " + biodata.getSkill_Php());
        out.println("gpa = " + biodata.getGpa());
        out.println("country = " + biodata.getCountry());
        out.println("state = " + biodata.getState());
        out.println("city = " + biodata.getCity());
        out.println("update date = " + biodata.getUpdateDate());
*/