/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.view;

import com.app.gerecia.config.Manager;
import com.app.gerecia.config.Messager;
import com.app.gerecia.config.Print;
import com.app.gerecia.config.TempFileUser;
import com.app.gerecia.model.Customer;
import com.app.gerecia.model.Order;
import com.app.gerecia.model.Product;
import com.app.gerecia.model.Sale;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rique
 */
public class Delivery extends javax.swing.JFrame {

    private int idSelect;
    private String valor;
    /**
     * Creates new form Delivery
     */
    public Delivery() {
        initComponents();
    }

    public void orderList(int tel) {
        tblItens.setModel(DbUtils.resultSetToTableModel(new Sale().consultaSaleDelivery(tel)));
        double count = 0;
        for (int i = 0; i <= tblItens.getRowCount() - 1; i++) {
            count += Double.parseDouble(tblItens.getValueAt(i, 4).toString());
        }
        lbValorTotal.setText(String.format("R$ %2.5s", String.valueOf(count)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dinheiroOuCartao = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtBuscarC = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbEnd = new javax.swing.JLabel();
        txtProtocolo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        lbCep = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBusca = new javax.swing.JTable();
        txtBuscaP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        lbValorTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chkDinheiro = new javax.swing.JRadioButton();
        chkCatao = new javax.swing.JRadioButton();
        chkTroco = new javax.swing.JCheckBox();
        chkDebito = new javax.swing.JRadioButton();
        chkCredito = new javax.swing.JRadioButton();
        txtTroco = new javax.swing.JFormattedTextField();
        btnFinal = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnZero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delivery");
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 10))); // NOI18N

        btnConsultar.setBackground(new java.awt.Color(204, 204, 204));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        jLabel2.setText("Rua:");

        jLabel3.setText("Numero:");

        jLabel4.setText("Nome:");

        jLabel6.setText("CEP:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Protocolo de entrega:");

        jLabel8.setText("Busca por telefone");

