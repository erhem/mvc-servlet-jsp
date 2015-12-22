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
public class LoginController extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Biodata biodata = new Biodata();
        biodata.setUsername(userName);
        biodata.setPassword(password);
        
        DBConn dbConn = null;
        try {
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            //System.out.println("login = " + biodataHelper.login(biodata));
            RequestDispatcher rd ;
            int idNo = biodataHelper.login(biodata);
            Biodata member = biodataHelper.getBiodata(idNo);
            if(idNo != 0) {
                int idActivity = biodataHelper.insertActivity(member, "Login", idNo);
                if(biodataHelper.insertAssigneeActivity(idNo, idActivity)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("sessionlogin", idNo); 
                } 
            } else {
                request.setAttribute("from", "login");
                request.setAttribute("msg", "Username/Password salah");
            }
            rd = request.getRequestDispatcher("MemberArea");
            rd.forward(request, response);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("MemberArea");
        rd.forward(request, response);
    }
    
}


/*
                PrintWriter out = response.getWriter();
                out.println("idno = " + member.getIdNo());
                out.println("userName = " +  member.getUsername());
                out.println("password = " + member.getPassword());
                out.println("firstName = " + member.getFirstName());
                out.println("lastName = " + member.getLastName());
                out.println("birthDate = " + member.getBirthDate());
                out.println("create date = " + member.getCreateDate());
                out.println("update date = " + member.getUpdateDate());
                out.println("gender = " +  member.getGender());
                out.println("phoneNo = " + member.getPhoneNumber());
                out.println("city = " + member.getCity());
                out.println("state = " + member.getState());
                out.println("country = " + member.getCountry());
                out.println("gpa = " + member.getGpa());
                out.println("email = " + member.getEmail());
                out.println("skill_asp = " + member.getSkill_Asp());
                out.println("skill_java = " + member.getSkill_Java());
                out.println("skill_php = " + member.getSkill_Php());
                */