/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

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

    
    public Boolean check() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from caixa where date_format(data,'%d/%m/%Y') = ? and status = 1 ";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            rs = pst.executeQuery();
            if (rs.next()) {
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
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
    
    public ResultSet movGeralDeliveryFaixa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select iddelivery as 'Venda delivery',idcaixa as 'Caixa',"
                + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
                + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento',"
                + "data as 'Data'"
                + " from delivery where status = 2 and date_format(data,'%d/%m/%Y')BETWEEN ? and ?";
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
    
    public ResultSet movGeralCaixa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT iduser as 'Caixa',valor_total as 'Valor das vendas',"
                + "valor_recolhido as 'Valor recolhido' "
                + "FROM caixa where date_format(data,'%d/%m/%Y') = ?";
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
    
    public ResultSet movGeralCaixaFaixa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT iduser as 'Caixa',valor_total as 'Valor das vendas',"
                + "valor_recolhido as 'Valor recolhido' ,"
                + "data as 'Data'"
                + "FROM caixa where date_format(data,'%d/%m/%Y')BETWEEN ? and ?";
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
    
    public ResultSet venda() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
                + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
                + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
                + "FROM venda inner join user on user.iduser = venda.iduser "
                + "where date_format(data,'%d/%m/%Y') = ? ";
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
    
    public ResultSet vendaFaixa() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
                + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
                + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
                + "FROM venda inner join user on user.iduser = venda.iduser "
                + "where date_format(data,'%d/%m/%Y') BETWEEN ? and ?";
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
    
    public ResultSet vendaOp(String operador) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
                + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
                + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
                + "FROM venda inner join user on user.iduser = venda.iduser "
                + "where date_format(data,'%d/%m/%Y') = ? and venda.iduser = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            pst.setString(2, operador);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ResultSet vendaFaixaOp(String operador) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
                + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
                + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
                + "FROM venda inner join user on user.iduser = venda.iduser "
                + "where date_format(data,'%d/%m/%Y') BETWEEN ? and ? and venda.iduser = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, data);
            pst.setString(2, datafinal);
            pst.setString(3, operador);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ResultSet log() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select iduser as 'Operador',descricaolog as 'Log', "
                + "datalog as 'Data e hora' "
                + "from logdata where date_format(datalog,'%d/%m/%Y') = ?";
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
