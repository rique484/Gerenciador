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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class Customer {
    private static final String SELECT_CL = "select * from clientes where telefone = ?";
    private static final String INSERT_CL = "insert into clientes"
                    + "(nome,cep,endereco,numero,telefone) values(?,?,?,?,?)";
    private Integer idcliente;
    private String nome;
    private Integer cep;
    private String endereco;
    private Integer numero;
    private Integer telefone;

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String enredeco) {
        this.endereco = enredeco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }
    
    public void insertCustomer(){
        
    }
    
    public Boolean search(){
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = SELECT_CL;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, telefone);
            rs = pst.executeQuery();
            if (rs.next()) {
                setIdcliente(rs.getInt(1));
                setNome(rs.getString(2));
                setCep(rs.getInt(3));
                setEndereco(rs.getString(4));
                setNumero(rs.getInt(5));
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
    
    public Boolean cadcliente(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = INSERT_CL;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, cep);
            pst.setString(3, endereco);
            pst.setInt(4, numero);
            pst.setInt(5, telefone);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, Messager.SUSS_CAD);
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
    
}
