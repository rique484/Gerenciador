/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

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
public class Manager {
    private static final String MANAGER_ADM = "select * from user where iduser=? ";
    private Integer check = 0;
    public Integer checkADMIN(String user){
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = MANAGER_ADM;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user);
            rs = pst.executeQuery();
            if (rs.next()) { 
                check = rs.getInt(7);
                conexao.close();
                return check;
            } else {
                return check;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
    
}