        txtProtocolo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEnd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConsultar)
                            .addComponent(txtBuscarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtProtocolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adicionar Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 10))); // NOI18N

        tblBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblBusca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscaMouseClicked(evt);
            }
        });
        tblBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblBuscaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblBusca);

        txtBuscaP.setEnabled(false);
        txtBuscaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaPKeyReleased(evt);
            }
        });

        jLabel5.setText("Busca");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscaP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pedido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 10))); // NOI18N

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
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblItens);

        txtObs.setEnabled(false);
        jScrollPane2.setViewportView(txtObs);

        jLabel1.setText("Observação");

        btnRemover.setBackground(new java.awt.Color(204, 204, 204));
        btnRemover.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lbValorTotal.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lbValorTotal.setText("R$");

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel9.setText("Valor da comanda:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opcoes de pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 10))); // NOI18N

        dinheiroOuCartao.add(chkDinheiro);
        chkDinheiro.setSelected(true);
        chkDinheiro.setText("Dinheiro");
        chkDinheiro.setEnabled(false);
        chkDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDinheiroActionPerformed(evt);
            }
        });

        dinheiroOuCartao.add(chkCatao);
        chkCatao.setText("Cartao");
        chkCatao.setEnabled(false);
        chkCatao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCataoActionPerformed(evt);
            }
        });

        chkTroco.setText("Levar troco para:");
        chkTroco.setEnabled(false);
        chkTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTrocoActionPerformed(evt);
            }
        });

        buttonGroup1.add(chkDebito);
        chkDebito.setSelected(true);
        chkDebito.setText("Debito");
        chkDebito.setEnabled(false);

        buttonGroup1.add(chkCredito);
        chkCredito.setText("Credito");
        chkCredito.setEnabled(false);

        txtTroco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0,00"))));
        txtTroco.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkDinheiro)
                    .addComponent(chkCatao))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chkTroco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chkDebito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkCredito)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkDinheiro)
                        .addComponent(chkTroco)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCatao)
                    .addComponent(chkDebito)
                    .addComponent(chkCredito))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinal.setBackground(new java.awt.Color(204, 204, 204));
        btnFinal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnFinal.setText("Finalizar e imprimir");
        btnFinal.setEnabled(false);
        btnFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Sair");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnZero.setBackground(new java.awt.Color(204, 204, 204));
        btnZero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnZero.setForeground(new java.awt.Color(102, 0, 0));
        btnZero.setText("Fechar comanda zerada");
        btnZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZeroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnZero, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinal)
                    .addComponent(btnCancelar)
                    .addComponent(btnZero))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDinheiroActionPerformed
        if (chkDinheiro.isSelected() == true) {
            chkTroco.setEnabled(true);
            chkDebito.setEnabled(false);
            chkCredito.setEnabled(false);
        }
    }//GEN-LAST:event_chkDinheiroActionPerformed

    private void chkCataoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCataoActionPerformed
        if (chkCatao.isSelected() == true) {
            chkTroco.setEnabled(false);
            chkDebito.setEnabled(true);
            chkCredito.setEnabled(true);
        }
    }//GEN-LAST:event_chkCataoActionPerformed

    private void txtBuscaPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaPKeyReleased
        tblBusca.setModel(DbUtils.resultSetToTableModel(new Product().advancedSearch(txtBuscaP.getText())));
    }//GEN-LAST:event_txtBuscaPKeyReleased

    private void tblBuscaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscaMouseClicked
        int setar = tblBusca.getSelectedRow();
        Product p = new Product();
        p.setId(Integer.parseInt(tblBusca.getModel().getValueAt(setar, 0).toString()));
        p.setNome(tblBusca.getModel().getValueAt(setar, 1).toString());
        p.setValor(Double.parseDouble(tblBusca.getModel().getValueAt(setar, 2).toString()));
        OrderConfirmation atc = new OrderConfirmation(this, true);
        atc.exportDataDelivery(p,this, 1,Integer.parseInt(txtBuscarC.getText()));;
        atc.setVisible(true);
    }//GEN-LAST:event_tblBuscaMouseClicked

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        Integer contato = Integer.parseInt(txtBuscarC.getText());
        Order p = new Order();
        Customer c = new Customer();
        p.setNumero_contato(contato);
        if (p.consultaDelivery() == true) {
            c.setTelefone(Integer.parseInt(txtBuscarC.getText()));
            c.search();
            lbEnd.setText(c.getEndereco());
            lbNome.setText(c.getNome());
            lbEnd.setText(c.getEndereco());
            lbNumero.setText(c.getNumero().toString());
            lbCep.setText(c.getCep().toString());
            String temp = String.valueOf(p.getId());
            txtProtocolo.setText(p.getId().toString());
            txtBuscaP.setEnabled(true);
            txtObs.setEnabled(true);
            btnConsultar.setEnabled(false);
            txtBuscarC.setEnabled(false);
            chkDinheiro.setEnabled(true);
            chkCatao.setEnabled(true);
            btnFinal.setEnabled(true);
            orderList(p.getNumero_contato());
            new TempFileUser().tempWriterOrder(temp);
        } else {
            //>>>>>>>>>>>>if para saber se esta cadastrado no banco<<<<<<<<<
            c.setTelefone(Integer.parseInt(txtBuscarC.getText()));
            if (c.search() == true) {
                System.out.println("teste nova comanda");
                int val = JOptionPane.showConfirmDialog(null, Messager.NEW_DELIVERY,
                        "ALERTA", JOptionPane.OK_CANCEL_OPTION);
                if (val == 0) {
                    p.setNumero_contato(Integer.parseInt(txtBuscarC.getText()));
                    if (p.orderCreateDelivery() == true) {
                        if (p.consultaDelivery() == true) {
                            String temp = String.valueOf(p.getId());
                            txtProtocolo.setText(p.getId().toString());
                            lbEnd.setText(c.getEndereco());
                            lbNome.setText(c.getNome());
                            lbEnd.setText(c.getEndereco());
                            lbNumero.setText(c.getNumero().toString());
                            lbCep.setText(c.getCep().toString());
                            txtBuscaP.setEnabled(true);
                            txtObs.setEnabled(true);
                            btnConsultar.setEnabled(false);
                            txtBuscarC.setEnabled(false);
                            chkDinheiro.setEnabled(true);
                            chkCatao.setEnabled(true);
                            btnFinal.setEnabled(true);
                            orderList(p.getNumero_contato());
                            new TempFileUser().tempWriterOrder(temp);
                        }
                    }
                }
            } else {
                int val = JOptionPane.showConfirmDialog(null, Messager.NEW_DELIVERY_CAD,
                        "ALERTA", JOptionPane.OK_CANCEL_OPTION);
                if (val == 0) {
                    new CadDelivery().setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void tblBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblBuscaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int setar = tblBusca.getSelectedRow();
            Product p = new Product();
            p.setId(Integer.parseInt(tblBusca.getModel().getValueAt(setar, 0).toString()));
            p.setNome(tblBusca.getModel().getValueAt(setar, 1).toString());
            p.setValor(Double.parseDouble(tblBusca.getModel().getValueAt(setar, 2).toString()));
            OrderConfirmation atc = new OrderConfirmation(this, true);
            atc.exportDataDelivery(p,this, 1,Integer.parseInt(txtBuscarC.getText()));
            atc.setVisible(true);
        }
    }//GEN-LAST:event_tblBuscaKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTrocoActionPerformed
        if (chkTroco.isSelected()) {
            txtTroco.setEnabled(true);
        } else {
            txtTroco.setText("");
            txtTroco.setEnabled(false);
        }
    }//GEN-LAST:event_chkTrocoActionPerformed

    private void btnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalActionPerformed
        Order o = new Order();
        Integer id = Integer.parseInt(txtProtocolo.getText());
        Integer debt = 0;
        Integer crt = 0;
        Integer dinheiro = 0;
        Double troco = 0.0;
        String obs = txtObs.getText();
        if (!txtObs.getText().equals("")) {
            o.DeliveryObs(obs, id);
        }
        if (chkDinheiro.isSelected()) {
            dinheiro = 1;
        } else {
            dinheiro = 0;
        }
        if (!txtTroco.getText().equals("")) {
            troco = Double.parseDouble(txtTroco.getText());
        }
        if (chkCatao.isSelected()) {
            if (chkDebito.isSelected()) {
                debt = 1;
            } else {
                debt = 0;
            }
            if (chkCredito.isSelected()) {
                 crt = 1;
            } else {
                crt = 0;
            }
        }
        o.DeliveryPay(id, debt, crt, dinheiro, troco);
        o.orderUpdate1(id);
        new Print().printProtocol(Integer.parseInt(txtProtocolo.getText()));
        dispose();
    }//GEN-LAST:event_btnFinalActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Sale s = new Sale();
        if (s.SaleCancel(idSelect).equals(true)) {
            System.out.println("ok");
            orderList(Integer.parseInt(txtBuscarC.getText()));
            new Manager().logData(Integer.parseInt(new TempFileUser()
                 .tempReadUser()), "Venda no valor de "+ valor+" cancelada");
            btnRemover.setEnabled(false);
        } 
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked
       int setar = tblItens.getSelectedRow();
        idSelect = Integer.parseInt(tblItens.getModel()
                .getValueAt(setar, 0).toString());
        valor = tblItens.getModel()
                .getValueAt(setar, 2).toString();
        btnRemover.setEnabled(true);
    }//GEN-LAST:event_tblItensMouseClicked

    private void btnZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZeroActionPerformed
        orderList(Integer.parseInt(txtBuscarC.getText()));
        if (lbValorTotal.getText().equals("R$ 0.0")) {
            new Sale().ZeroSaleDelivery(txtProtocolo.getText());
            dispose();
            new Delivery().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Comanda com venda");
        }
    }//GEN-LAST:event_btnZeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnFinal;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnZero;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton chkCatao;
    private javax.swing.JRadioButton chkCredito;
    private javax.swing.JRadioButton chkDebito;
    private javax.swing.JRadioButton chkDinheiro;
    private javax.swing.JCheckBox chkTroco;
    private javax.swing.ButtonGroup dinheiroOuCartao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCep;
    private javax.swing.JLabel lbEnd;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JTable tblBusca;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtBuscaP;
    private javax.swing.JTextField txtBuscarC;
    private javax.swing.JTextPane txtObs;
    private javax.swing.JLabel txtProtocolo;
    private javax.swing.JFormattedTextField txtTroco;
    // End of variables declaration//GEN-END:variables
}
