/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import com.app.gerecia.view.Delivery;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rique
 */
public class Print {
    public void printProtocol(Integer protocolo){
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("delivery.iddelivery", protocolo);
        try {
           JasperPrint jasperPrint = JasperFillManager.fillReport("Protocol.jasper",filtro,conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void printRequest(Integer protocolo,Integer venda){
        Connection conexao = null;
        conexao = new ConfigDB().conector();
        HashMap filtro = new HashMap();
        filtro.put("delivery.iddelivery", protocolo);
        filtro.put("venda.idvenda", venda);
        try {
           JasperPrint jasperPrint = JasperFillManager.fillReport("item.jasper",filtro,conexao);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
