/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoVeiculo;
import Model.CentroDistribuicao;
import Model.Funcionario;
import Model.Veiculo;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class CadastrarVeiculos extends javax.swing.JFrame {

    //Conexões com o banco
    ConnBanco banco = new ConnBanco();
    ConnBanco conCidade = new ConnBanco();
    ConnBanco conFunc = new ConnBanco();
    ConnBanco conCentro = new ConnBanco();
    ConnBanco conVeic = new ConnBanco();

    DaoVeiculo DaoVeic = new DaoVeiculo();
    Veiculo veic = new Veiculo();
    Veiculo veic1 = new Veiculo();
    Funcionario func = new Funcionario();
    CentroDistribuicao centroDist = new CentroDistribuicao();

    /**
     * Creates new form CadastrarVeiculos
     *
     * @param veiculo
     */
    public void recebendo(Veiculo veiculo) {

        txtCodigo.setText(String.valueOf(veiculo.getId()));
        txtPlaca.setText(veiculo.getPlaca());
        txtNumChassi.setText(veiculo.getNumChassi());
        txtPesoTotal.setText(String.valueOf(veiculo.getCapacidade()));
        txtModelo.setText(veiculo.getModelo());
        //cbxCentroDist.setSelectedItem(veiculo.getIdCentroDist());
        cbxFunc.setSelectedItem(veiculo.getIdFunc());
        cbxCidade.setSelectedItem(veiculo.getCidade());
        String unidade = veiculo.getIdCentroDist();
        String unidade1 = String.valueOf(veiculo.getCidade());
        String unidade2 = String.valueOf(veiculo.getIdFunc());
       try {
           //Tratando Centro de distribuição
            String sql;
            String resultado = null;
            sql = "select * from centro_dist where cnpj =? ";

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            conCentro.conn = conCentro.getConection();
            conCentro.pstm = conCentro.conn.prepareStatement(sql);
            conCentro.pstm.setString(1, unidade);
            ResultSet rs = conCentro.pstm.executeQuery();
            if (rs.next()) {
                resultado = (rs.getString("cnpj") + " - " +rs.getString("nome_Fantasia"));
            }
            cbxCentroDist.setSelectedItem(resultado);
            
            //Tratando cidade
            
            String sql1;
            String resultado1 = null;
            sql1 = "select * from cidade where id =? ";

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            conCidade.conn = conCidade.getConection();
            conCidade.pstm = conCidade.conn.prepareStatement(sql1);
            conCidade.pstm.setString(1, unidade1);
            ResultSet rs1 = conCidade.pstm.executeQuery();
            if (rs1.next()) {
                resultado1 = (rs1.getString("id") + " - " +rs1.getString("nome"));
            }
            cbxCidade.setSelectedItem(resultado1);
            
            //Tratando funcionario
            
            String sql2;
            String resultado2 = null;
            sql2 = "select * from funcionario where id =? ";

            // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            conFunc.conn = conFunc.getConection();
            conFunc.pstm = conFunc.conn.prepareStatement(sql2);
            conFunc.pstm.setString(1, unidade2);
            ResultSet rs2 = conFunc.pstm.executeQuery();
            if (rs2.next()) {
                resultado2 = (rs2.getString("id") + " - " +rs2.getString("nome"));
            }
            cbxFunc.setSelectedItem(resultado2);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }


        /*String unidade = veiculo.getIdCentroDist();
         String unidade1 = String.valueOf(veiculo.getIdFunc());
         String unidade2 = String.valueOf(veiculo.getCidade());
         try {

         //Tratando caixa combinada de Centro de Distribuição
         String sql;
         String resultado = null;
         sql = "select * from centro_dist where cnpj =? ";

         conVeic.conn = conVeic.getConection();
         conVeic.pstm = conVeic.conn.prepareStatement(sql);
         conVeic.pstm.setString(1, unidade);
         ResultSet rs = conVeic.pstm.executeQuery();
         if (rs.next()) {
         resultado = rs.getString("cnpj") + " - " + rs.getString("nome_Fantasia");
         }
         cbxCentroDist.addItem(resultado);

         //Tratando caixa combinada de Funcionario
         String sql1;
         String resultado1 = null;
         sql = "select * from funcionario where id = ? ";

         conFunc.conn = conFunc.getConection();
         conFunc.pstm = conFunc.conn.prepareStatement(sql);
         conFunc.pstm.setString(1, unidade1);
         ResultSet rs1 = conFunc.pstm.executeQuery();
         if (rs1.next()) {
         resultado1 = rs1.getInt("id") + " - " + rs1.getString("nome");
         }
         cbxFunc.addItem(resultado1);

         //Tratando caixa combinada de cidade
         String sql2;
         String resultado2 = null;
         sql = "select * from cidade where id = ? ";

         conCidade.conn = conCidade.getConection();
         conCidade.pstm = conCidade.conn.prepareStatement(sql);
         conCidade.pstm.setString(1, unidade2);
         ResultSet rs2 = conCidade.pstm.executeQuery();
         if (rs2.next()) {
         resultado2 = rs2.getInt("id") + " - " + rs2.getString("nome");
         }
         cbxCidade.addItem(resultado2);

         } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, " Erro ao trazer chaves estrangeiras");
         }*/
        // cbxCentrodis.setSelectedIndex(String.valueOf(funcionario.getCnpjTransp()));
    }

    public CadastrarVeiculos() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        banco.getConection();
        conCidade.getConection();
        conCentro.getConection();
        conFunc.getConection();
        listarCidEst();
        listaFuncionario();
        listaCentroDist();
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Estado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        BarraMenu = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JButton();
        barraNavegacao = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPrimeiro = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAnterior = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnNovo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnImprimir = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        btnGravar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnAtualizar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnLimparr = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnExcluir = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnPesquisar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnProximo = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnUltimo = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        lblCodigo = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblRENVAN = new javax.swing.JLabel();
        lblPesoLiquido = new javax.swing.JLabel();
        lblPesoTotal = new javax.swing.JLabel();
        lblManutencao = new javax.swing.JLabel();
        lblRevisao = new javax.swing.JLabel();
        txtPesoTotal = new javax.swing.JFormattedTextField();
        txtPlaca = new javax.swing.JFormattedTextField();
        txtCodigo = new javax.swing.JTextField();
        cbxCidade = new javax.swing.JComboBox();
        cbxEstado = new javax.swing.JComboBox();
        cbxCentroDist = new javax.swing.JComboBox();
        cbxFunc = new javax.swing.JComboBox();
        txtModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNumChassi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setName("CadastrarVeiculos"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        BarraMenu.setBackground(new java.awt.Color(0, 28, 119));

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
        lblTitulo.setText("CADASTRAR VEICULOS");

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
                .addComponent(btnSair1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraMenuLayout.setVerticalGroup(
            BarraMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BarraMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnSair1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        barraNavegacao.setBackground(new java.awt.Color(0, 28, 119));

        jToolBar1.setBackground(new java.awt.Color(0, 28, 119));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.add(jSeparator1);

        btnPrimeiro.setBackground(new java.awt.Color(0, 28, 119));
        btnPrimeiro.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnPrimeiro.setForeground(new java.awt.Color(255, 255, 255));
        btnPrimeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Primeiro.png"))); // NOI18N
        btnPrimeiro.setText("PRIMEIRO");
        btnPrimeiro.setBorder(null);
        btnPrimeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrimeiro.setFocusable(false);
        btnPrimeiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrimeiro.setMaximumSize(new java.awt.Dimension(70, 70));
        btnPrimeiro.setMinimumSize(new java.awt.Dimension(70, 70));
        btnPrimeiro.setPreferredSize(new java.awt.Dimension(70, 70));
        btnPrimeiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrimeiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrimeiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrimeiroMouseExited(evt);
            }
        });
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPrimeiro);
        jToolBar1.add(jSeparator2);

        btnAnterior.setBackground(new java.awt.Color(0, 28, 119));
        btnAnterior.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Registro Anterior.png"))); // NOI18N
        btnAnterior.setText("ANTERIOR");
        btnAnterior.setBorder(null);
        btnAnterior.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnterior.setFocusable(false);
        btnAnterior.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAnterior.setMaximumSize(new java.awt.Dimension(70, 70));
        btnAnterior.setMinimumSize(new java.awt.Dimension(70, 70));
        btnAnterior.setPreferredSize(new java.awt.Dimension(70, 70));
        btnAnterior.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseExited(evt);
            }
        });
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAnterior);
        jToolBar1.add(jSeparator3);

        btnNovo.setBackground(new java.awt.Color(0, 28, 119));
        btnNovo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Novo.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.setBorder(null);
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.setFocusable(false);
        btnNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNovo.setMaximumSize(new java.awt.Dimension(70, 70));
        btnNovo.setMinimumSize(new java.awt.Dimension(70, 70));
        btnNovo.setPreferredSize(new java.awt.Dimension(70, 70));
        btnNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoMouseExited(evt);
            }
        });
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);
        jToolBar1.add(jSeparator4);

        btnImprimir.setBackground(new java.awt.Color(0, 28, 119));
        btnImprimir.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Imprimir.png"))); // NOI18N
        btnImprimir.setText("IMPRIMIR");
        btnImprimir.setToolTipText("FICHA DE PREENCHIMENTO");
        btnImprimir.setBorder(null);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setFocusable(false);
        btnImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimir.setMaximumSize(new java.awt.Dimension(70, 70));
        btnImprimir.setMinimumSize(new java.awt.Dimension(70, 70));
        btnImprimir.setPreferredSize(new java.awt.Dimension(70, 70));
        btnImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnImprimirMouseExited(evt);
            }
        });
        jToolBar1.add(btnImprimir);
        jToolBar1.add(jSeparator12);

        btnGravar.setBackground(new java.awt.Color(0, 28, 119));
        btnGravar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnGravar.setForeground(new java.awt.Color(255, 255, 255));
        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Gravar.png"))); // NOI18N
        btnGravar.setText("GRAVAR");
        btnGravar.setBorder(null);
        btnGravar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGravar.setFocusable(false);
        btnGravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGravar.setMaximumSize(new java.awt.Dimension(70, 70));
        btnGravar.setMinimumSize(new java.awt.Dimension(70, 70));
        btnGravar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnGravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGravarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGravarMouseExited(evt);
            }
        });
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGravar);
        jToolBar1.add(jSeparator5);

        btnAtualizar.setBackground(new java.awt.Color(0, 28, 119));
        btnAtualizar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Editar.png"))); // NOI18N
        btnAtualizar.setText("EDITAR");
        btnAtualizar.setBorder(null);
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setFocusable(false);
        btnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAtualizar.setMaximumSize(new java.awt.Dimension(70, 70));
        btnAtualizar.setMinimumSize(new java.awt.Dimension(70, 70));
        btnAtualizar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAtualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAtualizarMouseExited(evt);
            }
        });
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtualizar);
        jToolBar1.add(jSeparator6);

        btnLimparr.setBackground(new java.awt.Color(0, 28, 119));
        btnLimparr.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnLimparr.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Limpar.png"))); // NOI18N
        btnLimparr.setText("LIMPAR");
        btnLimparr.setBorder(null);
        btnLimparr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparr.setFocusable(false);
        btnLimparr.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimparr.setMaximumSize(new java.awt.Dimension(70, 70));
        btnLimparr.setMinimumSize(new java.awt.Dimension(70, 70));
        btnLimparr.setPreferredSize(new java.awt.Dimension(70, 70));
        btnLimparr.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimparr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparrMouseExited(evt);
            }
        });
        btnLimparr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparrActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimparr);
        jToolBar1.add(jSeparator7);

        btnExcluir.setBackground(new java.awt.Color(0, 28, 119));
        btnExcluir.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Excluir.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setBorder(null);
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.setFocusable(false);
        btnExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluir.setMaximumSize(new java.awt.Dimension(70, 70));
        btnExcluir.setMinimumSize(new java.awt.Dimension(70, 70));
        btnExcluir.setPreferredSize(new java.awt.Dimension(70, 70));
        btnExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirMouseExited(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluir);
        jToolBar1.add(jSeparator8);

        btnPesquisar.setBackground(new java.awt.Color(0, 28, 119));
        btnPesquisar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Pesquisa.png"))); // NOI18N
        btnPesquisar.setText("PESQUISA");
        btnPesquisar.setBorder(null);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.setFocusable(false);
        btnPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPesquisar.setMaximumSize(new java.awt.Dimension(70, 70));
        btnPesquisar.setMinimumSize(new java.awt.Dimension(70, 70));
        btnPesquisar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnPesquisar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseExited(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPesquisar);
        jToolBar1.add(jSeparator9);

        btnProximo.setBackground(new java.awt.Color(0, 28, 119));
        btnProximo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnProximo.setForeground(new java.awt.Color(255, 255, 255));
        btnProximo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Proximo Registro.png"))); // NOI18N
        btnProximo.setText("PROXIMO");
        btnProximo.setBorder(null);
        btnProximo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProximo.setFocusable(false);
        btnProximo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProximo.setMaximumSize(new java.awt.Dimension(70, 70));
        btnProximo.setMinimumSize(new java.awt.Dimension(70, 70));
        btnProximo.setPreferredSize(new java.awt.Dimension(70, 70));
        btnProximo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProximo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProximoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProximoMouseExited(evt);
            }
        });
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnProximo);
        jToolBar1.add(jSeparator15);

        btnUltimo.setBackground(new java.awt.Color(0, 28, 119));
        btnUltimo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnUltimo.setForeground(new java.awt.Color(255, 255, 255));
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Ultimo.png"))); // NOI18N
        btnUltimo.setText("ULTIMO");
        btnUltimo.setBorder(null);
        btnUltimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUltimo.setFocusable(false);
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUltimo.setMaximumSize(new java.awt.Dimension(70, 70));
        btnUltimo.setMinimumSize(new java.awt.Dimension(70, 70));
        btnUltimo.setPreferredSize(new java.awt.Dimension(70, 70));
        btnUltimo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUltimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUltimoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUltimoMouseExited(evt);
            }
        });
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUltimo);
        jToolBar1.add(jSeparator16);

        javax.swing.GroupLayout barraNavegacaoLayout = new javax.swing.GroupLayout(barraNavegacao);
        barraNavegacao.setLayout(barraNavegacaoLayout);
        barraNavegacaoLayout.setHorizontalGroup(
            barraNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraNavegacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        barraNavegacaoLayout.setVerticalGroup(
            barraNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraNavegacaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCodigo.setText("Codigo:");

        lblModelo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblModelo.setText("Modelo do Veiculo:");

        lblPlaca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPlaca.setText("Placa:");

        lblRENVAN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRENVAN.setText("Cidade:");

        lblPesoLiquido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPesoLiquido.setText("Estado:");

        lblPesoTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPesoTotal.setText("Peso Total:");

        lblManutencao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblManutencao.setText("Funcionario Responsável:");

        lblRevisao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRevisao.setText("Centro de Distribuição:");

        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma Cidade" }));
        cbxCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxCidadeFocusLost(evt);
            }
        });
        cbxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCidadeActionPerformed(evt);
            }
        });

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Estado" }));
        cbxEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxEstadoFocusLost(evt);
            }
        });

        cbxCentroDist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Centro de Distribuição" }));

        cbxFunc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Funcionario" }));
        cbxFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFuncActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Numero do Chassi:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblRevisao)
                    .addComponent(lblManutencao)
                    .addComponent(lblPesoTotal)
                    .addComponent(lblPlaca)
                    .addComponent(lblModelo)
                    .addComponent(lblCodigo)
                    .addComponent(lblPesoLiquido)
                    .addComponent(lblRENVAN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCentroDist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPesoTotal)
                    .addComponent(txtPlaca)
                    .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxFunc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtModelo)
                    .addComponent(txtNumChassi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesoLiquido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRENVAN)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesoTotal)
                    .addComponent(txtPesoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManutencao)
                    .addComponent(cbxFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRevisao)
                    .addComponent(cbxCentroDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(barraNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        this.setExtendedState(Menu.ICONIFIED);
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void btnPrimeiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrimeiroMouseEntered
        btnPrimeiro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnPrimeiroMouseEntered

    private void btnPrimeiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrimeiroMouseExited
        btnPrimeiro.setBorder(null);
    }//GEN-LAST:event_btnPrimeiroMouseExited

    private void btnAnteriorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseEntered
        btnAnterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnAnteriorMouseEntered

    private void btnAnteriorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseExited
        btnAnterior.setBorder(null);
    }//GEN-LAST:event_btnAnteriorMouseExited

    private void btnNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseEntered
        btnNovo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnNovoMouseEntered

    private void btnNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoMouseExited
        btnNovo.setBorder(null);
    }//GEN-LAST:event_btnNovoMouseExited

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseEntered
        btnImprimir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnImprimirMouseEntered

    private void btnImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImprimirMouseExited
        btnImprimir.setBorder(null);
    }//GEN-LAST:event_btnImprimirMouseExited

    private void btnGravarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGravarMouseEntered
        btnGravar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnGravarMouseEntered

    private void btnGravarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGravarMouseExited
        btnGravar.setBorder(null);
    }//GEN-LAST:event_btnGravarMouseExited

    private void btnAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseEntered
        btnAtualizar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnAtualizarMouseEntered

    private void btnAtualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAtualizarMouseExited
        btnAtualizar.setBorder(null);
    }//GEN-LAST:event_btnAtualizarMouseExited

    private void btnLimparrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparrMouseEntered
        btnLimparr.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnLimparrMouseEntered

    private void btnLimparrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparrMouseExited
        btnLimparr.setBorder(null);
    }//GEN-LAST:event_btnLimparrMouseExited

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
        btnExcluir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnExcluirMouseEntered

    private void btnExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseExited
        btnExcluir.setBorder(null);
    }//GEN-LAST:event_btnExcluirMouseExited

    private void btnPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseEntered
        btnPesquisar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnPesquisarMouseEntered

    private void btnPesquisarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseExited
        btnPesquisar.setBorder(null);
    }//GEN-LAST:event_btnPesquisarMouseExited

    private void btnProximoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProximoMouseEntered
        btnProximo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnProximoMouseEntered

    private void btnProximoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProximoMouseExited
        btnProximo.setBorder(null);
    }//GEN-LAST:event_btnProximoMouseExited

    private void btnUltimoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUltimoMouseEntered
        btnUltimo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnUltimoMouseEntered

    private void btnUltimoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUltimoMouseExited
        btnUltimo.setBorder(null);
    }//GEN-LAST:event_btnUltimoMouseExited

    private void cbxEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxEstadoFocusLost

    }//GEN-LAST:event_cbxEstadoFocusLost

    private void cbxFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFuncActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        boolean loop = true;
        try {
            //Validando placa.
            String placa = txtPlaca.getText();
            String sql = "SELECT * FROM veiculo WHERE placa = ?";
            conVeic.pstm = banco.conn.prepareStatement(sql);
            conVeic.pstm.setString(1, placa);
            ResultSet rs = conVeic.pstm.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Essa placa já foi cadastrada.\n"
                        + " Insira uma placa válida !");
            } else if (txtPlaca.getText().isEmpty() || txtPlaca.getText().length() != 7) {
                JOptionPane.showMessageDialog(this, "Insira uma placa válida !");
            } else {
                veic.setPlaca(txtPlaca.getText());

                //Tratando Numero de Chassi
                String nChassi = txtNumChassi.getText();
                String sqlC = "SELECT * FROM veiculo WHERE num_Chassi = ?";
                conVeic.pstm = banco.conn.prepareStatement(sqlC);
                conVeic.pstm.setString(1, nChassi);
                ResultSet rsC = conVeic.pstm.executeQuery();

                if (rsC.next()) {
                    JOptionPane.showMessageDialog(null, "Essa chassi já foi cadastrada.\n"
                            + " Insira um chassi válido !");
                } else if (txtNumChassi.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Insira um chassi válido !");
                } else {
                    veic.setNumChassi(txtNumChassi.getText());

                    //Tratando modelo
                    if (txtModelo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Insira um modelo de veículo válido !");
                    } else {
                        veic.setModelo(txtModelo.getText());

                        //Tratando capacidade
                        do {
                            veic.setCapacidade(Integer.parseInt(txtPesoTotal.getText()));
                            loop = false;
                        } while (loop);

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
                            if (rs1.next()) {
                                veic.setIdCentroDist(rs1.getString("cnpj"));
                            }

                            //Tratando caixa combinada de Funcionario
                            if (cbxFunc.getSelectedIndex() == 0) {
                                JOptionPane.showMessageDialog(null, "Selecione um Funcionario !");
                            } else {
                                String nomeFun = (String) cbxFunc.getSelectedItem();
                                String sql2 = "SELECT id FROM funcionario WHERE nome = ?;";
                                banco.conn = banco.getConection();
                                banco.pstm = banco.conn.prepareStatement(sql2);
                                banco.pstm.setString(1, nomeFun);
                                ResultSet rs2 = banco.pstm.executeQuery();
                                if (rs2.next()) {
                                    veic.setIdFunc(rs2.getInt("id"));
                                }

                                //Tratando caixa combinada de cidade
                                if (cbxCidade.getSelectedIndex() == 0) {
                                    JOptionPane.showMessageDialog(null, "Selecione uma cidade !");
                                } else {
                                    String nomeCid = (String) cbxCidade.getSelectedItem();
                                    String sql3 = "SELECT id FROM cidade WHERE nome = ?;";
                                    banco.conn = banco.getConection();
                                    banco.pstm = banco.conn.prepareStatement(sql3);
                                    banco.pstm.setString(1, nomeCid);
                                    ResultSet rs3 = banco.pstm.executeQuery();
                                    if (rs3.next()) {
                                        veic.setCidade(rs3.getInt("id"));
                                    }

                                    DaoVeic.insereVeiculo(veic);
                                    limpar();
                                }
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            //Exceção de entrada fora do esperado (nesse caso...)
            JOptionPane.showMessageDialog(null, "Insira um número de capacidade válido !");
        } catch (MySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Insira um Centro de distribuição !");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Funcionario " + e.getMessage() + veic.toString());
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Deseja excluir o registro ?");
        switch (x) {
            case 0:
                try {
                    if (txtCodigo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nada para remover !");
                    } else {
                        veic.setId(Integer.parseInt(txtCodigo.getText()));
                        DaoVeic.deletarVeiculo(veic);
                        //JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso !");
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

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        btnProximo.setEnabled(true);
        btnAnterior.setEnabled(false);

        try {
            String sql = "SELECT * FROM veiculo";
            banco.executaSQL(sql);
            banco.rs.first();
            txtCodigo.setText(banco.rs.getString("Id_Veiculo"));
            txtPlaca.setText(banco.rs.getString("placa"));
            txtNumChassi.setText(banco.rs.getString("num_Chassi"));
            txtPesoTotal.setText(banco.rs.getString("capacidade"));
            txtModelo.setText(banco.rs.getString("modelo"));

            //tratando a caixa de combinação de Centro de distribuição
            String sql1 = "SELECT * FROM centro_Dist WHERE cnpj = " + banco.rs.getString("fk_Id_Centro_Dist");
            conCentro.executaSQL(sql1);
            conCentro.rs.first();
            cbxCentroDist.setSelectedItem(conCentro.rs.getString("nome_Fantasia"));

            //tratando a caixa de combinação de Centro de funcionario
            String sql2 = "SELECT * FROM funcionario WHERE id = " + banco.rs.getString("fk_Id_func");
            conFunc.executaSQL(sql2);
            conFunc.rs.first();
            cbxFunc.setSelectedItem(conFunc.rs.getString("nome"));

            //Tratando a caixa de combinação de cidade
            String sql3 = "SELECT * FROM cidade WHERE id = " + banco.rs.getInt("fk_Id_Cidade");
            conCidade.executaSQL(sql3);
            conCidade.rs.first();
            cbxCidade.setSelectedItem(conCidade.rs.getString("nome"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar o primeiro registro !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        btnProximo.setEnabled(false);
        btnAnterior.setEnabled(true);

        try {
            String sql = "SELECT * FROM veiculo";
            banco.executaSQL(sql);
            banco.rs.last();
            txtCodigo.setText(banco.rs.getString("Id_Veiculo"));
            txtPlaca.setText(banco.rs.getString("placa"));
            txtNumChassi.setText(banco.rs.getString("num_Chassi"));
            txtPesoTotal.setText(banco.rs.getString("capacidade"));
            txtModelo.setText(banco.rs.getString("modelo"));

            //tratando a caixa de combinação de Centro de distribuição
            String sql1 = "SELECT * FROM centro_Dist WHERE cnpj = " + banco.rs.getString("fk_Id_Centro_Dist");
            conCentro.executaSQL(sql1);
            conCentro.rs.first();
            cbxCentroDist.setSelectedItem(conCentro.rs.getString("nome_Fantasia"));

            //tratando a caixa de combinação de Centro de funcionario
            String sql2 = "SELECT * FROM funcionario WHERE id = " + banco.rs.getString("fk_Id_func");
            conFunc.executaSQL(sql2);
            conFunc.rs.first();
            cbxFunc.setSelectedItem( conFunc.rs.getString("nome"));

            //Tratando a caixa de combinação de cidade
            String sql3 = "SELECT * FROM cidade WHERE id = " + banco.rs.getString("fk_Id_Cidade");
            conCidade.executaSQL(sql3);
            conCidade.rs.first();
            cbxCidade.setSelectedItem(conCidade.rs.getString("nome"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar o ultimo registro !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed

        try {
            if (banco.rs.isFirst()) {
                btnAnterior.setEnabled(false);
            } else {
                btnProximo.setEnabled(true);
                banco.rs.previous();
                txtCodigo.setText(banco.rs.getString("Id_Veiculo"));
                txtPlaca.setText(banco.rs.getString("placa"));
                txtNumChassi.setText(banco.rs.getString("num_Chassi"));
                txtPesoTotal.setText(banco.rs.getString("capacidade"));
                txtModelo.setText(banco.rs.getString("modelo"));

                //tratando a caixa de combinação de Centro de distribuição
                String sql1 = "SELECT * FROM centro_Dist WHERE cnpj = " + banco.rs.getString("fk_Id_Centro_Dist");
                conCentro.executaSQL(sql1);
                conCentro.rs.first();
                cbxCentroDist.setSelectedItem(conCentro.rs.getString("nome_Fantasia"));

                //tratando a caixa de combinação de Centro de funcionario
                String sql2 = "SELECT * FROM funcionario WHERE id = " + banco.rs.getString("fk_Id_func");
                conFunc.executaSQL(sql2);
                conFunc.rs.first();
                cbxFunc.setSelectedItem(conFunc.rs.getString("nome"));

                //Tratando a caixa de combinação de cidade
                String sql3 = "SELECT * FROM cidade WHERE id = " + banco.rs.getString("fk_Id_Cidade");
                conCidade.executaSQL(sql3);
                conCidade.rs.first();
                cbxCidade.setSelectedItem(conCidade.rs.getString("nome"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar o registro anterior !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed

        try {
            if (banco.rs.isLast()) {
                btnProximo.setEnabled(false);
            } else {
                btnAnterior.setEnabled(true);
                banco.rs.next();
                txtCodigo.setText(banco.rs.getString("Id_Veiculo"));
                txtPlaca.setText(banco.rs.getString("placa"));
                txtNumChassi.setText(banco.rs.getString("num_Chassi"));
                txtPesoTotal.setText(banco.rs.getString("capacidade"));
                txtModelo.setText(banco.rs.getString("modelo"));

                //tratando a caixa de combinação de Centro de distribuição
                String sql1 = "SELECT * FROM centro_Dist WHERE cnpj = " + banco.rs.getString("fk_Id_Centro_Dist");
                conCentro.executaSQL(sql1);
                conCentro.rs.first();
                cbxCentroDist.setSelectedItem(conCentro.rs.getString("nome_Fantasia"));

                //tratando a caixa de combinação  de funcionario
                String sql2 = "SELECT * FROM funcionario WHERE id = " + banco.rs.getString("fk_Id_func");
                conFunc.executaSQL(sql2);
                conFunc.rs.first();
                cbxFunc.setSelectedItem(conFunc.rs.getString("nome"));

                //Tratando a caixa de combinação de cidade
                String sql3 = "SELECT * FROM cidade WHERE id = " + banco.rs.getString("fk_Id_Cidade");
                conCidade.executaSQL(sql3);
                conCidade.rs.first();
                cbxCidade.setSelectedItem(conCidade.rs.getString("nome"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar o próximo registro !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void cbxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCidadeActionPerformed

    }//GEN-LAST:event_cbxCidadeActionPerformed

    private void cbxCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxCidadeFocusLost

    }//GEN-LAST:event_cbxCidadeFocusLost

    private void btnLimparrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparrActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparrActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        conVeic.conn = conVeic.getConection();
        int x = JOptionPane.showConfirmDialog(this, "Deseja alterar o registro ?");
        switch (x) {
            case 0:
                try {
                    if (txtCodigo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nada para atualizar !");
                    } else {

                        veic.setId(Integer.parseInt(txtCodigo.getText()));
                        veic.setPlaca(txtPlaca.getText());
                        veic.setNumChassi(txtNumChassi.getText());
                        veic.setCapacidade(Integer.parseInt(txtPesoTotal.getText()));
                        veic.setModelo(txtModelo.getText());

                        //Tratando caixa de combinação de Centro de distribuição
                        String dados2[] = String.valueOf(cbxCentroDist.getSelectedItem()).split(" - ");
                        veic.setIdCentroDist(dados2[0]);

                        //Tratando caixa de combinação de funcionario
                        String dados[] = String.valueOf(cbxFunc.getSelectedItem()).split(" - ");
                        veic.setIdFunc(Integer.parseInt(dados[0]));

                        //Tratando a caixa de combinação de cidade.
                        String dados3[] = String.valueOf(cbxCidade.getSelectedItem()).split(" - ");
                        veic.setCidade(Integer.parseInt(dados3[0]));

                        DaoVeic.atualizarVeiculo(veic);

                        JOptionPane.showMessageDialog(null, "Registro " + txtCodigo.getText() + " alterado com sucesso !!");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao alterar registro !!");
                    e.printStackTrace();
                }
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.dispose();
        new PesquisarVeiculo().setVisible(true);
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarrActionPerformed(java.awt.event.ActionEvent evt) {
        //Depreciado
    }

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {
        //Depreciado
    }

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
            java.util.logging.Logger.getLogger(CadastrarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
    private javax.swing.ButtonGroup Estado;
    private javax.swing.JPanel barraNavegacao;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimparr;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cbxCentroDist;
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox cbxFunc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblManutencao;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPesoLiquido;
    private javax.swing.JLabel lblPesoTotal;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRENVAN;
    private javax.swing.JLabel lblRevisao;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumChassi;
    private javax.swing.JFormattedTextField txtPesoTotal;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables

    /**
     * Método lista cidades e estado no comboBox
     */
    public void listarCidEst() {
        String sql1 = ("select * from cidade;");
        String sql = ("select * from estado;");

        try {
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql);
            ResultSet rscidade = banco.executaSQLRetorno(sql1);
            ResultSet rsestado = banco.executaSQLRetorno(sql);
            while (rsestado.next()) {
                String a = rsestado.getString(1);
                cbxEstado.removeAllItems();
                //cbxEstado.addItem(rsestado.getString(1));
                cbxEstado.addItem( rsestado.getString("nome"));
            }
            while (rscidade.next()) {
                //cbxCidade.addItem(rscidade.getString(1));
                cbxCidade.addItem(rscidade.getString("nome"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void listaFuncionario() {
        String sql = "SELECT * FROM funcionario";
        try {
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql);
            ResultSet rs = banco.executaSQLRetorno(sql);
            while (rs.next()) {
                cbxFunc.addItem(rs.getString("nome"));
                //cbxFunc.addItem( rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listaCentroDist() {
        String sql = "SELECT * FROM centro_dist";
        try {
            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql);
            ResultSet rs = banco.executaSQLRetorno(sql);
            while (rs.next()) {
                cbxCentroDist.addItem(rs.getString("nome_Fantasia"));
                //cbxCentroDist.addItem( rs.getString("cnpj"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void limpar() {
        txtCodigo.setText("");
        txtPlaca.setText("");
        txtNumChassi.setText("");
        txtPesoTotal.setText("");
        txtModelo.setText("");
        cbxCentroDist.setSelectedIndex(0);
        cbxCidade.setSelectedIndex(0);
        cbxEstado.setSelectedIndex(0);
        cbxFunc.setSelectedIndex(0);
    }

}
