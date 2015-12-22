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
public class MemberAreaController extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Integer sessionlogin = (Integer) session.getAttribute("sessionlogin");
        RequestDispatcher rd = null;
        
        if(sessionlogin != null) {
            DBConn dbConn = null;
            try {
                
                dbConn = new DBConn();
                BiodataHelper biodataHelper = new BiodataHelper(dbConn.getConn());
                Biodata member = biodataHelper.getBiodata(sessionlogin);
                request.setAttribute("member", member);
                rd = request.getRequestDispatcher("/WEB-INF/jsp/memberarea.jsp");
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MemberAreaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MemberAreaController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                dbConn.closeConn();
            }
            
        } else {
            rd = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        }
        rd.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("dari login controller");
        doGet(request,response);
    }
}
