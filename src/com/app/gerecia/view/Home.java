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

    public Home() {
        initComponents();
        System.out.println(new TempFileUser().tempReadUser());
        String check = new TempFileUser().tempReadUser();
        if (new Manager().checkADMIN(check) == 1) {
            btnCaixa.setEnabled(true);
            mCadOperador.setEnabled(true);
            mConfig.setEnabled(true);
            mRelatorio.setEnabled(true);
            mCadastro.setEnabled(true);
            mClose.setEnabled(true);
            mComan.setEnabled(true);
            mFinanc.setEnabled(true);
            mProdList.setEnabled(true);
            mUser.setEnabled(true);
            mLog.setEnabled(true);
        }
        if (new Manager().checkADMIN(check) == 2) {
            btnCaixa.setEnabled(true);
            mRelatorio.setEnabled(true);
            mClose.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAtendimento = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnRequests = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mConfig = new javax.swing.JMenuItem();
        mCadOperador = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mRelatorio = new javax.swing.JMenu();
        mProdList = new javax.swing.JMenuItem();
        mFinanc = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        mUser = new javax.swing.JMenuItem();
        mComan = new javax.swing.JMenuItem();
        mLog = new javax.swing.JMenuItem();
        mClose = new javax.swing.JMenuItem();
        mCadastro = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("SYScon");

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
        jButton1.setFocusPainted(false);
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
        btnCaixa.setFocusPainted(false);
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnRequests.setBackground(new java.awt.Color(204, 204, 204));
        btnRequests.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRequests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/fast-food (1).png"))); // NOI18N
        btnRequests.setText("Pedidos");
        btnRequests.setFocusPainted(false);
        btnRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestsActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRequests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(210, 210, 210)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtendimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(158, 158, 158)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setForeground(new java.awt.Color(102, 102, 102));
        jMenu1.setText("Sistema");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        mConfig.setBackground(new java.awt.Color(255, 255, 255));
        mConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/gears.png"))); // NOI18N
        mConfig.setText("Arquivo de configuração");
        mConfig.setEnabled(false);
        mConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mConfigActionPerformed(evt);
            }
        });
        jMenu1.add(mConfig);

        mCadOperador.setBackground(new java.awt.Color(255, 255, 255));
        mCadOperador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/membership.png"))); // NOI18N
        mCadOperador.setText("Cadastro de operadores");
        mCadOperador.setEnabled(false);
        mCadOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadOperadorActionPerformed(evt);
            }
        });
        jMenu1.add(mCadOperador);

        jMenuItem5.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/exit.png"))); // NOI18N
        jMenuItem5.setText("Sair");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        mRelatorio.setForeground(new java.awt.Color(102, 102, 102));
        mRelatorio.setText("Relatorios");
        mRelatorio.setEnabled(false);
        mRelatorio.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        mProdList.setBackground(new java.awt.Color(255, 255, 255));
        mProdList.setText("Lista de produtos");
        mProdList.setEnabled(false);
        mProdList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mProdListActionPerformed(evt);
            }
        });
        mRelatorio.add(mProdList);

        mFinanc.setBackground(new java.awt.Color(255, 255, 255));
        mFinanc.setText("Financeiro");
        mFinanc.setBorderPainted(true);
        mFinanc.setEnabled(false);

        jMenuItem7.setBackground(new java.awt.Color(204, 204, 204));
        jMenuItem7.setText("Movimeto Geral");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mFinanc.add(jMenuItem7);

        jMenuItem8.setBackground(new java.awt.Color(204, 204, 204));
        jMenuItem8.setText("Venda unitaria");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        mFinanc.add(jMenuItem8);

        mRelatorio.add(mFinanc);

        mUser.setBackground(new java.awt.Color(255, 255, 255));
        mUser.setText("Operadores");
        mUser.setEnabled(false);
        mUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUserActionPerformed(evt);
            }
        });
        mRelatorio.add(mUser);

        mComan.setBackground(new java.awt.Color(255, 255, 255));
        mComan.setText("Comadas pendentes");
        mComan.setEnabled(false);
        mComan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mComanActionPerformed(evt);
            }
        });
        mRelatorio.add(mComan);

        mLog.setBackground(new java.awt.Color(255, 255, 255));
        mLog.setText("Log de atividades");
        mLog.setEnabled(false);
        mLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLogActionPerformed(evt);
            }
        });
        mRelatorio.add(mLog);

        mClose.setBackground(new java.awt.Color(255, 255, 255));
        mClose.setText("Fechamento de caixa");
        mClose.setEnabled(false);
        mClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCloseActionPerformed(evt);
            }
        });
        mRelatorio.add(mClose);

        jMenuBar1.add(mRelatorio);

        mCadastro.setForeground(new java.awt.Color(102, 102, 102));
        mCadastro.setText("Cadastro");
        mCadastro.setEnabled(false);
        mCadastro.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/gerecia/img/fast-food.png"))); // NOI18N
        jMenuItem1.setText("Produtos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mCadastro.add(jMenuItem1);

        jMenuBar1.add(mCadastro);

        jMenu3.setForeground(new java.awt.Color(102, 102, 102));
        jMenu3.setText("Sobre");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jMenuItem10.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setText("Versão");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mConfigActionPerformed
        new FileConfig().setVisible(true);
    }//GEN-LAST:event_mConfigActionPerformed

    private void mCadOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadOperadorActionPerformed
        new CadUser().setVisible(true);
    }//GEN-LAST:event_mCadOperadorActionPerformed

    private void btnAtendimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtendimentoActionPerformed
        new Attendance().setVisible(true);
    }//GEN-LAST:event_btnAtendimentoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new CadProduct().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mProdListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mProdListActionPerformed
        new ProductList().setVisible(true);
    }//GEN-LAST:event_mProdListActionPerformed

    private void btnRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestsActionPerformed
        new Requests().setVisible(true);
    }//GEN-LAST:event_btnRequestsActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        int val = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema ?",
                "Aviso", JOptionPane.OK_CANCEL_OPTION);
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

    private void mLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLogActionPerformed
        new Log().setVisible(true);
    }//GEN-LAST:event_mLogActionPerformed

    private void mCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCloseActionPerformed
        if (new Order().consultaGeral() == false) {
            new CloseCashier().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Existem comandas pendentes");
        }
    }//GEN-LAST:event_mCloseActionPerformed

    private void mComanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mComanActionPerformed
        new OrderPend().setVisible(true);
    }//GEN-LAST:event_mComanActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new ReportComiss().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new About().setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void mUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUserActionPerformed
        new UserList().setVisible(true);
    }//GEN-LAST:event_mUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtendimento;
    private javax.swing.JButton btnCaixa;
    private javax.swing.JButton btnRequests;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem mCadOperador;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenuItem mClose;
    private javax.swing.JMenuItem mComan;
    private javax.swing.JMenuItem mConfig;
    private javax.swing.JMenu mFinanc;
    private javax.swing.JMenuItem mLog;
    private javax.swing.JMenuItem mProdList;
    private javax.swing.JMenu mRelatorio;
    private javax.swing.JMenuItem mUser;
    // End of variables declaration//GEN-END:variables
}
