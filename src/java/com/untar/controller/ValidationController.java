/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.controller;

import com.untar.connection.DBConn;
import com.untar.helper.BiodataHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author erhem
 */
public class ValidationController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        
        int status = Integer.parseInt(request.getParameter("status"));
        //System.out.println("userName = " + userName);
        //System.out.println("status = " + status);
        DBConn dbConn = null;
        try {
            PrintWriter out = response.getWriter();
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            
            if(status == 1) { // check username (registration)
                String userName = request.getParameter("userName");
                out.print(biodataHelper.check_username(userName));
            } else if(status == 2) { // check email (registration)
                String email = request.getParameter("email");
                out.print(biodataHelper.check_email(email));
            } else if(status == 3) {
                String userName = request.getParameter("userName");
                String currentuserName = request.getParameter("currentuserName");
                if(userName.equals(currentuserName)) {
                    out.print(0);
                } else {
                    out.print(biodataHelper.check_username(userName));
                }
            } else if(status == 4) {
                String email = request.getParameter("email");
                String currentemail = request.getParameter("currentemail");
                if(email.equals(currentemail)) {
                    out.print(0);
                } else {
                    out.print(biodataHelper.check_email(email));
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ValidationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ValidationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ValidationController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        }
    }
}
