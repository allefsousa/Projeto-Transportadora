/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoFuncionario;
import Funcionalidades.ModeloTabela;
import Model.Filial;
import Model.Funcionario;
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.xpath.internal.functions.FuncBoolean;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    ConnBanco conn = new ConnBanco();
    Dao.DaoFuncionario daofunc = new DaoFuncionario();
    Filial sessao = Filial.getInstance();
   
    
    public PesquisaFuncionario() {
        // sessao para receber a cidade de Login
         
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        //connBanco.getConection();
        //conn.getConection();
        preencherTabela("SELECT * FROM funcionario where fk_Cnpj_Centro_Dist = ?;");
      
      
    }

    public final void preencherTabela(String sql) {
      
           
            
                
                ResultSet res = null ;
                int cidade;
                Long unidade;
                String cid = null,uni = "",sql1,result;
                ArrayList dados = new ArrayList();
                String[] colunas = new String[]{"N° Regist", "Nome Completo", "Cpf", "Rg", "Data Nasc", "Cargo", "fone", "Cep", "Endereço", "Numero", "Bairro", "Complemento", "Cidade", "Estado", "Data Regist", "Unidade"};
                // formatando a data que sera mostrada na tabela
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                 try {
                String sql2 = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
                conn.conn = conn.getConection();
                conn.pstm = conn.conn.prepareStatement(sql2);
                result = sessao.fili;
                conn.pstm.setString(1, result);
                ResultSet rs1 = conn.pstm.executeQuery();
                
                if (rs1.next()) {
                 uni=(rs1.getString("cnpj"));
                }
               
                
                connBanco.conn = connBanco.getConection();
                connBanco.pstm = connBanco.conn.prepareStatement(sql);
                connBanco.pstm.setString(1, uni);
                     res = connBanco.pstm.executeQuery();
                } catch (SQLException ex) {
             
            }
                // pegando o primeiro registro
                try {
                    
                    res.first();
                    
                    // pegando os valores e formatando para preecher a tabela
                    do {
                        cidade = res.getInt("fk_Cidade_Func");
                        sql = "SELECT nome FROM cidade where id = ?";
                        cid=daoFunc.chaveEstrangeira(sql, cidade);
                        unidade = res.getLong("fk_Cnpj_Centro_Dist");
                        sql1 = "SELECT nome_Fantasia from centro_dist where cnpj =?";
                        uni = daoFunc.chaveEstrangeiraLong(sql1, unidade);
                        
                        
                        dados.add(new Object[]{res.getInt("id"), res.getString("nome"), res.getString("cpf"), res.getInt("rg"),
                            formatter.format(res.getDate("dataNasc")), res.getString("cargo"), res.getString("fone"), res.getInt("cep"),
                            res.getString("rua"), res.getInt("numero"), res.getString("bairro"), res.getString("complemento"),
                            cid, res.getString("estado"), formatter.format(res.getDate("dataRegistro")), uni});
                    } while (res.next());
                    
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
               
                tabelaFuncionario.setAutoResizeMode(tabelaFuncionario.AUTO_RESIZE_OFF);
                tabelaFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                
                
                
            
            
    

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionario = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisacpf = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        txtPesquisaid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BarraMenu3 = new javax.swing.JPanel();
        btnSair3 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("CPF:");

        btnPesquisar.setBackground(new java.awt.Color(0, 28, 119));
        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisa.png"))); // NOI18N
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.setFocusPainted(false);
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("CODIGO:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("NOME:");

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
        lblTitulo.setText("PESQUISAR FUNCIONARIOS");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaid, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisacpf, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtPesquisaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtPesquisacpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
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
    private javax.swing.JPanel BarraMenu3;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair3;
    private javax.swing.JButton btnSair4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tabelaFuncionario;
    private javax.swing.JTextField txtPesquisaNome;
    private javax.swing.JTextField txtPesquisacpf;
    private javax.swing.JTextField txtPesquisaid;
    // End of variables declaration//GEN-END:variables
}
