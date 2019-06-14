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
public class MailConfig {

    private static final String CADASTRO = "insert into "
            + "mail(email,pass,name,smtp,port,status) values(?,?,?,?,?,?)";
    private static final String ALTERAR = "update mail set email=?, pass=?, name=?,"
            + " smtp=?, port=?, status=? where idmail=1";

    private String smtp, port, from, pass, name;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSmtp() {
        return smtp;
    }

    public void setSmtp(String smtp) {
        this.smtp = smtp;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean loadMail() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from mail";
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                setStatus(rs.getInt(7));
                setFrom(rs.getString(2));
                setPass(rs.getString(3));
                setName(rs.getString(4));
                setSmtp(rs.getString(5));
                setPort(rs.getString(6));
                conexao.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public Boolean cadMailConfig() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = CADASTRO;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, from);
            pst.setString(2, pass);
            pst.setString(3, name);
            pst.setString(4, smtp);
            pst.setString(5, port);
            pst.setInt(6, status);
            int add = pst.executeUpdate();
            if (add > 0) {
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            String err = e.toString();
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public Boolean altMailConfig() {
        Connection conexao = null;
        PreparedStatement pst = null;
        String sql = ALTERAR;
        try {
            conexao = new ConfigDB().conector();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, from);
            pst.setString(2, pass);
            pst.setString(3, name);
            pst.setString(4, smtp);
            pst.setString(5, port);
            pst.setInt(6, status);
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

