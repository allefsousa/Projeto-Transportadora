/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoRota;
import Funcionalidades.ModeloTabela;
import Model.modelRota;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Allef
 */
public class CadastraRota extends javax.swing.JFrame {

    /**
     * Creates new form CadastraRota
     */
    modelRota mrota = new modelRota();
    Dao.DaoRota daorota = new DaoRota();
    ConnBanco connBanco = new ConnBanco();
    ConnBanco banco = new ConnBanco();

    public CadastraRota() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        connBanco.getConection();
        banco.getConection();
        preencherTabela("select * from rota;");
        setLocationRelativeTo(this);
        listarCidEst();
    }

    public void preencherTabela(String SQL) {
        int cidadeOrigem, cidadeDestino;
        String cidOrigem, cidDestino, sql, sql1;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID Rota", "Quantidade dias Prevista Entrega", "Valor Rota", "Cidade de Origem", "Cidade de Destino", "Descrição Rota"};

        connBanco.executaSQL(SQL);
        // pegando o primeiro registro 
        try {
            connBanco.rs.first();

            // pegando os valores e formatando para preecher a tabela  
            do {
                cidadeOrigem = connBanco.rs.getInt("fk_Id_Cidade_Origem");
                sql = "SELECT nome FROM cidade where id = ?";
                cidOrigem = daorota.chaveEstrangeira(sql, cidadeOrigem);

                cidadeDestino = connBanco.rs.getInt("fk_Id_Cidade_Destino");
                sql1 = "SELECT nome FROM cidade where id = ?";
                cidDestino = daorota.chaveEstrangeira(sql1, cidadeDestino);

                dados.add(new Object[]{connBanco.rs.getInt("numero_Rota"), connBanco.rs.getInt("qtd_Dias"),
                    connBanco.rs.getFloat("valor_Rota"), cidOrigem, cidDestino, connBanco.rs.getString("descricao_rota")});
            } while (connBanco.rs.next());

            //connBanco.conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex);
        }
        // colocando os devidos valores em suas colunas 
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelarota.setModel(modelo);
        tabelarota.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabelarota.getColumnModel().getColumn(0).setResizable(true);
        tabelarota.getColumnModel().getColumn(1).setPreferredWidth(210);
        tabelarota.setSelectionBackground(Color.lightGray);
        tabelarota.setSelectionForeground(Color.BLUE);
        tabelarota.getColumnModel().getColumn(1).setResizable(true);
        tabelarota.getColumnModel().getColumn(2).setPreferredWidth(160);
        tabelarota.getColumnModel().getColumn(2).setResizable(false);
        tabelarota.getColumnModel().getColumn(3).setPreferredWidth(160);
        tabelarota.getColumnModel().getColumn(3).setResizable(false);
        tabelarota.getColumnModel().getColumn(4).setPreferredWidth(160);
        tabelarota.getColumnModel().getColumn(4).setResizable(false);
        tabelarota.getColumnModel().getColumn(5).setPreferredWidth(160);
        tabelarota.getColumnModel().getColumn(5).setResizable(false);

        tabelarota.getTableHeader().setReorderingAllowed(false);
        tabelarota.setAutoResizeMode(tabelarota.AUTO_RESIZE_OFF);
        tabelarota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void limpar() {
        txtid.setText("");
        txtquantidade.setText("");
        txtvalor.setText("");
        cbxCidadeOrigem.setSelectedIndex(0);
        cbxCidadeDestino.setSelectedIndex(0);
        txtdescricao.setText("");
    }

    public void listarCidEst() {
        String sqlOrigem = ("select * from cidade;");

        try {
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sqlOrigem);
            ResultSet rscidadeOrigem = banco.executaSQLRetorno(sqlOrigem);

            banco.pstm = banco.conn.prepareStatement(sqlOrigem);
            ResultSet rscidadeDestino = banco.executaSQLRetorno(sqlOrigem);

            while (rscidadeOrigem.next()) {
                //cbxCidade.addItem(rscidade.getString(1));
                cbxCidadeOrigem.addItem(rscidadeOrigem.getString("nome"));
            }

            while (rscidadeDestino.next()) {
                //cbxCidade.addItem(rscidade.getString(1));
                cbxCidadeDestino.addItem(rscidadeDestino.getString("nome"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelarota = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtvalor = new javax.swing.JTextField();
        txtquantidade = new javax.swing.JTextField();
        txtdescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BarraMenu2 = new javax.swing.JPanel();
        btnSair2 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BarraMenu3 = new javax.swing.JPanel();
        cbxCidadeOrigem = new javax.swing.JComboBox();
        cbxCidadeDestino = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar Rota");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnnovo.setBackground(new java.awt.Color(0, 28, 119));
        btnnovo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnnovo.setForeground(new java.awt.Color(255, 255, 255));
        btnnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Novo.png"))); // NOI18N
        btnnovo.setText("NOVO");
        btnnovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnnovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setBackground(new java.awt.Color(0, 28, 119));
        btnsalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnsalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Gravar.png"))); // NOI18N
        btnsalvar.setText("SALVAR");
        btnsalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 28, 119));
        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Editar.png"))); // NOI18N
        jButton3.setText("EDITAR");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Remover.setBackground(new java.awt.Color(0, 28, 119));
        Remover.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Remover.setForeground(new java.awt.Color(255, 255, 255));
        Remover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Excluir.png"))); // NOI18N
        Remover.setText("EXCLUIR");
        Remover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Remover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        tabelarota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelarota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelarotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelarota);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Valor frete:");

        txtid.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Numero rota:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade de dias:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Descrição rota:");

        BarraMenu2.setBackground(new java.awt.Color(0, 28, 119));

        btnSair2.setBackground(new java.awt.Color(0, 28, 119));
        btnSair2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair.png"))); // NOI18N
        btnSair2.setBorder(null);
        btnSair2.setBorderPainted(false);
        btnSair2.setFocusPainted(false);
        btnSair2.setMaximumSize(new java.awt.Dimension(30, 30));
        btnSair2.setMinimumSize(new java.awt.Dimension(30, 30));
        btnSair2.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair2ActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("CADASTRAR FUNCIONARIO");

        btnSair3.setBackground(new java.awt.Color(0, 28, 119));
        btnSair3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Minimizar.png"))); // NOI18N
        btnSair3.setBorder(null);
        btnSair3.setBorderPainted(false);
        btnSair3.setFocusPainted(false);
        btnSair3.setMaximumSize(new java.awt.Dimension(30, 30));
        btnSair3.setMinimumSize(new java.awt.Dimension(30, 30));
        btnSair3.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSair3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraMenu2Layout = new javax.swing.GroupLayout(BarraMenu2);
        BarraMenu2.setLayout(BarraMenu2Layout);
        BarraMenu2Layout.setHorizontalGroup(
            BarraMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraMenu2Layout.setVerticalGroup(
            BarraMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSair2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BarraMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnSair3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Cidade de Origem:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Cidade de Destino:");

        BarraMenu3.setBackground(new java.awt.Color(0, 28, 119));

        javax.swing.GroupLayout BarraMenu3Layout = new javax.swing.GroupLayout(BarraMenu3);
        BarraMenu3.setLayout(BarraMenu3Layout);
        BarraMenu3Layout.setHorizontalGroup(
            BarraMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        BarraMenu3Layout.setVerticalGroup(
            BarraMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        cbxCidadeOrigem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma cidade" }));

        cbxCidadeDestino.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma cidade" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtquantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addComponent(cbxCidadeOrigem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxCidadeDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(105, Short.MAX_VALUE))
            .addComponent(BarraMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(BarraMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxCidadeOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxCidadeDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(BarraMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        btnnovo.getAccessibleContext().setAccessibleName("105");
        btnnovo.getAccessibleContext().setAccessibleDescription("60");
        btnsalvar.getAccessibleContext().setAccessibleName("105");
        btnsalvar.getAccessibleContext().setAccessibleDescription("60");
        jButton3.getAccessibleContext().setAccessibleName("105");
        jButton3.getAccessibleContext().setAccessibleDescription("60");
        Remover.getAccessibleContext().setAccessibleName("105");
        Remover.getAccessibleContext().setAccessibleDescription("60");

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        txtid.setText("");
        txtvalor.setText("");
        cbxCidadeOrigem.setSelectedIndex(0);
        cbxCidadeDestino.setSelectedIndex(0);
        txtquantidade.setText("");
        txtdescricao.setText("");
        preencherTabela("select * from rota;");
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
        boolean loop = true;
        try {
            if (!txtid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Registro Já Existe Impossivel Salvar ");
            } else {
                //Tratando o campo de descrição de rota
                if (txtdescricao.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Insira uma descrição de rota !! ");
                } else {
                    mrota.setDescricaoRota(txtdescricao.getText());
                    do {
                        //Quantidade de dias
                        mrota.setQuantdias(Integer.parseInt(txtquantidade.getText()));

                        //Valor da Rota
                        mrota.setValorRota(Float.parseFloat(txtvalor.getText()));

                        loop = false;
                    } while (loop);

                    //Tratando Cidade Origem
                    if (cbxCidadeOrigem.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Selecione uma cidade de origem !! ");
                    } else {
                        String cidadeOrigem = (String) cbxCidadeOrigem.getSelectedItem();
                        String sql1 = "SELECT id FROM cidade WHERE nome = ?;";
                        banco.conn = banco.getConection();
                        banco.pstm = banco.conn.prepareStatement(sql1);
                        banco.pstm.setString(1, cidadeOrigem);
                        ResultSet rs1 = banco.pstm.executeQuery();
                        rs1.first();
                        mrota.setIdCidadeOrigem(rs1.getInt("id"));
                    }

                    //Tratando Cidade Destino
                    if (cbxCidadeDestino.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Selecione uma cidade de destino !! ");
                    } else {
                        String cidadeDestino = (String) cbxCidadeDestino.getSelectedItem();
                        String sql2 = "SELECT id FROM cidade WHERE nome = ?;";
                        banco.conn = banco.getConection();
                        banco.pstm = banco.conn.prepareStatement(sql2);
                        banco.pstm.setString(1, cidadeDestino);
                        ResultSet rs2 = banco.pstm.executeQuery();
                        rs2.first();
                        mrota.setIdCidadeDestino(rs2.getInt("id"));
                    }

                    daorota.insereRota(mrota);
                    limpar();

                    preencherTabela("select * from rota;");
                }
            }
        } catch (NumberFormatException e) {
            //Exceção de entrada fora do esperado (nesse caso...)
            JOptionPane.showMessageDialog(null, "Quantidade de dias e/ou valor da rota inválido !");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnsalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        boolean loop = true;
        try {
            if (txtid.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Impossivel Atualizar ");
            } else {
                //Decrição Rota
                if (txtdescricao.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Insira uma descrição para a rota !! ");
                } else {
                    mrota.setDescricaoRota(txtdescricao.getText());

                    do {
                        //Numero Rota
                        mrota.setNumrota(Integer.parseInt(txtid.getText()));
                        //Quantidade de dias
                        mrota.setQuantdias(Integer.parseInt(txtquantidade.getText()));
                        //Valor da Rota
                        mrota.setValorRota(Float.parseFloat(txtvalor.getText()));

                        loop = false;
                    } while (loop);

                    //Tratando Cidade Origem
                    if (cbxCidadeOrigem.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Selecione uma cidade de origem !! ");
                    } else {
                        String cidadeOrigem = (String) cbxCidadeOrigem.getSelectedItem();
                        String sql1 = "SELECT id FROM cidade WHERE nome = ?;";
                        banco.conn = banco.getConection();
                        banco.pstm = banco.conn.prepareStatement(sql1);
                        banco.pstm.setString(1, cidadeOrigem);
                        ResultSet rs1 = banco.pstm.executeQuery();
                        rs1.first();
                        mrota.setIdCidadeOrigem(rs1.getInt("id"));
                    }

                    //Tratando Cidade Destino
                    if (cbxCidadeDestino.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Selecione uma cidade de destino !! ");
                    } else {
                        String cidadeDestino = (String) cbxCidadeDestino.getSelectedItem();
                        String sql2 = "SELECT id FROM cidade WHERE nome = ?;";
                        banco.conn = banco.getConection();
                        banco.pstm = banco.conn.prepareStatement(sql2);
                        banco.pstm.setString(1, cidadeDestino);
                        ResultSet rs2 = banco.pstm.executeQuery();
                        rs2.first();
                        mrota.setIdCidadeDestino(rs2.getInt("id"));
                    }
                    daorota.atualizarRota(mrota);
                    limpar();
                    preencherTabela("select * from rota;");
                }
            }
        } catch (NumberFormatException e) {
            //Exceção de entrada fora do esperado (nesse caso...)
            JOptionPane.showMessageDialog(null, "Quantidade de dias e/ou valor da rota inválido !");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro ?", "SAIDA", JOptionPane.YES_NO_OPTION);
        switch (x) {
            case 0:
                try {
                    if (txtid.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nada para remover !");
                    } else {
                        mrota.setNumrota(Integer.parseInt(txtid.getText()));
                        daorota.deletarRota(mrota);

                        JOptionPane.showMessageDialog(null, "Rota removida com sucesso !");
                        preencherTabela("select * from rota;");
                        limpar();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Impossivel Alterar Rota!! ");
                }
                break;

            case 1:
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_RemoverActionPerformed

    private void tabelarotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelarotaMouseClicked
        try {
            int linha = tabelarota.getSelectedRow();
            int codigo = Integer.parseInt(tabelarota.getValueAt(linha, 0).toString());
            modelRota mro;
            mro = daorota.getrota(codigo);
            txtid.setText(String.valueOf(mro.getNumrota()));
            txtquantidade.setText(String.valueOf(mro.getQuantdias()));
            txtvalor.setText(String.valueOf(mro.getValorRota()));

            //Tratando Cidade Origem
            String cidadeOrigem = String.valueOf(mro.getIdCidadeOrigem());
            String sql1 = "SELECT nome FROM cidade WHERE id = ?;";
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql1);
            banco.pstm.setString(1, cidadeOrigem);
            ResultSet rs1 = banco.pstm.executeQuery();
            rs1.first();
            cbxCidadeOrigem.setSelectedItem(rs1.getString("nome"));

            //Tratando Cidade destino
            String cidadeDestino = String.valueOf(mro.getIdCidadeDestino());
            String sql2 = "SELECT nome FROM cidade WHERE id = ?;";
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql2);
            banco.pstm.setString(1, cidadeDestino);
            ResultSet rs2 = banco.pstm.executeQuery();
            rs2.first();
            cbxCidadeDestino.setSelectedItem(rs2.getString("nome"));

            txtdescricao.setText(mro.getDescricaoRota());
        } catch (Exception e) {
        }


    }//GEN-LAST:event_tabelarotaMouseClicked

    private void btnSair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSair2ActionPerformed

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        this.setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_btnSair3ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastraRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastraRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastraRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastraRota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastraRota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu2;
    private javax.swing.JPanel BarraMenu3;
    private javax.swing.JButton Remover;
    private javax.swing.JButton btnSair2;
    private javax.swing.JButton btnSair3;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JComboBox cbxCidadeDestino;
    private javax.swing.JComboBox cbxCidadeOrigem;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabelarota;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtquantidade;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
