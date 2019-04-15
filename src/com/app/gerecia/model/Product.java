/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.model;

import com.app.gerecia.config.ConfigDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    
    
    public ResultSet advancedSearch(String busca){
                Connection conexao = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                String sql = "select * from produto where idproduto = ?";
            try {
                conexao = new ConfigDB().conector();
                pst = conexao.prepareStatement(sql);
                pst.setString(1,busca+"%"); 
                rs = pst.executeQuery();   
                //conexao.close();
                return rs; 
            } catch (SQLException e) {
                return null;
            }
    }
}
