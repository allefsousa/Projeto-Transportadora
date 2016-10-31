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
    public CadastraRota() {
        initComponents();
        connBanco.getConection();
        preencherTabela("select * from rota;");
        setLocationRelativeTo(this);
    }
     public void preencherTabela(String SQL) {
        int cidade, funcionario;
        Long unidade;
        String cid = null,uni,sql1,sql,sql2,fun;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID Rota", "Quantidade dias Prevista Entrega", "Valor Rota", "Descrição Rota"};
        
        connBanco.executaSQL(SQL);
        // pegando o primeiro registro 
        try {
            connBanco.rs.first();

            // pegando os valores e formatando para preecher a tabela  
            do {
                
                
                dados.add(new Object[]{connBanco.rs.getInt("numero_Rota"), connBanco.rs.getInt("qtd_Dias"),
                    connBanco.rs.getFloat("valor_Rota"), connBanco.rs.getString("descricao_rota")});
            } while (connBanco.rs.next());
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        // colocando os devidos valores em suas colunas 
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelarota.setModel(modelo);
        tabelarota.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelarota.getColumnModel().getColumn(0).setResizable(true);
        tabelarota.getColumnModel().getColumn(1).setPreferredWidth(140);
        tabelarota.setSelectionBackground(Color.lightGray);
        tabelarota.setSelectionForeground(Color.BLUE);
        tabelarota.getColumnModel().getColumn(1).setResizable(true);
        tabelarota.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelarota.getColumnModel().getColumn(2).setResizable(false);
        tabelarota.getColumnModel().getColumn(3).setPreferredWidth(295);
        tabelarota.getColumnModel().getColumn(3).setResizable(false);
        
       
        
        tabelarota.getTableHeader().setReorderingAllowed(false);
        tabelarota.setAutoResizeMode(tabelarota.AUTO_RESIZE_OFF);
        tabelarota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    public void limpar(){
         txtid.setText("");
       txtvalor.setText("");
       txtdescricao.setText("");
      txtquantidade.setText("");

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtvalor = new javax.swing.JTextField();
        txtquantidade = new javax.swing.JTextField();
        txtdescricao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelarota = new javax.swing.JTable();
        btnnovo = new javax.swing.JButton();
        btnsalvar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Remover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numero Rota");

        jLabel2.setText("QuantDias");

        jLabel3.setText("Descrição Rota");

        jLabel4.setText("Valor Frete");

        txtid.setEnabled(false);

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

        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        btnsalvar.setText("Salvar");
        btnsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvarActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Remover.setText("Deletar");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
        txtid.setText("");
       txtvalor.setText("");
       txtdescricao.setText("");
      txtquantidade.setText("");
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvarActionPerformed
      mrota.setQuantdias(Integer.parseInt(txtquantidade.getText()));
       mrota.setValorRota(Float.parseFloat(txtvalor.getText()));
       mrota.setDescricaoRota(txtdescricao.getText());
       daorota.insereRota(mrota);
       limpar();
    }//GEN-LAST:event_btnsalvarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         mrota.setNumrota(Integer.parseInt(txtid.getText()));
        mrota.setQuantdias(Integer.parseInt(txtquantidade.getText()));
       mrota.setValorRota(Float.parseFloat(txtvalor.getText()));
       mrota.setDescricaoRota(txtdescricao.getText());
       daorota.atualizarRota(mrota);
       limpar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
         int x = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro ?","SAIDA",JOptionPane.YES_NO_OPTION);
        switch (x) {
            case 0:
                try {
                    if (txtid.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nada para remover !");
                    } else {
                        mrota.setNumrota(Integer.parseInt(txtid.getText()));
                        daorota.deletarRota(mrota);
                        
                        JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso !");
                        limpar();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Impossivel Alterar !! ");
                }
                break;

            case 1:
                break;
            case 2:
                break;
        }   
    }//GEN-LAST:event_RemoverActionPerformed

    private void tabelarotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelarotaMouseClicked
        int linha = tabelarota.getSelectedRow();
        int codigo = Integer.parseInt(tabelarota.getValueAt(linha, 0).toString());
        
    }//GEN-LAST:event_tabelarotaMouseClicked

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
    private javax.swing.JButton Remover;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnsalvar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelarota;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtquantidade;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}
