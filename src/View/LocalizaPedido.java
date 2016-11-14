/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoPesquisa_Produto;
import Funcionalidades.FormataçãoTabela;
import Funcionalidades.ModeloTabela;
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
public class LocalizaPedido extends javax.swing.JFrame {

    /**
     * Creates new form LocalizaPedido
     */
    FormataçãoTabela cortabela = new FormataçãoTabela(); // objeto para colorir uma celula da tabela
    Dao.DaoPesquisa_Produto daopesquisa = new DaoPesquisa_Produto();
    ConnBanco connBanco = new ConnBanco();

    public LocalizaPedido() {
        setExtendedState(MAXIMIZED_BOTH);

        initComponents();

        connBanco.getConection();
       // preencherTabela("SELECT * FROM transportadora_pedido order by fk_Num_Pedido");
        setLocationRelativeTo(this);
        Color nomesCor = new Color(250, 128, 114);
        cortabela.setBackground(nomesCor);
    }

    public void ModeloTabela(ArrayList dados) {

        String[] colunas = new String[]{"Numero Pedido", "Centro Dstribuição", "Data", "Situação Pedido"};
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaPedido.setModel(modelo);

        tabelaPedido.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabelaPedido.getColumnModel().getColumn(0).setResizable(true);
        tabelaPedido.getColumnModel().getColumn(1).setPreferredWidth(370);

        tabelaPedido.getColumnModel().getColumn(1).setResizable(true);
        tabelaPedido.getColumnModel().getColumn(2).setPreferredWidth(260);
        tabelaPedido.getColumnModel().getColumn(2).setResizable(true);
         tabelaPedido.getColumnModel().getColumn(3).setPreferredWidth(458);
        tabelaPedido.getColumnModel().getColumn(3).setResizable(false);
        tabelaPedido.getColumnModel().getColumn(3).setCellRenderer(cortabela);
        tabelaPedido.setAutoResizeMode(tabelaPedido.AUTO_RESIZE_OFF);
        tabelaPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public final void preencherTabela(String SQL) {
        int centrodis;
        String centrodist = null, sql;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Numero Pedido", "Centro Dstribuição", "Data Entrada Filial", "Data Saida Filial","Data Prev Entrega", "Situação Pedido"};
        connBanco.getConection();
        connBanco.executaSQL(SQL);
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // pegando o primeiro registro 

        try {

            if (!connBanco.rs.first()) {
                txtregistro.setForeground(Color.red);
                txtregistro.setText("Não ha Registros Para Serem Exibidos");

            } else {

                connBanco.rs.first();

                // pegando os valores e formatando para preecher a tabela  
                do {
                    centrodist = connBanco.rs.getString(("fk_Centro_Dist"));
                    sql = "SELECT nome_Fantasia from centro_dist where cnpj = ?";
                    centrodist = daopesquisa.chaveEstrangeiraString(sql, centrodist);
                   
                        dados.add(new Object[]{connBanco.rs.getInt("fk_Num_Pedido"), centrodist,formatter.format(connBanco.rs.getDate("dataEntrada")), (connBanco.rs.getDate("dataSaida")), (connBanco.rs.getDate("dataEntrega")) ,connBanco.rs.getString("status_Pedido")});

                    
                } while (connBanco.rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

//E na tabela eu set o renderer dela assim
        // colocando os devidos valores em suas colunas 
        ModeloTabela(dados);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcodigoPedido = new javax.swing.JTextField();
        txtregistro = new javax.swing.JLabel();
        BarraMenu3 = new javax.swing.JPanel();
        btnSair3 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair4 = new javax.swing.JButton();
        BarraMenu4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaPedido);

        btnPesquisar.setBackground(new java.awt.Color(0, 28, 119));
        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisa.png"))); // NOI18N
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("CODIGO:");

        txtcodigoPedido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtregistro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        BarraMenu3.setBackground(new java.awt.Color(0, 28, 119));

        btnSair3.setBackground(new java.awt.Color(0, 28, 119));
        btnSair3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Sair.png"))); // NOI18N
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

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("PESQUISAR PEDIDOS");

        btnSair4.setBackground(new java.awt.Color(0, 28, 119));
        btnSair4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Minimizar.png"))); // NOI18N
        btnSair4.setBorder(null);
        btnSair4.setBorderPainted(false);
        btnSair4.setFocusPainted(false);
        btnSair4.setMaximumSize(new java.awt.Dimension(30, 30));
        btnSair4.setMinimumSize(new java.awt.Dimension(30, 30));
        btnSair4.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSair4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraMenu3Layout = new javax.swing.GroupLayout(BarraMenu3);
        BarraMenu3.setLayout(BarraMenu3Layout);
        BarraMenu3Layout.setHorizontalGroup(
            BarraMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraMenu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraMenu3Layout.setVerticalGroup(
            BarraMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSair3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BarraMenu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnSair4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        BarraMenu4.setBackground(new java.awt.Color(0, 28, 119));

        javax.swing.GroupLayout BarraMenu4Layout = new javax.swing.GroupLayout(BarraMenu4);
        BarraMenu4.setLayout(BarraMenu4Layout);
        BarraMenu4Layout.setHorizontalGroup(
            BarraMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );
        BarraMenu4Layout.setVerticalGroup(
            BarraMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcodigoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addComponent(BarraMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BarraMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtcodigoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BarraMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        ResultSet rs1 = null;
        String NPedido = "", centrodist, sql;
        NPedido = txtcodigoPedido.getText();
        int npedido;
        int cidade;
        Long unidade;
        String cid = null, sql1, result;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Numero Pedido", "Centro Dstribuição", "Data", "Situação Pedido"};
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String sql2 = "SELECT * FROM transportadora_pedido where fk_Num_Pedido = ? ";
            connBanco.conn = connBanco.getConection();
            connBanco.pstm = connBanco.conn.prepareStatement(sql2);

            connBanco.pstm.setInt(1, Integer.parseInt(NPedido));
            rs1 = connBanco.pstm.executeQuery();

            if (rs1.next()) {
                npedido = (rs1.getInt("fk_Num_Pedido"));
            }

        } catch (SQLException ex) {

        }
        try {
            if (!rs1.first()) {
                txtregistro.setForeground(Color.red);
                txtregistro.setText("Não ha Registros com esse Numero Para Serem Exibidos");

            } else {

                rs1.first();

                // pegando os valores e formatando para preecher a tabela  
                do {
                    centrodist = rs1.getString(("fk_Centro_Dist"));
                    sql = "SELECT nome_Fantasia from centro_dist where cnpj = ?";
                    centrodist = daopesquisa.chaveEstrangeiraString(sql, centrodist);                   
                        dados.add(new Object[]{rs1.getInt("fk_Num_Pedido"), centrodist, (rs1.getDate("data")), rs1.getString("status_Pedido")});
                } while (rs1.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        ModeloTabela(dados);

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSair3ActionPerformed

    private void btnSair4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair4ActionPerformed
        this.setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_btnSair4ActionPerformed

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
            java.util.logging.Logger.getLogger(LocalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocalizaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocalizaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu3;
    private javax.swing.JPanel BarraMenu4;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair3;
    private javax.swing.JButton btnSair4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabelaPedido;
    private javax.swing.JTextField txtcodigoPedido;
    private javax.swing.JLabel txtregistro;
    // End of variables declaration//GEN-END:variables
}
