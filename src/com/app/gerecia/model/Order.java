/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.model;

import com.app.gerecia.config.ConfigDB;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author rique
 */
public class Order {

    private static final String SELECT_ORDER_ALL = "select idpedido as 'Venda',"
            + "num_comanda as 'Comanda' from pedido where status=0";
    //****************************************************************************
    private static final String SELECT_ORDER = "select * from pedido where "
            + "num_comanda=? AND status=0 ";
    //****************************************************************************
    private static final String SELECT_ORDER_DELIVERY = "select * from delivery where "
            + "telefone=? AND status=0 ";
    //****************************************************************************
    private static final String INSERT_ORDER = "insert into venda(valor,quanti"
            + "dade,idproduto,idpedido,iduser,status_preparo,data,comiss) "
            + "values(?,?,?,?,?,?,?,?)";
    //****************************************************************************
    private static final String INSERT_ORDER_DELIVERY = "insert into venda(valor,quanti"
            + "dade,idproduto,iduser,status_preparo,data,iddelivery) "
            + "values(?,?,?,?,?,?,?)";
    //****************************************************************************
    private static final String CREATE_ORDER = "insert into pedido(num_comanda,"
            + "status,data) values(?,0,?)";
    //****************************************************************************
    private static final String CREATE_ORDER_DELIVERY = "insert into delivery(telefone,"
            + "status,data) values(?,0,?)";
    //****************************************************************************
    private static final String CREATE_PAY_DELIVERY = "insert into pagtdelivery"
            + "(iddelivery,cartaodb,cartaocd,dinheiro,troco_valor) values(?,?,?,?,?)";
    //****************************************************************************
    private static final String CREATE_DESC_DELIVERY = "insert into obsdelivery"
            + "(obs,iddelivery) values(?,?)";
    //****************************************************************************
    private static final String UPDATE1_ORDER_DELIVERY = "update delivery set "
            + "status=1 where iddelivery=?";
    //****************************************************************************
    private static final String SELECT_ORDER_DELIVERY_PAY = "select idvenda as 'Venda',"
            + "nome as 'Nome' ,valor_unt as 'Valor Unitario',"
            + "quantidade as 'Quantidade', valor as 'Valor total' from produto "
            + "inner join venda on produto.idproduto = venda.idproduto inner join Delivery on "
            + "delivery.iddelivery = venda.iddelivery where delivery.iddelivery = ? and "
            + "delivery.status=1";
    //****************************************************************************
    private static final String DELIVERY_SEARCH = "select iddelivery as 'Protocolo',"
            + "delivery.telefone as 'Contato',"
            + "datahora as 'Data e Hora',nome as 'Cliente',cep as 'CEP' "
            + "from delivery inner join clientes on delivery.telefone = clientes.telefone "
            + "where delivery.status = 1";
    //****************************************************************************
    private static final String ORDER_CLOSER = "update pedido set valor_total=?, "
            + "status=1, modo_pagt=?, idcaixa=? where num_comanda=? and status=0";
    //****************************************************************************
    private static final String ORDER_CLOSER_D = "update delivery "
            + "set valor_total=?, status=2, modo_pagt=?, "
            + "idcaixa=? where iddelivery=? and status=1";
    //****************************************************************************
    private Integer numero_comanda;
    private Integer numero_contato;
    private Double valor_total;
    private Integer status;
    private Integer id;
    private Integer status_preparo;
    private Date data;

    public Integer getNumero_comanda() {
        return numero_comanda;
    }

    public void setNumero_comanda(Integer numero_comanda) {
        this.numero_comanda = numero_comanda;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus_preparo() {
        return status_preparo;
    }

    public void setStatus_preparo(Integer status_preparo) {
        this.status_preparo = status_preparo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getNumero_contato() {
        return numero_contato;
    }

    public void setNumero_contato(Integer numero_contato) {
        this.numero_contato = numero_contato;
    }

    public Boolean consulta() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = SELECT_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_comanda);
            rs = pst.executeQuery();
            if (rs.next()) {
                setId(rs.getInt(1));
                setNumero_comanda(rs.getInt(2));
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

    public Boolean consultaGeral() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = SELECT_ORDER_ALL;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
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

    public Boolean consultaDelivery() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = SELECT_ORDER_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_contato);
            rs = pst.executeQuery();
            if (rs.next()) {
                setId(rs.getInt(1));
                setNumero_contato(rs.getInt(2));
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

    public Boolean orderInsert(Double valor, Integer quantidade, Integer idproduto,
            Integer idpedido, Integer iduser, Integer status_preparo, Integer comiss) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = INSERT_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, quantidade);
            pst.setInt(3, idproduto);
            pst.setInt(4, idpedido);
            pst.setInt(5, iduser);
            pst.setInt(6, status_preparo);
            pst.setDate(7, data);
            pst.setInt(8, comiss);
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

    public Boolean orderInsertDelivery(Double valor, Integer quantidade, Integer idproduto,
            Integer iduser, Integer status_preparo, Integer iddelivery) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = INSERT_ORDER_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setInt(2, quantidade);
            pst.setInt(3, idproduto);
            pst.setInt(4, iduser);
            pst.setInt(5, status_preparo);
            pst.setDate(6, data);
            pst.setInt(7, iddelivery);
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

    public Boolean DeliveryPay(Integer id, Integer debt, Integer crt,
            Integer dinheiro, Double troco) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CREATE_PAY_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, debt);
            pst.setInt(3, crt);
            pst.setInt(4, dinheiro);
            pst.setDouble(5, troco);
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

    public Boolean DeliveryObs(String obs, Integer id) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CREATE_DESC_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, obs);
            pst.setInt(2, id);

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

    public Boolean orderCreate() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CREATE_ORDER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_comanda);
            pst.setDate(2, Date.valueOf(LocalDate.now()));
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

    public Boolean orderCreateDelivery() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CREATE_ORDER_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, numero_contato);
            pst.setDate(2, Date.valueOf(LocalDate.now()));
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

    public Boolean orderUpdate1(Integer protocolo) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = UPDATE1_ORDER_DELIVERY;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, protocolo);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                System.out.println("erro");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public ResultSet deliverySearch() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = DELIVERY_SEARCH;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public Boolean orderClose(Double valor, Integer modopagt, Integer operador, Integer comanda) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ORDER_CLOSER;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setDouble(2, modopagt);
            pst.setInt(3, operador);
            pst.setInt(4, comanda);
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

    public Boolean orderDeliveryClose(Double valor, Integer modopagt, Integer operador, Integer comanda) {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ORDER_CLOSER_D;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setDouble(1, valor);
            pst.setDouble(2, modopagt);
            pst.setInt(3, operador);
            pst.setInt(4, comanda);
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

    public ResultSet consultaPayDelivery(Integer protocolo) {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = SELECT_ORDER_DELIVERY_PAY;
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, protocolo);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

}
