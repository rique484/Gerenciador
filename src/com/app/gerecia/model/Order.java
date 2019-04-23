/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.model;

import com.app.gerecia.config.ConfigDB;
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
public class Order {

    
    private static final String SELECT_ORDER = "select * from pedido where "
            + "num_comanda=? AND status=0 ";
    private static final String INSERT_ORDER = "insert into venda(valor,quanti"
            + "dade,idproduto,idpedido,iduser,status_preparo) values(?,?,?,?,?,?)";
    private static final String CREATE_ORDER = "insert into pedido(num_comanda,"
            + "status) values(?,0)";
    
    
    private Integer numero_comanda;
    private Double valor_total;
    private Integer status;
    private Integer id;
    private Integer status_preparo;
 
    public Integer getNumero_comanda() {
        return numero_comanda;
    }

    public void setNumero_comanda(Integer numero_comanda) {
        this.numero_comanda = numero_comanda;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus_preparo() {
        return status_preparo;
    }

    public void setStatus_preparo(Integer status_preparo) {
        this.status_preparo = status_preparo;
    }

    public Boolean consulta() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = SELECT_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_comanda);
            rs = pst.executeQuery();
            if (rs.next()) {
                setId(rs.getInt(1));
                setNumero_comanda(rs.getInt(2));
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e); 
            return false;
        }
    }
    
    public Boolean orderInsert(Double valor,Integer quantidade,Integer idproduto
            ,Integer idpedido,Integer iduser,Integer status_preparo){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = INSERT_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, quantidade);
            pst.setInt(3, idproduto);
            pst.setInt(4, idpedido);
            pst.setInt(5, iduser);
            pst.setInt(6, status_preparo);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
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
    
    public Boolean orderCreate(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CREATE_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_comanda);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }
}
