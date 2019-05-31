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

/**
 *
 * @author rique
 */
public class Sale {

    private static final String CONSULTA_S = "select idvenda as 'Venda',"
            + "nome as 'Nome' ,valor_unt as 'Valor Unitario',"
            + "quantidade as 'Quantidade', valor as 'Valor total' "
            + "from produto inner join venda on "
            + "produto.idproduto = venda.idproduto inner join pedido on "
            + "pedido.idpedido = venda.idpedido where num_comanda = ? and "
            + "pedido.status=0";
    //****************************************************************************
    private static final String CONSULTA_S_D = "select idvenda as 'Venda',"
            + "nome as 'Nome' ,valor_unt as 'Valor Unitario',"
            + "quantidade as 'Quantidade', valor as 'Valor total' "
            + "from produto inner join venda on "
            + "produto.idproduto = venda.idproduto inner join Delivery on "
            + "delivery.iddelivery = venda.iddelivery where delivery.telefone = ? and "
            + "delivery.status=0";
    //****************************************************************************
    private static final String ZERO_SALE = "update "
            + "pedido set status=-1 where idpedido=?";
    //****************************************************************************
    private static final String ZERO_SALE_DELIVERY = "update "
            + "delivery set status=-1 where iddelivery=?";
    //****************************************************************************
    private static final String UPDATE1_ORDER_PREPARED = "update "
            + "venda set status_preparo=2 where idvenda=?";

    //****************************************************************************
    public ResultSet consultaSale(int idpedido) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = CONSULTA_S;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idpedido);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

    public ResultSet consultaSaleDelivery(int tel) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = CONSULTA_S_D;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, tel);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

    public Boolean SaleCancel(int idvenda) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "delete from venda where idvenda=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idvenda);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public Boolean ZeroSale(Integer numeroComanda) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ZERO_SALE;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numeroComanda);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean ZeroSaleDelivery(String protocolo) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ZERO_SALE_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, protocolo);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean updatePreparo(Integer venda) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = UPDATE1_ORDER_PREPARED;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, venda);
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
}
