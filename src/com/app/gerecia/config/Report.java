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
    private static final String CHECK = "select * from caixa where "
            + "date_format(data,'%d/%m/%Y') = ? and status = 1 ";
    //****************************************************************************
    private static final String MOVGERAL = "select idpedido as 'Venda interna',idcaixa as 'Caixa',"
            + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
            + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento'"
            + " from pedido where status = 1 and date_format(data,'%d/%m/%Y') = ?";
    //****************************************************************************
    private static final String MOVGERALFAIXA = "select idpedido as 'Venda interna',idcaixa as 'Caixa',"
            + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
            + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento',"
            + "data as 'Data'"
            + " from pedido where status = 1 and date_format(data,'%d/%m/%Y')BETWEEN ? and ? ";
    //****************************************************************************
    private static final String MOVGERALD = "select iddelivery as 'Venda delivery',idcaixa as 'Caixa',"
            + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
            + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento'"
            + " from delivery where status = 2 and date_format(data,'%d/%m/%Y') = ?";
    //****************************************************************************
    private static final String MOVGERALDF = "select iddelivery as 'Venda delivery',idcaixa as 'Caixa',"
            + " valor_total as 'Valor', case modo_pagt WHEN '1' THEN 'DINHEIRO'"
            + " WHEN '2' THEN 'DEBITO' WHEN '3' THEN 'CREDITO' end as 'Modo de pagamento',"
            + "data as 'Data'"
            + " from delivery where status = 2 and date_format(data,'%d/%m/%Y')BETWEEN ? and ?";
    //****************************************************************************
    private static final String MOVGERALCAIXA = "SELECT iduser as 'Caixa',valor_total as 'Valor das vendas',"
            + "valor_recolhido as 'Valor recolhido' "
            + "FROM caixa where date_format(data,'%d/%m/%Y') = ?";
    //****************************************************************************
    private static final String MOVGERALCAIXAF = "SELECT iduser as 'Caixa',valor_total as 'Valor das vendas',"
            + "valor_recolhido as 'Valor recolhido' ,"
            + "data as 'Data'"
            + "FROM caixa where date_format(data,'%d/%m/%Y')BETWEEN ? and ?";
    //****************************************************************************
    private static final String VENDA = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
            + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
            + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
            + "FROM venda inner join user on user.iduser = venda.iduser "
            + "where date_format(data,'%d/%m/%Y') = ? ";
    //****************************************************************************
    private static final String VENDAFAIXA = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
            + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
            + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
            + "FROM venda inner join user on user.iduser = venda.iduser "
            + "where date_format(data,'%d/%m/%Y') BETWEEN ? and ?";
    //****************************************************************************
    private static final String VENDAOP = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
            + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
            + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
            + "FROM venda inner join user on user.iduser = venda.iduser "
            + "where date_format(data,'%d/%m/%Y') = ? and venda.iduser = ?";
    //****************************************************************************
    private static final String VENDAOPF = "SELECT idvenda as 'Venda',venda.iduser as 'Operador',"
            + "valor as 'Valor da venda',  (valor*(comiss/100))as 'Comissao',"
            + " valor-(valor*(comiss/100)) as 'Valor pos-comissao'"
            + "FROM venda inner join user on user.iduser = venda.iduser "
            + "where date_format(data,'%d/%m/%Y') BETWEEN ? and ? and venda.iduser = ?";
    //****************************************************************************
    private static final String LOG = "select iduser as 'Operador',descricaolog as 'Log', "
            + "datalog as 'Data e hora' "
            + "from logdata where date_format(datalog,'%d/%m/%Y') = ?";
    //****************************************************************************
    private String data;
    private String datafinal;
    //****************************************************************************
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
        String sql = CHECK;
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
        String sql = MOVGERAL;
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
        String sql = MOVGERALFAIXA;
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
        String sql = MOVGERALD;
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
        String sql = MOVGERALDF;
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
        String sql = MOVGERALCAIXA;
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
        String sql = MOVGERALCAIXAF;
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
        String sql = VENDA;
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
        String sql = VENDAFAIXA;
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
        String sql = VENDAOP;
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
        String sql = VENDAOPF;
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
        String sql = LOG;
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
