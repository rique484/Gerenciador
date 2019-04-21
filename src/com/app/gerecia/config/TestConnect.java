/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class TestConnect {
        public boolean testC(){
        Connection conexao = null;
        conexao = new ConfigDB().conector();   
        try {
           if(conexao !=null){  
            conexao.close();
            return true;
        }else{
            JOptionPane.showMessageDialog(null, Messager.FAIL_CONN , "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
           } 
        } catch (HeadlessException | SQLException e) {
            
            return false;
        }
    }
}
