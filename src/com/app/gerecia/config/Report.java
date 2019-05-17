/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rique
 */
public class Report {

    private String data;
    private String datafinal;

    public String getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(String datafinal) {
        this.datafinal = datafinal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ResultSet movgeral() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select idpedido as 'Venda interna',idcaixa as 'Caixa',"
                + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
                + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento'"
                + " from pedido where status = 1 and date_format(data,'%d/%m/%Y') = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ResultSet movGeralFaixa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select idpedido as 'Venda interna',idcaixa as 'Caixa',"
                + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
                + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento',"
                + "data as 'Data'"
                + " from pedido where status = 1 and date_format(data,'%d/%m/%Y')BETWEEN ? and ? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            pst.setString(2, datafinal);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ResultSet movGeralDelivery() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select iddelivery as 'Venda delivery',idcaixa as 'Caixa',"
                + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
                + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento'"
                + " from delivery where status = 2 and date_format(data,'%d/%m/%Y') = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
}
