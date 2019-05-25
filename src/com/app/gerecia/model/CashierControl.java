/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.model;

import com.app.gerecia.config.ConfigDB;
import com.app.gerecia.config.Messager;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class CashierControl {

    private static final String OPEN = "insert into caixa(iduser,valor_abertura,data,status)"
            + " values(?,?,?,?)";
    //**************************************************************************** 
    private static final String CHECK = "select data from caixa where iduser=? and status =1";
    //**************************************************************************** 
    private static final String GETSUN = "select sum(valor_total) from pedido "
            + "where status=1 and idcaixa = ? and data = ?";
    //**************************************************************************** 
    private static final String GETSUND = "select sum(valor_total) from delivery "
            + "where status=2 and idcaixa = ? and data = ?";
    //**************************************************************************** 
    private static final String CLOSE = "update caixa set valor_total=?, valor_recolhido=?, status=2 "
            + "where iduser=? and data=?";
    //**************************************************************************** 
    private static final String CHECKREOP = "select data from caixa where iduser=? "
            + "and status =2 and data=?";
    //**************************************************************************** 
    private static final String REOPEM = "update caixa set status=1 "
            + "where iduser=? and data=?";
    //****************************************************************************       
    private Integer id;
    private Integer operador;
    private Double valorAbertura;
    private Double valorFinal;
    private Double valorRec;
    private Date data;
    private Integer status;
//****************************************************************************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperador() {
        return operador;
    }

    public void setOperador(Integer operador) {
        this.operador = operador;
    }

    public Double getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(Double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Double getValorRec() {
        return valorRec;
    }

    public void setValorRec(Double valorRec) {
        this.valorRec = valorRec;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean open() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = OPEN;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDouble(2, valorAbertura);
            pst.setDate(3, data);
            pst.setInt(4, status);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, "Aberto");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean check() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = CHECK;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            rs = pst.executeQuery();
            if (rs.next()) {
                setData(rs.getDate(1));
                JOptionPane.showMessageDialog(null, rs.getDate("data") 
                        + " Aberto!!!");
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Double getSun() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = GETSUN;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDate(2, data);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            } else {
                return 0.0;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Double getSunD() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = GETSUND;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDate(2, data);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            } else {
                return 0.0;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean close(Double valot, Double valorc, Integer operador, Date data) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CLOSE;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valot);
            pst.setDouble(2, valorc);
            pst.setInt(3, operador);
            pst.setDate(4, data);
            int add = pst.executeUpdate();
            if (add > 0) {
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean checkReOpen(Integer operador) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = CHECKREOP;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDate(2, Date.valueOf(LocalDate.now()));
            rs = pst.executeQuery();
            if (rs.next()) {
                setData(rs.getDate(1));
                JOptionPane.showMessageDialog(null, rs.getDate("data") 
                        + Messager.CHECK_REOPEN);
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean reOpen(Integer operador, Date data) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = REOPEM;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, operador);
            pst.setDate(2, data);
            int add = pst.executeUpdate();
            if (add > 0) {
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
