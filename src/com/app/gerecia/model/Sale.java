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
public class Sale {
    
    public ResultSet consultaSale(int idpedido){
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = "select idvenda as 'Venda',nome as 'Nome' ,valor_unt as 'Valor Unitario',"
                + "quantidade as 'Quantidade', valor as 'Valor total' from produto inner join venda on "
                + "produto.idproduto = venda.idproduto inner join pedido on "
                + "pedido.idpedido = venda.idpedido where num_comanda = ? and "
                + "pedido.status=0";
        try {
         pst = conexao.prepareStatement(sql);
         pst.setInt(1, idpedido);
         rs  = pst.executeQuery();  
         //jTable2.setModel(DbUtils.resultSetToTableModel(rs));
         //conexao.close();
            return rs;
        } catch (SQLException e) {
            return null;
        }       
    }
    
    public Boolean SaleCancel(int idvenda){
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
}
