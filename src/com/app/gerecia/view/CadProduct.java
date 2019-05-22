/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.Manager;
import com.app.gerecia.config.Messager;
import com.app.gerecia.config.TempFileUser;
import com.app.gerecia.model.Product;
import javax.swing.JOptionPane;

/**
 *
 * @author rique
 */
public class CadProduct extends javax.swing.JFrame {

    private Integer operador = Integer.parseInt(new TempFileUser().tempReadUser());
    
    public CadProduct() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        chkInativo = new javax.swing.JCheckBox();
        rtDisplay = new javax.swing.JRadioButton();
        rtPrateleira = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodBar = new javax.swing.JTextField();
        chkPreparo = new javax.swing.JCheckBox();
        txtIdBusca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnListProd = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produtos");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "Cadastrar Produto"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome");

        chkInativo.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        chkInativo.setText("Inativo");

        rtDisplay.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        rtDisplay.setSelected(true);
        rtDisplay.setText("Display");
        rtDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtDisplayActionPerformed(evt);
            }
        });

        rtPrateleira.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        rtPrateleira.setText("Pratileira");
        rtPrateleira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtPrateleiraActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Valor");

        txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0,00"))));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Codigo de barra");

        txtCodBar.setEnabled(false);

        chkPreparo.setText("Feito na Hora?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkInativo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodBar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rtDisplay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rtPrateleira)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkPreparo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rtDisplay)
                    .addComponent(rtPrateleira)
                    .addComponent(chkPreparo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID");

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/iconfinder_search-70px_510861.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnListProd.setBackground(new java.awt.Color(204, 204, 204));
        btnListProd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnListProd.setText("Produtos cadastrados");
        btnListProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListProdActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(204, 204, 204));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setBackground(new java.awt.Color(204, 204, 204));
        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(btnListProd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdBusca)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnListProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnAlterar)
                    .addComponent(btnCancelar))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Product p = new Product();
        p.setId(Integer.parseInt(txtIdBusca.getText()));
        p.setNome(txtNome.getText());
        p.setValor(Double.parseDouble(txtValor.getText()));
        p.setCodBar(txtCodBar.getText());
        if(chkInativo.isSelected()){p.setStatus(1);}else{p.setStatus(0);}
        if(chkPreparo.isSelected()){p.setPreparo(1);} else {p.setPreparo(0);}
        if(p.alterar().equals(true)){
            dispose();
            new Manager().logData(operador, "Produto alterado "+ p.getNome());
            new CadProduct().setVisible(true);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNome.getText() == null || txtNome.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, Messager.NAME_REQUIRED);
        } else {
            if (txtValor.getText() == null || txtValor.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, Messager.VALUE_REQUIRED);
            } else {
                Product p = new Product();
                p.setNome(txtNome.getText());
                p.setValor(Double.parseDouble(txtValor.getText()));
                p.setCodBar(txtCodBar.getText());
                if (chkInativo.isSelected()) {
                    p.setStatus(1);
                } else {
                    p.setStatus(0);
                }
                if(chkPreparo.isSelected()){
                    p.setPreparo(1);
                } else {
                    p.setPreparo(0);
                }
                if (p.cadastroProduto() == true) {
                    new Manager().logData(operador, "Cadastro de Produto "+ p.getNome());
                    dispose();
                    new CadProduct().setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void rtDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtDisplayActionPerformed
        if (rtDisplay.isSelected()) {
            rtPrateleira.setSelected(false);
            txtCodBar.setEnabled(false);
            txtCodBar.setText("");
        }
    }//GEN-LAST:event_rtDisplayActionPerformed

    private void rtPrateleiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtPrateleiraActionPerformed
        if (rtPrateleira.isSelected()) {
            rtDisplay.setSelected(false);
            txtCodBar.setEnabled(true);
        }
    }//GEN-LAST:event_rtPrateleiraActionPerformed

    private void btnListProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListProdActionPerformed
        new ProductList().setVisible(true);
    }//GEN-LAST:event_btnListProdActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Product p = new Product();
        p.setId(Integer.parseInt(txtIdBusca.getText()));
        if(p.search().equals(true)){
            btnCancelar.setEnabled(true);
            txtIdBusca.setEnabled(false);
            btnBuscar.setEnabled(false);
            btnCadastrar.setEnabled(false);
            btnAlterar.setEnabled(true);
            txtNome.setText(p.getNome());
            txtValor.setText(p.getValor().toString());
            if(p.getStatus()==1){chkInativo.setSelected(true);}
            if(p.getPreparo()==1){chkPreparo.setSelected(true);}
            if(p.getCodBar().isEmpty()){  
                rtDisplay.setSelected(true);
                rtPrateleira.setSelected(false);
            }else{   
                txtCodBar.setEnabled(true);
                rtPrateleira.setSelected(true);
                rtDisplay.setSelected(false);
                txtCodBar.setText(p.getCodBar());
            }   
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListProd;
    private javax.swing.JCheckBox chkInativo;
    private javax.swing.JCheckBox chkPreparo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rtDisplay;
    private javax.swing.JRadioButton rtPrateleira;
    private javax.swing.JTextField txtCodBar;
    private javax.swing.JTextField txtIdBusca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
