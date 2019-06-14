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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class Categ {

    private static final String CONSULTA = "select * from categorias order by idcategorias";
    
    private static final String CADASTRO = "insert into categorias"
            + "(tipo) values(?)";
    
    private static final String ALTERAR = "update categorias set tipo=? "
            + "where idcategorias=?";
    
    private Integer id;
    private String categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List consultaCatogoria() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = CONSULTA;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            List<String> list = new ArrayList<>();
            list.add("");
            while (rs.next()) {
                list.add(rs.getString(1)+" - "+rs.getString(2));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public void cadCateg(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CADASTRO;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, categoria);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                JOptionPane.showMessageDialog(null, Messager.SUSS_CAD);
            } 
        } catch (HeadlessException | SQLException e) {
            String err = e.toString();
            if (err.contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, Messager.ITEM_DUPLI);
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void alteraCateg(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ALTERAR;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, categoria);
            pst.setInt(2, id);
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, Messager.ALT_CAD);
                conexao.close();
            } else {
                System.out.println("erro");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
    }

}
