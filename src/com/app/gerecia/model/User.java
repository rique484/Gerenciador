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
public class User {
    
    private String nome;
    private String user;
    private String pass;
    private String cpf;
    private Integer idUser;
    private Integer comissao;
    private Integer status;
    private Integer tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getComissao() {
        return comissao;
    }

    public void setComissao(Integer comissao) {
        this.comissao = comissao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    public Boolean cadastro() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "insert into user(cpf,nome,user,pass,comissao,admin) values(?,?,?,?,?,?)";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setString(3, user);
            pst.setString(4, pass);
            pst.setInt(5, comissao);
            pst.setInt(6, tipo);
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
                JOptionPane.showMessageDialog(null, "Usuario e/ou CPF ja cadastrado !");
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
            return null;
        }
    }
    
    public Boolean consultar() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from user where cpf=?";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            rs = pst.executeQuery();
            if (rs.next()) {
                setNome(rs.getString(3));
                setUser(rs.getString(4));
                setComissao(rs.getInt(6));
                setIdUser(rs.getInt(1));
                setTipo(rs.getInt(7));
                setPass(rs.getString(5));
                return true;
            } else {
                System.out.println("erro");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    public Boolean alterar() {
        Connection conexao = null;
        PreparedStatement pst = null;

        String sql = "update user set cpf=?, nome=?, user=?, pass=?, comissao=? where iduser=?";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setString(3, user);
            pst.setString(4, pass);
            pst.setInt(5, comissao);
            pst.setInt(6, idUser);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                System.out.println("erro");
                JOptionPane.showMessageDialog(null, "Erro");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
}
