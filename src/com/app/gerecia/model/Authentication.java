/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.model;

import com.app.gerecia.config.ConfigDB;
import com.app.gerecia.config.TempFileUser;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class Authentication {
    
     private static final String USER_OR_PASS_ERR = "Usuario e/ou senha invalido(s)";
    
    public Boolean auth(String user,String pass){
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from user where user=? and pass=? ";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) { 
                String temp = String.valueOf(rs.getInt(1));
                new TempFileUser().tempWriterUser(temp);
                conexao.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null,USER_OR_PASS_ERR);
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            return null;
        }
    }
    
}
