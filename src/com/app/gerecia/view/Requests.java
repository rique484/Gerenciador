/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.ConfigDB;
import com.app.gerecia.config.Messager;
import com.app.gerecia.config.Print;
import com.app.gerecia.model.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rique
 */
public final class Requests extends javax.swing.JFrame {

    private static final String LIST_DELIVERY = "select venda.idvenda as 'Venda',delivery.iddelivery as 'Protocolo',"
            + "nome as 'Nome' ,quantidade as 'Quantidade' from produto "
            + "inner join venda on produto.idproduto = venda.idproduto "
            + "inner join delivery on delivery.iddelivery = venda.iddelivery "
            + "where status_preparo = 1 and delivery.status = 1";
    private static final String LIST_INTERNAL = "select venda.idvenda as 'Venda', num_comanda as 'Comanda',nome as 'Nome' ,"
            + "quantidade as 'Quantidade' from produto inner join venda on "
            + "produto.idproduto = venda.idproduto inner join pedido on "
            + "pedido.idpedido = venda.idpedido where status_preparo = 1";
    private Thread th;
    private Integer i;

    public Requests() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        listDelivery();
        listInternal();
        autoReload().start();
    }

    public Thread autoReload() {
        th = new Thread(t1);
        return th;
    }

    private final Runnable t1 = new Runnable() {
        @Override
        public void run() {
            try {
                for (i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    System.out.println(i);
                    if (i == 9) {
                        listDelivery();
                        listInternal();
                        i = 0;
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    };

    public void listInternal() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = LIST_INTERNAL;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            tblRes.setModel(DbUtils.resultSetToTableModel(rs));
            conexao.close();
        } catch (SQLException e) {

        }
    }

    public void listDelivery() {
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        conexao = new ConfigDB().conector();
        String sql = LIST_DELIVERY;
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            tblDelivery.setModel(DbUtils.resultSetToTableModel(rs));
            conexao.close();
        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnReload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        btnReload.setBackground(new java.awt.Color(255, 255, 255));
        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/iconfinder_agt_reload_18517 (1).png"))); // NOI18N
        btnReload.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnReload.setFocusPainted(false);
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedidos Internos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SYScon");

        tblRes.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        tblRes.setForeground(new java.awt.Color(51, 51, 51));
        tblRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblRes.setDragEnabled(true);
        tblRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRes);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pedidos Delivery");

        tblDelivery.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        tblDelivery.setForeground(new java.awt.Color(51, 51, 51));
        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDelivery.setDragEnabled(true);
        tblDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeliveryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDelivery);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReload, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReload, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        listDelivery();
        listInternal();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void tblResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResMouseClicked
        int setar = tblRes.getSelectedRow();
        th.interrupt();
        int val = JOptionPane.showConfirmDialog(null, Messager.PREPARED,
                "ALERTA", JOptionPane.OK_CANCEL_OPTION);
        if (val == 0) {
            new Sale().updatePreparo(Integer.parseInt(tblRes.getModel().getValueAt(setar, 0).toString()));
            listInternal();
        }
        i = 0;
        autoReload().start();
    }//GEN-LAST:event_tblResMouseClicked

    private void tblDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeliveryMouseClicked
        int setar = tblDelivery.getSelectedRow();
        th.interrupt();
        int val = JOptionPane.showConfirmDialog(null, Messager.PREPARED,
                "ALERTA", JOptionPane.OK_CANCEL_OPTION);
        if (val == 0) {
            new Print().printRequest(Integer.parseInt(tblDelivery.getModel().getValueAt(setar, 1).toString()),
                    Integer.parseInt(tblDelivery.getModel().getValueAt(setar, 0).toString()));
            new Sale().updatePreparo(Integer.parseInt(tblDelivery.getModel().getValueAt(setar, 0).toString()));
            listDelivery();
        }
        i = 0;
        autoReload().start();
    }//GEN-LAST:event_tblDeliveryMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        i = 0;
        th.interrupt();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDelivery;
    private javax.swing.JTable tblRes;
    // End of variables declaration//GEN-END:variables
}
