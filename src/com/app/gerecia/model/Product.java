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
public class Product {
    private Integer id;
    private String nome;
    private Double valor;
    private String codBar;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCodBar() {
        return codBar;
    }

    public void setCodBar(String codBar) {
        this.codBar = codBar;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Boolean cadastroProduto(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "insert into produto(nome,valor_unt,cod_bar,status) values(?,?,?,?)";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setDouble(2, valor);
            pst.setString(3, codBar);
            pst.setInt(4, status);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            String err = e.toString();
            if (err.contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Nome do produto ja cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
            return false;
        }
    }
    
    public ResultSet advancedSearch(String busca){
                Connection conexao = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                String sql = "select * from produto where idproduto like ? or cod_bar = ?";   
            try {
                conexao = new ConfigDB().conector();
                pst = conexao.prepareStatement(sql);
                pst.setString(1,busca+"%"); 
                pst.setString(2,busca);
                rs = pst.executeQuery();   
                return rs; 
            } catch (SQLException e) {
                return null; 
            }     
    }
}
