/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.Manager;
import com.app.gerecia.config.TempFileUser;
import javax.swing.JOptionPane;
import com.app.gerecia.model.Order;

/**
 *
 * @author rique
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        System.out.println(new TempFileUser().tempReadUser());
        String check = new TempFileUser().tempReadUser();
        if(new Manager().checkADMIN(check)==1){
            btnCaixa.setEnabled(true);
            mCadOperador.setEnabled(true);
            mConfig.setEnabled(true);
            mRelatorio.setEnabled(true);
            mCadastro.setEnabled(true);
        }
        if(new Manager().checkADMIN(check)==2){
            btnCaixa.setEnabled(true);
            mRelatorio.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAtendimento = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnRequests = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mConfig = new javax.swing.JMenuItem();
        mCadOperador = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mRelatorio = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        mCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAtendimento.setBackground(new java.awt.Color(204, 204, 204));
        btnAtendimento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAtendimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/menu.png"))); // NOI18N
        btnAtendimento.setText("Atendimento");
        btnAtendimento.setFocusPainted(false);
        btnAtendimento.setRequestFocusEnabled(false);
        btnAtendimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtendimentoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/scooter.png"))); // NOI18N
        jButton1.setText("Delivery");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnCaixa.setBackground(new java.awt.Color(204, 204, 204));
        btnCaixa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/money.png"))); // NOI18N
        btnCaixa.setText("Caixa");
        btnCaixa.setEnabled(false);
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnRequests.setBackground(new java.awt.Color(204, 204, 204));
        btnRequests.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/fast-food (1).png"))); // NOI18N
        btnRequests.setText("Pedidos");
        btnRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestsActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/find.png"))); // NOI18N
        jButton3.setText("Consultar Valor");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setText("SYScon");

        jMenu1.setText("Sistema");

        mConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/gears.png"))); // NOI18N
        mConfig.setText("Arquivo de configuracao");
        mConfig.setEnabled(false);
        mConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfigActionPerformed(evt);
            }
        });
        jMenu1.add(mConfig);

        mCadOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/membership.png"))); // NOI18N
        mCadOperador.setText("Cadastro de operadores");
        mCadOperador.setEnabled(false);
        mCadOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadOperadorActionPerformed(evt);
            }
        });
        jMenu1.add(mCadOperador);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/exit.png"))); // NOI18N
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        mRelatorio.setText("Relatorios");
        mRelatorio.setEnabled(false);

        jMenuItem2.setText("Lista de produtos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mRelatorio.add(jMenuItem2);

        jMenu2.setText("FInanceiro");

        jMenuItem7.setText("Movimeto Geral");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("Venda unitaria");
        jMenu2.add(jMenuItem8);

        mRelatorio.add(jMenu2);

        jMenuItem3.setText("Operadores");
        mRelatorio.add(jMenuItem3);

        jMenuItem4.setText("Comadas pendentes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mRelatorio.add(jMenuItem4);

        jMenuItem6.setText("Log de atividades");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mRelatorio.add(jMenuItem6);

        jMenuItem9.setText("Fechamento de caixa");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mRelatorio.add(jMenuItem9);

        jMenuBar1.add(mRelatorio);

        mCadastro.setText("Cadastro");
        mCadastro.setEnabled(false);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/fast-food.png"))); // NOI18N
        jMenuItem1.setText("Produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mCadastro.add(jMenuItem1);

        jMenuBar1.add(mCadastro);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtendimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)))
                .addGap(8, 8, 8)
                .addComponent(btnAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfigActionPerformed
        // TODO add your handling code here:
        new FileConfig().setVisible(true);
    }//GEN-LAST:event_mConfigActionPerformed

    private void mCadOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadOperadorActionPerformed
        // TODO add your handling code here:
        new CadUser().setVisible(true);
    }//GEN-LAST:event_mCadOperadorActionPerformed

    private void btnAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtendimentoActionPerformed
        new Attendance().setVisible(true);
    }//GEN-LAST:event_btnAtendimentoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CadProduct().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ProductList().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestsActionPerformed
        new Requests().setVisible(true);
    }//GEN-LAST:event_btnRequestsActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       int val = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema ", 
               "ALERTA", JOptionPane.OK_CANCEL_OPTION);
        if (val == 0) {
            this.dispose();
        } 
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new SelectDelivery().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
       new Manager().checkCashier(Integer.parseInt(new TempFileUser().tempReadUser()));
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new GeneralMovement().setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new Log().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        if(new Order().consultaGeral()==false){
            new CloseCashier().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Existem comandas pendentes");
        }  
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new OrderPend().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtendimento;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnRequests;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem mCadOperador;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenuItem mConfig;
    private javax.swing.JMenu mRelatorio;
    // End of variables declaration//GEN-END:variables
}
