/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoFuncionario;
import Funcionalidades.ModeloTabela;
import Model.Funcionario;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author allef
 */
public class PesquisaFuncionario extends javax.swing.JFrame {

    CadastrarFuncionario EnviandoObjeto;

    /**
     * Creates new form PesquisaFuncionario
     */
    Model.Funcionario func = new Funcionario();
    DaoFuncionario daoFunc = new DaoFuncionario();
    

    ConnBanco connBanco = new ConnBanco();
    Dao.DaoFuncionario daofunc = new DaoFuncionario();

    public PesquisaFuncionario() {
        initComponents();
        connBanco.getConection();
        preencherTabela("SELECT * FROM transportadoraf.funcionario order by id;");
    }

    public void preencherTabela(String SQL) {
        int cidade;
                Long unidade;
        String cid = null,uni,sql1,sql;
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"N° Regist", "Nome Completo", "Cpf", "Rg", "Data Nasc", "Cargo", "fone", "Cep", "Endereço", "Numero", "Bairro", "Complemento", "Cidade", "Estado", "Data Regist", "Unidade"};
        // formatando a data que sera mostrada na tabela 
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        connBanco.executaSQL(SQL);
        // pegando o primeiro registro 
        try {
            connBanco.rs.first();

            // pegando os valores e formatando para preecher a tabela  
            do {
                 cidade = connBanco.rs.getInt("fk_Cidade_Func");
                 sql = "SELECT nome FROM cidade where id = ?";
                cid=daoFunc.chaveEstrangeira(sql, cidade);
                unidade = connBanco.rs.getLong("fk_Cnpj_Centro_Dist");
                sql1 = "SELECT nome_Fantasia from centro_dist where cnpj =?";
                uni = daoFunc.chaveEstrangeiraLong(sql1, unidade);
                
                
                dados.add(new Object[]{connBanco.rs.getInt("id"), connBanco.rs.getString("nome"), connBanco.rs.getString("cpf"), connBanco.rs.getInt("rg"),
                    formatter.format(connBanco.rs.getDate("dataNasc")), connBanco.rs.getString("cargo"), connBanco.rs.getString("fone"), connBanco.rs.getInt("cep"),
                    connBanco.rs.getString("rua"), connBanco.rs.getInt("numero"), connBanco.rs.getString("bairro"), connBanco.rs.getString("complemento"), 
                   cid, connBanco.rs.getString("estado"), formatter.format(connBanco.rs.getDate("dataRegistro")), uni});
            } while (connBanco.rs.next());
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        // colocando os devidos valores em suas colunas 
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tabelaFuncionario.setModel(modelo);
        tabelaFuncionario.getColumnModel().getColumn(0).setPreferredWidth(80);
        tabelaFuncionario.getColumnModel().getColumn(0).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(1).setPreferredWidth(160);
        tabelaFuncionario.setSelectionBackground(Color.lightGray);
        tabelaFuncionario.setSelectionForeground(Color.BLUE);

        tabelaFuncionario.getColumnModel().getColumn(1).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(2).setResizable(false);
        tabelaFuncionario.getColumnModel().getColumn(3).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(3).setResizable(false);
        tabelaFuncionario.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(4).setResizable(false);
        tabelaFuncionario.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(5).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(6).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(6).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(7).setPreferredWidth(100);
        tabelaFuncionario.getColumnModel().getColumn(7).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(8).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(8).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(9).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(9).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(10).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(10).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(11).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(11).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(12).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(12).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(13).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(13).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(14).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(14).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(15).setPreferredWidth(120);
        tabelaFuncionario.getColumnModel().getColumn(15).setResizable(true);
       /* tabelaFuncionario.getColumnModel().getColumn(16).setPreferredWidth(100);
        tabelaFuncionario.getColumnModel().getColumn(16).setResizable(true);
        tabelaFuncionario.getColumnModel().getColumn(17).setPreferredWidth(100);
        tabelaFuncionario.getColumnModel().getColumn(17).setResizable(true);
        tabelaFuncionario.getTableHeader().setReorderingAllowed(false);*/
        tabelaFuncionario.setAutoResizeMode(tabelaFuncionario.AUTO_RESIZE_OFF);
        tabelaFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisaid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisacpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionario);

        jLabel1.setText("Consulta Funcionario");

        jLabel2.setText("ID");

        jLabel3.setText("Nome");

        jLabel4.setText("CPF");

        btnPesquisar.setText("Pesquisar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPesquisacpf, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(txtPesquisaid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisacpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionarioMouseClicked

        /**
         *
         */
        int linha = tabelaFuncionario.getSelectedRow();
        int codigo = Integer.parseInt(tabelaFuncionario.getValueAt(linha, 0).toString());
        Funcionario recebefun;
        recebefun = daofunc.getFuncionario(codigo);

        if (EnviandoObjeto == null) {
            EnviandoObjeto = new CadastrarFuncionario();
            EnviandoObjeto.setVisible(true);
            EnviandoObjeto.recebendo(recebefun);
            this.setVisible(false);
        } else {
            EnviandoObjeto.setVisible(true);
            EnviandoObjeto.setState(CadastrarFuncionario.NORMAL);
            EnviandoObjeto.recebendo(func);
            this.setVisible(false);
        }

    }//GEN-LAST:event_tabelaFuncionarioMouseClicked

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
            java.util.logging.Logger.getLogger(PesquisaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtPesquisacpf;
    private javax.swing.JTextField txtPesquisaid;
    // End of variables declaration//GEN-END:variables
}
