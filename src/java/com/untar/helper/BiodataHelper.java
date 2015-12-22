/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.helper;

import com.untar.model.Biodata;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erhem
 */
public class BiodataHelper {
    
    private Connection connection;
    
    public BiodataHelper(Connection connection) {
        this.connection = connection;
    }
    
    public  int insertBiodata(Biodata biodata)  {
        
        int idMember = 0;
        String sql = "INSERT INTO member (username,firstname,lastname,birthdate,"
                +"gender,phoneno,email,createdate,updatedate,password,skill_asp,"
                +"skill_java,skill_php,gpa,city,state,country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, biodata.getUsername());
            ps.setString(2, biodata.getFirstName());
            ps.setString(3, biodata.getLastName());
            ps.setDate(4, new java.sql.Date(biodata.getBirthDate().getTime()));
            ps.setString(5, biodata.getGender());
            ps.setString(6, biodata.getPhoneNumber());
            ps.setString(7, biodata.getEmail());
            ps.setDate(8, new java.sql.Date(biodata.getCreateDate().getTime()));
            ps.setDate(9, new java.sql.Date(biodata.getUpdateDate().getTime()));
            ps.setString(10, biodata.getPassword());
            ps.setString(11, biodata.getSkill_Asp());
            ps.setString(12, biodata.getSkill_Java());
            ps.setString(13, biodata.getSkill_Php());
            ps.setDouble(14, biodata.getGpa());
            ps.setString(15, biodata.getCity());
            ps.setString(16, biodata.getState());
            ps.setString(17, biodata.getCountry());
            int i = ps.executeUpdate();
            connection.commit();
            if (i == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idMember = generatedKeys.getInt("idno");
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            //System.out.println("gender = " + biodata.getGender());
            //System.out.println("skill asp = " + biodata.getSkill_Asp());
            //System.out.println("skill java = " + biodata.getSkill_Java());
            //System.out.println("skill php = " + biodata.getSkill_Php());
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idMember;
    }
    
    
    public int login(Biodata biodata) {
        
        int idNo = 0;
        String sql = "SELECT * FROM member WHERE username = ?  AND password = ?";
        PreparedStatement ps ;
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, biodata.getUsername());
            ps.setString(2, biodata.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                idNo = rs.getInt("idno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idNo;
    }
    
    
    public Biodata getBiodata(int idno) {
        
        Biodata biodata = new Biodata();
        String sql = "SELECT * FROM member WHERE idno = ?";
        PreparedStatement ps;
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, idno);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                biodata.setIdNo(rs.getInt("idno"));
                biodata.setUsername(rs.getString("username"));
                biodata.setPassword(rs.getString("password"));
                biodata.setFirstName(rs.getString("firstname"));
                biodata.setLastName(rs.getString("lastname"));
                biodata.setBirthDate(rs.getDate("birthdate"));
                biodata.setGender(rs.getString("gender"));
                biodata.setPhoneNumber(rs.getString("phoneno"));
                biodata.setEmail(rs.getString("email"));
                biodata.setCreateDate(rs.getDate("createdate"));
                biodata.setUpdateDate(rs.getDate("updatedate"));
                biodata.setSkill_Asp(rs.getString("skill_asp"));
                biodata.setSkill_Java(rs.getString("skill_java"));
                biodata.setSkill_Php(rs.getString("skill_php"));
                biodata.setGpa(Double.valueOf(rs.getString("gpa")));
                biodata.setCity(rs.getString("city"));
                biodata.setState(rs.getString("state"));
                biodata.setCountry(rs.getString("country"));
            }
            /*
            System.out.println("username = " + biodata.getUsername());
            System.out.println("first name = " + biodata.getFirstName());
            System.out.println("last name = " + biodata.getLastName());
            System.out.println("birth date = " + biodata.getBirthDate());
            System.out.println("gender = " + biodata.getGender());
            System.out.println("phone number = " + biodata.getPhoneNumber());
            System.out.println("email = " + biodata.getEmail());
            System.out.println("create date = " + biodata.getCreateDate());
            System.out.println("update date = " + biodata.getUpdateDate());
            System.out.println("skill_asp = " + biodata.getSkill_Asp());
            System.out.println("skill_java = " + biodata.getSkill_Java());
            System.out.println("skill_php = " + biodata.getSkill_Php());
            System.out.println("gpa = " + biodata.getGpa());
            System.out.println("city = " + biodata.getCity());
            System.out.println("state = " + biodata.getState());
            System.out.println("country = " + biodata.getCountry());
            */
            
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return biodata;
    }
    
    
    public boolean update(Biodata biodata) {
        
        boolean success = false;
        String sql = "UPDATE member SET username = ?, firstname = ?, lastname = ?, "+
                "birthdate = ?, gender = ?, phoneno = ?, email = ?, updatedate = ?, "+
                "password = ?, skill_asp = ?, skill_java = ?, skill_php = ?, gpa = ?, "+
                "city = ?, state = ?, country = ? WHERE idno = ?";
        
        PreparedStatement ps ; 
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, biodata.getUsername());
            ps.setString(2, biodata.getFirstName());
            ps.setString(3, biodata.getLastName());
            ps.setDate(4, new java.sql.Date(biodata.getBirthDate().getTime()));
            ps.setString(5, biodata.getGender());
            ps.setString(6, biodata.getPhoneNumber());
            ps.setString(7, biodata.getEmail());
            ps.setDate(8, new java.sql.Date(biodata.getUpdateDate().getTime()));
            ps.setString(9, biodata.getPassword());
            ps.setString(10, biodata.getSkill_Asp());
            ps.setString(11, biodata.getSkill_Java());
            ps.setString(12, biodata.getSkill_Php());
            ps.setDouble(13, biodata.getGpa());
            ps.setString(14, biodata.getCity());
            ps.setString(15, biodata.getState());
            ps.setString(16, biodata.getCountry());
            ps.setInt(17, biodata.getIdNo());
            ps.execute();
            connection.commit();
            success = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    
    public int check_username(String userName) {
        int found = 0;
        String sql = "SELECT * FROM member WHERE username = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                found = 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return found;
    }
    
    public int check_email(String email) {
        int found = 0;
        String sql = "SELECT * FROM member WHERE email = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                found = 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return found;
    }
    
   
    public int insertActivity(Biodata biodata, String title , int idno ) {
        int idActivity = 0;
        String sql = "INSERT INTO activity (id_assigner,title,startdate,enddate,"
                + "description,createdate,updatedate) VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idno);
            ps.setString(2, title);
            ps.setDate(3, new java.sql.Date(biodata.getUpdateDate().getTime()));
            ps.setDate(4, new java.sql.Date(biodata.getUpdateDate().getTime()));
            ps.setString(5, title);
            ps.setDate(6, new java.sql.Date(biodata.getCreateDate().getTime()));
            ps.setDate(7, new java.sql.Date(biodata.getUpdateDate().getTime()));
            int i = ps.executeUpdate();
            connection.commit();
            if (i == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idActivity = generatedKeys.getInt("idno");
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idActivity;
    }
    
    public boolean insertAssigneeActivity(int idMember, int idActivity) {
        boolean success = false;
        String sql = "INSERT INTO assignee_activity (id_activity,id_member) "
                + "VALUES (?,?)";
        
        PreparedStatement ps;
        try {
            ps = connection.prepareCall(sql);
            ps.setInt(1, idActivity);
            ps.setInt(2, idMember);
            ps.execute();
            connection.commit();
            success = true;
            System.out.println("asignee activity");
        } catch (SQLException ex) {
            Logger.getLogger(BiodataHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
