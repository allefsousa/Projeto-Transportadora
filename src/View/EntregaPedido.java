/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoTransPedido;
import Funcionalidades.ModeloTabela;
import Model.TransportadoraPedido;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Felipe
 */
public class EntregaPedido extends javax.swing.JFrame {

    ConnBanco connBanco = new ConnBanco();
    ConnBanco conEnt = new ConnBanco();
    ConnBanco banco = new ConnBanco();
    ConnBanco banco1 = new ConnBanco();
    TransportadoraPedido transPed = new TransportadoraPedido();
    Dao.DaoTransPedido daoTransPed = new DaoTransPedido();

    /**
     * Creates new form EntregaPedido
     */
    public EntregaPedido() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setExtendedState(MAXIMIZED_BOTH);
        connBanco.getConection();
        listaCentroDist();
    }

    public void preencherTabela(String sql) {
        int cliente = 0, cidadeColeta = 0, cidadeEntrega = 0, veiculo = 0;
        String cli, cidEnt, cidCol, veic;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Nº Pedido", "Data de Coleta", "Endereço", "Nº Coleta", "Bairro",
            "CEP", "Cidade de Coleta", "Data de Entrega", "Endereço Entrega", "Nº Entrega", "Bairro",
            "Cep", "Cidade de Entrega", "Data de Solicitação", "Descrição Pedido", "Cliente", "Veiculo", "Rota"};
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        connBanco.executaSQL(sql);
        try {
            connBanco.rs.first();
            do {
                cliente = connBanco.rs.getInt("fk_Id_Cliente");
                sql = "SELECT razao_Social_cli FROM cliente where id_Cli = ?";
                cli = daoTransPed.chaveEstrangeira(sql, cliente);

                //Tratando cidade de coleta
                cidadeColeta = connBanco.rs.getInt("fk_IdCidade_Coleta");
                sql = "SELECT nome FROM cidade where id = ?";
                cidCol = daoTransPed.chaveEstrangeira(sql, cidadeColeta);

                //Tratando cidade de entrega
                cidadeEntrega = connBanco.rs.getInt("fk_IdCidade_Entrega");
                sql = "SELECT nome FROM cidade where id = ?";
                cidEnt = daoTransPed.chaveEstrangeira(sql, cidadeEntrega);

                veiculo = connBanco.rs.getInt("fk_Id_Veiculo");
                sql = "SELECT modelo FROM veiculo where id_Veiculo = ?";
                veic = daoTransPed.chaveEstrangeira(sql, veiculo);

                dados.add(new Object[]{connBanco.rs.getInt("num_Pedido"), formatter.format(connBanco.rs.getDate("data_Coleta")),
                    connBanco.rs.getString("rua_Coleta"), connBanco.rs.getInt("num_End_Coleta"),
                    connBanco.rs.getString("bairro_Coleta"), connBanco.rs.getString("cep_Coleta"),
                    cidCol, formatter.format(connBanco.rs.getDate("data_Entrega")),
                    connBanco.rs.getString("rua_Entrega"), connBanco.rs.getString("num_End_Entrega"),
                    connBanco.rs.getString("bairro_Entrega"), connBanco.rs.getString("cep_Entrega"),
                    cidEnt, formatter.format(connBanco.rs.getDate("data_Solicitacao")), connBanco.rs.getString("descricao_Produto"),
                    cli, veic, connBanco.rs.getString("fk_Id_Rota")});

            } while (connBanco.rs.next());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela !");
        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaEntrega.setModel(modelo);
        tabelaEntrega.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabelaEntrega.getColumnModel().getColumn(0).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(1).setPreferredWidth(110);
        tabelaEntrega.setSelectionBackground(Color.lightGray);
        tabelaEntrega.setSelectionForeground(Color.BLUE);
        tabelaEntrega.getColumnModel().getColumn(1).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(2).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(2).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(3).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(3).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(4).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(4).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(5).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(5).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(6).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(6).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(7).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(7).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(8).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(8).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(9).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(9).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(10).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(10).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(11).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(11).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(12).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(12).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(13).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(13).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(14).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(14).setResizable(true);
        tabelaEntrega.getColumnModel().getColumn(15).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(15).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(16).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(16).setResizable(false);
        tabelaEntrega.getColumnModel().getColumn(17).setPreferredWidth(110);
        tabelaEntrega.getColumnModel().getColumn(17).setResizable(false);

        tabelaEntrega.getTableHeader().setReorderingAllowed(false);
        tabelaEntrega.setAutoResizeMode(tabelaEntrega.AUTO_RESIZE_OFF);
        tabelaEntrega.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void limpar() {
        txtCodigo.setText(" ");
        cbxDataEntrega.setDate(null);
        cbxStatus.setSelectedIndex(0);
        cbxCentroDist.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BarraMenu = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEntrega = new javax.swing.JTable();
        lblCodigo = new javax.swing.JLabel();
        lblDataEntrega = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cbxDataEntrega = new com.toedter.calendar.JDateChooser();
        btnEntrega = new javax.swing.JButton();
        cbxStatus = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbxCentroDist = new javax.swing.JComboBox();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("EntregaPedido"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BarraMenu.setBackground(new java.awt.Color(0, 28, 119));
        BarraMenu.setPreferredSize(new java.awt.Dimension(860, 43));

        btnSair.setBackground(new java.awt.Color(0, 28, 119));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair.png"))); // NOI18N
        btnSair.setBorder(null);
        btnSair.setBorderPainted(false);
        btnSair.setFocusPainted(false);
        btnSair.setMaximumSize(new java.awt.Dimension(30, 30));
        btnSair.setMinimumSize(new java.awt.Dimension(30, 30));
        btnSair.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("ENTREGA DE PEDIDOS");

        btnSair1.setBackground(new java.awt.Color(0, 28, 119));
        btnSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Minimizar.png"))); // NOI18N
        btnSair1.setBorder(null);
        btnSair1.setBorderPainted(false);
        btnSair1.setFocusPainted(false);
        btnSair1.setMaximumSize(new java.awt.Dimension(30, 30));
        btnSair1.setMinimumSize(new java.awt.Dimension(30, 30));
        btnSair1.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraMenuLayout = new javax.swing.GroupLayout(BarraMenu);
        BarraMenu.setLayout(BarraMenuLayout);
        BarraMenuLayout.setHorizontalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraMenuLayout.setVerticalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(btnSair1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabelaEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaEntrega);

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCodigo.setText("CODIGO PEDIDO:");

        lblDataEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDataEntrega.setText("DATA DA ENTREGA:");

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("STATUS:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnEntrega.setBackground(new java.awt.Color(0, 28, 119));
        btnEntrega.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEntrega.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/checked.png"))); // NOI18N
        btnEntrega.setText("BAIXA / ENTREGUE");
        btnEntrega.setFocusPainted(false);
        btnEntrega.setFocusable(false);
        btnEntrega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Status", "Entregue" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("UNIDADE:");

        cbxCentroDist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecone uma unidade" }));

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDataEntrega)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCodigo, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo)
                    .addComponent(cbxDataEntrega, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(cbxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCentroDist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCodigo)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDataEntrega)
                                    .addComponent(cbxDataEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnPesquisar)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuario)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxCentroDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        this.setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        boolean loop = true;
        try {
            //Tratando entrada de código do pedido
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira um código válido");
            } else {
                do {
                    //Verificando se registro do pedido existe  no banco de dados
                    String codigo = txtCodigo.getText();
                    String sql1 = "SELECT num_Pedido FROM pedido WHERE num_Pedido = ?;";
                    banco.conn = banco.getConection();
                    banco.pstm = banco.conn.prepareStatement(sql1);
                    banco.pstm.setString(1, codigo);
                    ResultSet rs1 = banco.pstm.executeQuery();
                    if (rs1.next()) {
                        preencherTabela("SELECT * FROM pedido where num_Pedido = " + Integer.parseInt(txtCodigo.getText()));
                    } else {
                        //Tratando entrada de código caso seja inserido texto
                        JOptionPane.showMessageDialog(null, "Número de pedido não existe\n"
                                + "Insira um número válido !");
                    }
                    loop = false;
                } while (loop);

            }
        } catch (NumberFormatException e) {
            //Exceção de entrada fora do esperado (nesse caso...)
            JOptionPane.showMessageDialog(null, "Insira um código válido !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        boolean loop = true;
        try {
            //Tratando caixa combinada de Centro de Distribuição
            if (cbxCentroDist.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Selecione um centro de Distribuição !");
            } else {
                String nomeFantasia = (String) cbxCentroDist.getSelectedItem();
                String sql1 = "SELECT cnpj FROM centro_Dist WHERE nome_Fantasia = ?;";
                banco.conn = banco.getConection();
                banco.pstm = banco.conn.prepareStatement(sql1);
                banco.pstm.setString(1, nomeFantasia);
                ResultSet rs1 = banco.pstm.executeQuery();
                //Verificando se o pedido já não teve sua entrada registrada no Centro de distribuição em questão
                if (rs1.next()) {
                    String sqlCD = "SELECT * FROM Transportadora_pedido where fk_Num_Pedido = ? and status_Pedido = ?";
                    String id = txtCodigo.getText();
                    String stt = (String) cbxStatus.getSelectedItem();
                    banco.conn = banco.getConection();
                    banco.pstm = banco.conn.prepareStatement(sqlCD);
                    banco.pstm.setString(1, id);
                    banco.pstm.setString(2, stt);
                    ResultSet rs2 = banco.pstm.executeQuery();

                    //Caso possua registro mostra mensagem de advertência
                    if (rs2.next()) {
                        JOptionPane.showMessageDialog(null, "Pedido Inválido... Este pedido já foi entregue !");
                    } else {
                        transPed.setCentroDist(rs1.getString("cnpj"));
                        //Verificando se o campo de entrada de código não está vazio
                        if (txtCodigo.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Insira um código válido");
                        } else {
                            //Verificando se caracteres inválidos foram inseridos
                            do {
                                transPed.setNumPedido(Integer.parseInt(txtCodigo.getText()));
                                loop = false;
                            } while (loop);
                            //Verificando se entrada de data não está vazio
                            if (cbxDataEntrega.getDate() == null) {
                                JOptionPane.showMessageDialog(null, "Insira a data de entrega!");
                            } else {
                                transPed.setDataEntrega(cbxDataEntrega.getDate());
                                //Verificando se entrada de status não está vazio
                                if (cbxStatus.getSelectedIndex() == 0) {
                                    JOptionPane.showMessageDialog(null, "Insira o status do pedido !");
                                } else {
                                    transPed.setStatus((String) cbxStatus.getSelectedItem());

                                    daoTransPed.inserirEntregaPedido(transPed);
                                    JOptionPane.showMessageDialog(null, "Pedido registrado com sucesso !");
                                    limpar();
                                }
                            }
                        }
                    }
                }
            }
            //limpar();
        } catch (NumberFormatException e) {
            //Exceção de entrada fora do esperado (nesse caso...)
            JOptionPane.showMessageDialog(null, "Insira um código válido !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao registrar entrada !");
        }
    }//GEN-LAST:event_btnEntregaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EntregaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntregaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntregaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntregaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntregaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JComboBox cbxCentroDist;
    private com.toedter.calendar.JDateChooser cbxDataEntrega;
    private javax.swing.JComboBox cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataEntrega;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tabelaEntrega;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    public void listaCentroDist() {
        String sql = "SELECT * FROM centro_dist";
        try {
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql);
            ResultSet rs = banco.executaSQLRetorno(sql);
            while (rs.next()) {
                cbxCentroDist.addItem(rs.getString("nome_Fantasia"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
