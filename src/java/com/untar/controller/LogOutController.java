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
public class LogOutController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        DBConn dbConn = null;
        try {
            dbConn = new DBConn();
            BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
            HttpSession session = request.getSession();
            int idNo = (int) session.getAttribute("sessionlogin");
            Biodata member = biodataHelper.getBiodata(idNo);
            int idActivity = biodataHelper.insertActivity(member, "Logout", idNo);
            if(biodataHelper.insertAssigneeActivity(idNo, idActivity)) {
                session.removeAttribute("sessionlogin");
                RequestDispatcher rd = request.getRequestDispatcher("MemberArea");
                rd.forward(request, response);
            } 
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogOutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogOutController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConn();
        }
        
    }
}
