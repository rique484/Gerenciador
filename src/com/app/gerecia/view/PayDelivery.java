/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.TempFileUser;
import com.app.gerecia.model.Order;
import com.app.gerecia.model.Sale;
import java.awt.event.KeyEvent;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rique
 */
public class PayDelivery extends javax.swing.JFrame {

    private Double valor;
    private Integer comanda;
    private Cashier caixa;

    /**
     * Creates new form PayDelivery
     */
    public PayDelivery(Cashier caixa) {
        initComponents();
        this.caixa = caixa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtProtocolo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnDinhero = new javax.swing.JButton();
        btnDebito = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Baixa de delivery");

        txtProtocolo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProtocoloKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Protocolo");

        btnDinhero.setBackground(new java.awt.Color(204, 204, 204));
        btnDinhero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDinhero.setText("Dinheiro");
        btnDinhero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinheroActionPerformed(evt);
            }
        });

        btnDebito.setBackground(new java.awt.Color(204, 204, 204));
        btnDebito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDebito.setText("Débito");
        btnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebitoActionPerformed(evt);
            }
        });

        btnCredito.setBackground(new java.awt.Color(204, 204, 204));
        btnCredito.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCredito.setText("Crédito");
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblItens);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Valor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDinhero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProtocolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDinhero)
                    .addComponent(btnDebito)
                    .addComponent(btnCredito))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProtocoloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProtocoloKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtProtocolo.getText().equals("")) {
                comanda = Integer.parseInt(txtProtocolo.getText());
                Order o = new Order();
                tblItens.setModel(DbUtils.resultSetToTableModel(o.consultaPayDelivery(comanda)));
                double count = 0;
                for (int i = 0; i <= tblItens.getRowCount() - 1; i++) {
                    count += Double.parseDouble(tblItens.getValueAt(i, 4).toString());
                }
                lbValorTotal.setText(String.format("%2.5s", String.valueOf(count)));
                txtProtocolo.setEditable(false);
                valor = Double.parseDouble(lbValorTotal.getText());

            }
        }
    }//GEN-LAST:event_txtProtocoloKeyPressed

    private void btnDinheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinheroActionPerformed
        TempFileUser t = new TempFileUser();
        Integer operador = Integer.parseInt(t.tempReadUser());
        Order o = new Order();
        o.orderDeliveryClose(valor, 1, operador, comanda);
        caixa.dispose(); 
        dispose();
        new Cashier().setVisible(true);
    }//GEN-LAST:event_btnDinheroActionPerformed

    private void btnDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebitoActionPerformed
        TempFileUser t = new TempFileUser();
        Integer operador = Integer.parseInt(t.tempReadUser());
        Order o = new Order();
        o.orderDeliveryClose(valor, 2, operador, comanda);
        caixa.dispose(); 
        dispose();
        new Cashier().setVisible(true);
    }//GEN-LAST:event_btnDebitoActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        TempFileUser t = new TempFileUser();
        Integer operador = Integer.parseInt(t.tempReadUser());
        Order o = new Order();
        o.orderDeliveryClose(valor, 3, operador, comanda);
        caixa.dispose(); 
        dispose();
        new Cashier().setVisible(true);
    }//GEN-LAST:event_btnCreditoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnDebito;
    private javax.swing.JButton btnDinhero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtProtocolo;
    // End of variables declaration//GEN-END:variables
}
