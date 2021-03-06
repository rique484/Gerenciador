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
public class User {

    private static final String CADASTRO = "insert into "
            + "user(cpf,nome,user,pass,comissao,admin) values(?,?,?,?,?,?)";
    //****************************************************************************
    private static final String CONSULTA = "select * from user where cpf=?";
    //****************************************************************************
    private static final String ALTERAR = "update user set cpf=?, nome=?, user=?,"
            + " pass=?, comissao=?, admin=?, status=? where iduser=?";
    //****************************************************************************

    private String nome;
    private String user;
    private String pass;
    private String cpf;
    private Integer idUser;
    private Integer comissao;
    private Integer status;
    private Integer tipo;

    //****************************************************************************
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
        String sql = CADASTRO;
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
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            String err = e.toString();
            if (err.contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, Messager.USER_DUPLI);
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
            return false;
        }
    }

    public Boolean consultar() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = CONSULTA;
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
                setStatus(rs.getInt(8));
                return true;
            } else {
                System.out.println("erro");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Boolean alterar() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ALTERAR;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.setString(2, nome);
            pst.setString(3, user);
            pst.setString(4, pass);
            pst.setInt(5, comissao);
            pst.setInt(6, tipo);
            pst.setInt(7, status);
            pst.setInt(8, idUser);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                System.out.println("erro");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Boolean consultarViaId(Integer id) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from user where iduser=?";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                setNome(rs.getString(3));
                setUser(rs.getString(4));
                setComissao(rs.getInt(6));
                setIdUser(rs.getInt(1));
                setTipo(rs.getInt(7));
                setPass(rs.getString(5));
                setStatus(rs.getInt(8));
                return true;
            } else {
                System.out.println("erro");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

}
