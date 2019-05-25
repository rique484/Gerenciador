/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import com.app.gerecia.view.Delivery;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author rique
 */
public class Print {

    public void printProtocol(Integer protocolo) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("delivery.iddelivery", protocolo);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/Protocol.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printRequest(Integer protocolo, Integer venda) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("delivery.iddelivery", protocolo);
        filtro.put("venda.idvenda", venda);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/item.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printTeste(String data) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("data", data);
        filtro.put("SUBREPORT_DIR","rel/");
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/reportMovP.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printGeralP(String data, String dataf) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("data", data);
        filtro.put("dataf", dataf);
        filtro.put("SUBREPORT_DIR","rel/");
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/reportMovF.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printListProduct() {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/listproduct.jasper", null, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void toExcel(JTable table) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter("ext_excel/Relatorio"+
                    Date.valueOf(LocalDate.now())+".xls");
            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }
            excel.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }
            excel.close();
            JOptionPane.showMessageDialog(null, Messager.MSG_SUSS);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printVenda(String data) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("data", data);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/reportMovF.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void printVendaFaixa(String data, String dataf) {
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("data", data);
        filtro.put("dataf", dataf);
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport("rel/reportMovF.jasper", filtro, conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
