/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.Report;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rique
 */
public class ReportComiss extends javax.swing.JFrame {

    /**
     * Creates new form ReportComiss
     */
    public ReportComiss() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        chkDiario = new javax.swing.JRadioButton();
        chkPeriodo = new javax.swing.JRadioButton();
        txtdata = new javax.swing.JFormattedTextField();
        txtDataf = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbValorV = new javax.swing.JLabel();
        lbValorC = new javax.swing.JLabel();
        lbValorF = new javax.swing.JLabel();
        chkOp = new javax.swing.JCheckBox();
        txtOperador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Relatório de venda");

        buttonGroup1.add(chkDiario);
        chkDiario.setText("Diário");
        chkDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDiarioActionPerformed(evt);
            }
        });

        buttonGroup1.add(chkPeriodo);
        chkPeriodo.setText("Período");
        chkPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkPeriodoActionPerformed(evt);
            }
        });

        try {
            txtdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdata.setEnabled(false);

        try {
            txtDataf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataf.setEnabled(false);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVenda);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Valor total da venda");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Valor total da comissão");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Valor total da venda apos comissão");

        chkOp.setText("Por operador");
        chkOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOpActionPerformed(evt);
            }
        });

        txtOperador.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(lbValorF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(86, 86, 86)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbValorV, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbValorC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(chkDiario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chkPeriodo)
                            .addGap(10, 10, 10)
                            .addComponent(chkOp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtOperador))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDataf, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkDiario)
                    .addComponent(chkPeriodo)
                    .addComponent(chkOp)
                    .addComponent(txtOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbValorV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValorC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbValorF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDiarioActionPerformed
        if (chkDiario.isSelected()) {
            txtdata.setEnabled(true);
            txtDataf.setEnabled(false);
        }
    }//GEN-LAST:event_chkDiarioActionPerformed

    private void chkPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPeriodoActionPerformed
        if (chkPeriodo.isSelected()) {
            txtdata.setEnabled(true);
            txtDataf.setEnabled(true);
        }
    }//GEN-LAST:event_chkPeriodoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double count = 0;
        Report r = new Report();
        if (chkDiario.isSelected()) {
            r.setData(txtdata.getText());
            if (chkOp.isSelected()) {
                tblVenda.setModel(DbUtils.resultSetToTableModel(r.vendaOp(txtOperador.getText())));
            } else {
                tblVenda.setModel(DbUtils.resultSetToTableModel(r.venda()));
            }
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 2).toString());
            }
            lbValorV.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 3).toString());
            }
            lbValorC.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 4).toString());
            }
            lbValorF.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;
 

        } else {
            r.setData(txtdata.getText());
            r.setDatafinal(txtDataf.getText());
            if (chkOp.isSelected()) {
                tblVenda.setModel(DbUtils.resultSetToTableModel(r.vendaFaixaOp(txtOperador.getText())));
            } else {
                tblVenda.setModel(DbUtils.resultSetToTableModel(r.vendaFaixa()));
            }
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 2).toString());
            }
            lbValorV.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 3).toString());
            }
            lbValorC.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;
            for (int i = 0; i <= tblVenda.getRowCount() - 1; i++) {
                count += Double.parseDouble(tblVenda.getValueAt(i, 4).toString());
            }
            lbValorF.setText(String.format("R$ %2.5s", String.valueOf(count)));
            count = 0;


        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOpActionPerformed
        if (chkOp.isSelected()) {
            txtOperador.setEnabled(true);
        } else {
            txtOperador.setEnabled(false);
        }
    }//GEN-LAST:event_chkOpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton chkDiario;
    private javax.swing.JCheckBox chkOp;
    private javax.swing.JRadioButton chkPeriodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbValorC;
    private javax.swing.JLabel lbValorF;
    private javax.swing.JLabel lbValorV;
    private javax.swing.JTable tblVenda;
    private javax.swing.JFormattedTextField txtDataf;
    private javax.swing.JTextField txtOperador;
    private javax.swing.JFormattedTextField txtdata;
    // End of variables declaration//GEN-END:variables
}
