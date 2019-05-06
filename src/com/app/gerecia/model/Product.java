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
public class Product {
    private Integer id;
    private String nome;
    private Double valor;
    private String codBar;
    private Integer status;
    private Integer preparo;
    
    
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

    public Integer getPreparo() {
        return preparo;
    }

    public void setPreparo(Integer preparo) {
        this.preparo = preparo;
    }
    
    public Boolean search() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from produto where idproduto=?";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                setNome(rs.getString(2));
                setValor(rs.getDouble(3));
                setCodBar(rs.getString(4));
                setStatus(rs.getInt(5));
                setPreparo(rs.getInt(6));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, Messager.ITEM_NOT);
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public Boolean cadastroProduto(){
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "insert into produto(nome,valor_unt,cod_bar,status,preparo)"
                + " values(?,?,?,?,?)";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setDouble(2, valor);
            pst.setString(3, codBar);
            pst.setInt(4, status);
            pst.setInt(5, preparo);
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
            String err = e.toString();
            if (err.contains("Duplicate")) {
                JOptionPane.showMessageDialog(null, "Nome do produto ja cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, e);
            }
            return false;
        }
    }
    
    public Boolean alterar() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = "update produto set nome=?, valor_unt=?, cod_bar=?, "
                + "status=?,preparo=? where idproduto=?";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setDouble(2, valor);
            pst.setString(3, codBar);
            pst.setInt(4, status);
            pst.setInt(5, preparo);
            pst.setInt(6, id);
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, Messager.ALT_CAD);
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
    
    public ResultSet advancedSearch(String busca){
                Connection conexao = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                String sql = "select idproduto as 'ID',nome as 'Nome', "
                        + "valor_unt as 'Valor' from produto where"
                        + " idproduto like ? and status = 0 or "
                        + "cod_bar = ? and status = 0";   
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
