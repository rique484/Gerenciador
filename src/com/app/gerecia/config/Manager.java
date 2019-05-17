/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import com.app.gerecia.view.Cashier;
import com.app.gerecia.view.OpenCashier;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
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
    private static final String MANAGER_CASHIER = "select * from caixa where iduser = ? and data = ? and status = 1 ";
    private Integer check = 0;

    public Integer checkADMIN(String user) {
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
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void logData(Integer operador, String log) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "insert into logdata(iduser,descricaolog) values(?,?)";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setString(2, log);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();

            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (HeadlessException | SQLException e) {

        }
    }

    public void checkCashier(Integer operador) {
        Date data = new Date(new java.util.Date().getTime());
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = MANAGER_CASHIER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDate(2, data);
            rs = pst.executeQuery();
            if (rs.next()) {
                new Cashier().setVisible(true);
                conexao.close();
            } else {
                new OpenCashier().setVisible(true);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
