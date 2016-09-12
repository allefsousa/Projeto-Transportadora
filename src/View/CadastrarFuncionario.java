/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Dao.ConnBanco;
import Dao.DaoFuncionario;
import Funcionalidades.AbrirNavegador;
import Funcionalidades.Atualizahora;
import Model.Funcionario;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class CadastrarFuncionario extends javax.swing.JFrame {
Dao.DaoFuncionario DaoFunc = new DaoFuncionario();
ConnBanco viewFunc = new ConnBanco();
    /**
     * Metodo responsavel por receber os dados da tela de pesquisa os valores
     * foram passados por um objeto do tipo funcionario
     *
     * @author Allef
     * @param b
     * @data 14/08/2016
     * @param funcionario
     */
    
   /* public void recebendoFilial(String a){
        cbxCentrodis.addItem(a);
        cbxCentrodis.setSelectedIndex(1);
        cbxCentrodis.setEditable(false);
    }*/
    public void recebendo1(String b[]) {
        cbxcidade.addItem(b);
    }

    public void recebendo(Funcionario funcionario) {

        txtCodigo.setText(String.valueOf(funcionario.getNumMatricula()));
        txtNomeCompleto.setText(funcionario.getNome());
        txtCPF.setText(funcionario.getCpf());
        txtRG.setText(funcionario.getRg());
        txtNascimento.setDate(funcionario.getDataNasc());
        cbxCargo.setSelectedItem(funcionario.getFuncao());
        txtcep.setText(String.valueOf(funcionario.getCep()));
        txtEndereco.setText(funcionario.getEndereco());
        txtNumero.setText(String.valueOf(funcionario.getNumero()));
        txtBairro.setText(funcionario.getBairro());
        txtComplemento.setText(funcionario.getComplemento());
          txtTelefone.setText(String.valueOf(funcionario.getTelCelular()));
      
        cbxcidade.setSelectedIndex(funcionario.getCidadeFunciCentro());
        cbxEstado.setSelectedItem(funcionario.getEstado());
        dataAdmisao.setDate(funcionario.getDataRegistro());
        String unidade = funcionario.getCnpjTransp();
       
        try {
             String sql;
             String resultado = null;
             sql = "select nome_Fantasia from centro_dist where cnpj =? ";
            
            
           // String sql = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
            viewFunc.conn = viewFunc.getConection();
            viewFunc.pstm = viewFunc.conn.prepareStatement(sql);
            viewFunc.pstm.setString(1, unidade);
            ResultSet rs = viewFunc.pstm.executeQuery();
            if (rs.next()) {
                resultado=(rs.getString(1));
            }
             cbxCentrodis.setSelectedItem(resultado);
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao trazer chaves estrangeiras");
        }
        
       
       // cbxCentrodis.setSelectedIndex(String.valueOf(funcionario.getCnpjTransp()));
    }

    /**
     * Creates new form CadastrarFuncionario
     */
    ConnBanco banco = new ConnBanco();
    // Instanciando Objeto do tipo da tela para Persistir os dados.
    
    Dao.ConnBanco conn = new ConnBanco();

    Funcionario func = new Funcionario();

    public CadastrarFuncionario() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        btnAnterior.setEnabled(false);
        btnProximo.setEnabled(false);

        /**
         * @Author Allef preenche os combos de cidade e estado quando a tela é
         * iniciada
         */
        String sql1 = ("select nome from cidade;");
        String sql = ("select nome from estado;");
        String sql3 =("select nome_Fantasia from centro_dist; ");

        try {

            banco.conn = banco.getConection();
            banco.pstm = banco.conn.prepareStatement(sql);
            ResultSet rscidade = banco.executaSQLRetorno(sql1);
            ResultSet rsestado = banco.executaSQLRetorno(sql);
            ResultSet rsfilial = banco.executaSQLRetorno(sql3);
            while (rsestado.next()) {
                String a = rsestado.getString(1);
                cbxEstado.addItem(rsestado.getString(1));
            }
            while (rscidade.next()) {
                cbxcidade.addItem(rscidade.getString(1));
            }
            while(rsfilial.next()){
                cbxCentrodis.addItem(rsfilial.getString(1));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "" + ex);
        }
    }

    /**
     * metodo que vai receber os dados do outro jFrame no caso os dados que
     * forem clicados na tabela de pesquisa
     *
     * @param funcionario
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        BarraMenu = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnSair1 = new javax.swing.JButton();
        lblNomeCompleto = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblRG = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        txtNomeCompleto = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        barraNavegacao = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPrimeiro = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAnterior = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnNovo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnGravar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnLimpar = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnExcluir = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnPesquisar = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        btnProximo = new javax.swing.JButton();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        btnUltimo = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        lblCidade = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox();
        lblCodigo = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        cbxCargo = new javax.swing.JComboBox();
        lblBairro1 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        lblNascimento1 = new javax.swing.JLabel();
        txtcep = new javax.swing.JTextField();
        txtRG = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        cbxcidade = new javax.swing.JComboBox();
        txtCodigo = new javax.swing.JTextField();
        lblCargo1 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        cbxCentrodis = new javax.swing.JComboBox<>();
        lblSenha1 = new javax.swing.JLabel();
        txtNascimento = new com.toedter.calendar.JDateChooser();
        dataAdmisao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        lblTitulo.setText("CADASTRAR FUNCIONARIO");

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

        lblNomeCompleto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNomeCompleto.setText("Nome Completo:");

        lblEndereco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumero.setText("Nº.:");

        lblBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBairro.setText("Bairro:");

        lblCEP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCEP.setText("CEP:");

        lblCPF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCPF.setText("CPF:");

        lblRG.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRG.setText("RG:");

        lblNascimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNascimento.setText("Data de Nascimento:");

        txtNomeCompleto.setPreferredSize(new java.awt.Dimension(250, 20));

        txtEndereco.setPreferredSize(new java.awt.Dimension(250, 20));

        txtBairro.setPreferredSize(new java.awt.Dimension(250, 20));

        txtNumero.setPreferredSize(new java.awt.Dimension(60, 20));

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

        btnGravar.setBackground(new java.awt.Color(0, 28, 119));
        btnGravar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnGravar.setForeground(new java.awt.Color(255, 255, 255));
        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Gravar.png"))); // NOI18N
        btnGravar.setText("GRAVAR");
        btnGravar.setToolTipText("GRAVAR REGISTRO");
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

        btnEditar.setBackground(new java.awt.Color(0, 28, 119));
        btnEditar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(null);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusable(false);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setMaximumSize(new java.awt.Dimension(70, 70));
        btnEditar.setMinimumSize(new java.awt.Dimension(70, 70));
        btnEditar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMouseExited(evt);
            }
        });
        jToolBar1.add(btnEditar);
        jToolBar1.add(jSeparator6);

        btnLimpar.setBackground(new java.awt.Color(0, 28, 119));
        btnLimpar.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Limpar.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.setBorder(null);
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.setFocusable(false);
        btnLimpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpar.setMaximumSize(new java.awt.Dimension(70, 70));
        btnLimpar.setMinimumSize(new java.awt.Dimension(70, 70));
        btnLimpar.setPreferredSize(new java.awt.Dimension(70, 70));
        btnLimpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparMouseExited(evt);
            }
        });
        jToolBar1.add(btnLimpar);
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
                .addGap(101, 101, 101)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        barraNavegacaoLayout.setVerticalGroup(
            barraNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraNavegacaoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCidade.setText("Cidade:");

        lblEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEstado.setText("Estado:");

        cbxEstado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione Um Estado ..." }));
        cbxEstado.setBorder(null);
        cbxEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxEstadoFocusLost(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCodigo.setText("NumMatricula:");

        lblCargo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCargo.setText("Cargo:");

        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um cargo ...", "Secretaria", "Ajudante", "Motorista", "Gerente" }));
        cbxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCargoActionPerformed(evt);
            }
        });

        lblBairro1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBairro1.setText("Complemento:");

        txtComplemento.setPreferredSize(new java.awt.Dimension(250, 20));

        lblNascimento1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNascimento1.setText("Data Admissão:");

        txtRG.setPreferredSize(new java.awt.Dimension(60, 20));

        txtCPF.setPreferredSize(new java.awt.Dimension(60, 20));

        cbxcidade.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        cbxcidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione Uma Cidade ...." }));
        cbxcidade.setBorder(null);
        cbxcidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbxcidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxcidadeFocusLost(evt);
            }
        });

        txtCodigo.setPreferredSize(new java.awt.Dimension(60, 20));

        lblCargo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCargo1.setText("Telefone:");

        cbxCentrodis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        lblSenha1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSenha1.setText("Centro De Distribuição:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(barraNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(111, 111, 111)
                                                        .addComponent(lblCPF))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(118, 118, 118)
                                                        .addComponent(lblRG))
                                                    .addComponent(lblNascimento))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                                    .addComponent(txtRG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(lblBairro)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblEstado)
                                                    .addComponent(lblCEP))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(401, 401, 401))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblCargo1)
                                                    .addComponent(lblCargo))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(lblCidade)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbxcidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(385, 385, 385))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(lblCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBairro1)
                                .addGap(10, 10, 10)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSenha1)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxCentrodis, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(lblNascimento1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dataAdmisao, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNomeCompleto)
                                .addGap(10, 10, 10)
                                .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblEndereco)
                                .addGap(10, 10, 10)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90)
                        .addComponent(lblNumero)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(lblBairro1))
                        .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblNumero))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblNomeCompleto))
                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblEndereco)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblBairro))
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEP)
                    .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(cbxcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCargo))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo1)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRG)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(lblNascimento))
                    .addComponent(txtNascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNascimento1)
                    .addComponent(dataAdmisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCentrodis)
                    .addComponent(lblSenha1))
                .addGap(103, 103, 103)
                .addComponent(barraNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        /**
         * @autor Allef data 14/08/2016
         */

        txtNascimento.setDate(null);
        dataAdmisao.setDate(null);
        txtComplemento.setText("");
        txtCodigo.setText("");
        txtNomeCompleto.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtcep.setText("");
        txtNumero.setText("");
        txtCPF.setText("");
        txtRG.setText("");
        cbxEstado.setSelectedIndex(0);
        cbxCargo.setSelectedIndex(0);
        cbxcidade.setSelectedIndex(0);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnGravarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGravarMouseEntered
        btnGravar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnGravarMouseEntered

    private void btnGravarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGravarMouseExited
        btnGravar.setBorder(null);
    }//GEN-LAST:event_btnGravarMouseExited

    private void btnEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseEntered
        btnEditar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnEditarMouseEntered

    private void btnEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseExited
        btnEditar.setBorder(null);
    }//GEN-LAST:event_btnEditarMouseExited

    private void btnLimparMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseEntered
        btnLimpar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_btnLimparMouseEntered

    private void btnLimparMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparMouseExited
        btnLimpar.setBorder(null);
    }//GEN-LAST:event_btnLimparMouseExited

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

   
    private void cbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCargoActionPerformed
        
    }//GEN-LAST:event_cbxCargoActionPerformed

    /**
     * @author Allef data 13/08/2016
     * @param evt
     */
    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        if (txtCPF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Impossivel Inserir Registro, existem campos em Branco.",
                    "Alerta ! ", JOptionPane.ERROR_MESSAGE);
        } else {
            /**
             * Bloco try catch so foi adicionado por causa da funcao DATAFORMAT
             * para converter a data
             */
            try {
                func.setCpf(txtCPF.getText());
                func.setNome(txtNomeCompleto.getText());
                func.setRg((txtRG.getText()));
                // formatando a data da forma que ela deve ser digitada
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                func.setDataNasc((txtNascimento.getDate()));
                func.setFuncao((String) cbxCargo.getSelectedItem());
                func.setCep(Integer.parseInt(txtcep.getText()));
                func.setEndereco(txtEndereco.getText());
                func.setNumero(Integer.parseInt(txtNumero.getText()));
                func.setBairro(txtBairro.getText());
                func.setComplemento(txtComplemento.getText());
                
                String cidade = (String) cbxcidade.getSelectedItem();
                String sql = "SELECT id FROM cidade WHERE nome = ?;";
                banco.conn = banco.getConection();
                banco.pstm = banco.conn.prepareStatement(sql);
                banco.pstm.setString(1, cidade);
                ResultSet rs = banco.pstm.executeQuery();
                if (rs.next()) {
                    func.setCidadeFunciCentro(rs.getInt("id"));
                }
              
                func.setEstado((String) cbxEstado.getSelectedItem());
                func.setTelCelular(Long.parseLong(txtTelefone.getText()));
                String nomeFantasia = (String) cbxCentrodis.getSelectedItem();
               
                /**
                 * select utilizado para fazer a busca do cnpj com base no nome
                 * fantasia escolhido da filial
                 */
                String sql1 = "SELECT cnpj FROM centro_dist WHERE nome_Fantasia = ?;";
                banco.conn = banco.getConection();
                banco.pstm = banco.conn.prepareStatement(sql1);
                banco.pstm.setString(1, nomeFantasia);
                ResultSet rs1 = banco.pstm.executeQuery();
                if (rs1.next()) {
                    func.setCnpjTransp(rs1.getString("cnpj"));
                }
             
                DateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                func.setDataRegistro((dataAdmisao.getDate()));

                /*
                 func.setTelFixo(Integer.parseInt(txtTelefone.getText()));
                 func.setTelCelular(Integer.parseInt(txtCelular.getText()));
                 */
                JOptionPane.showMessageDialog(null, func.toString());
                DaoFunc.insereFuncionario(func);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Inserir Funcionario " + ex.getMessage() + func.toString());

            }

        }
    }//GEN-LAST:event_btnGravarActionPerformed
    /**
     * Removendo todos os itens do combobox de cidades logo,apos o estado ser
     * selecionado.
     *
     * @param evt
     */
    private void cbxEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxEstadoFocusLost
        

    }//GEN-LAST:event_cbxEstadoFocusLost
    /**
     * Método exclui o funcionario da base de dados referenciando - se pelo
     * Código do mesmo.
     *
     * @param evt
     */
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nada para remover !");
            } else {
                func.setNumMatricula(Integer.parseInt(txtCodigo.getText()));
                DaoFunc.deletarFunc(func);
                //JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossivel Alterar !! ");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        this.dispose();
        new PesquisaFuncionario().setVisible(true);

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbxcidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxcidadeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxcidadeFocusLost
    /**
     * Método recupera os dados de cadastro de funcionarios do primeiro registro
     * da base de dados.
     *
     * @param evt
     */
    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        btnProximo.setEnabled(true);
        btnAnterior.setEnabled(false);
        cbxcidade.removeAllItems();
        cbxEstado.removeAllItems();
        cbxCargo.removeAllItems();
        try {
            String sql = "SELECT * FROM funcionario";
            banco.executaSQL(sql);
            banco.rs.first();
            txtCodigo.setText(banco.rs.getString("id"));
            txtNomeCompleto.setText(banco.rs.getString("nome"));
            txtEndereco.setText(banco.rs.getString("rua"));
            txtBairro.setText(banco.rs.getString("bairro"));
            txtNumero.setText(String.valueOf(banco.rs.getString("numero")));
            txtcep.setText(banco.rs.getString("cep"));
            cbxEstado.addItem(banco.rs.getString("estado"));
            cbxcidade.addItem(banco.rs.getString("cidade"));
            cbxCargo.addItem(banco.rs.getString("cargo"));
            txtCPF.setText(banco.rs.getString("cpf"));
            txtRG.setText(banco.rs.getString("rg"));
            txtNascimento.setDate(banco.rs.getDate("DataNAsc"));
            dataAdmisao.setDate(banco.rs.getDate("dataRegistro"));
            txtComplemento.setText(banco.rs.getString("complemento"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar dados !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    /**
     * Método recupera os dados de cadastro de funcionário presente no último
     * registro da base de dados.
     *
     * @param evt
     */
    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        btnProximo.setEnabled(false);
        btnAnterior.setEnabled(true);
        cbxcidade.removeAllItems();
        cbxEstado.removeAllItems();
        cbxCargo.removeAllItems();

        try {
            String sql = "SELECT * FROM funcionario";
            banco.executaSQL(sql);
            banco.rs.last();
            txtCodigo.setText(banco.rs.getString("id"));
            txtNomeCompleto.setText(banco.rs.getString("nome"));
            txtEndereco.setText(banco.rs.getString("rua"));
            txtBairro.setText(banco.rs.getString("bairro"));
            txtNumero.setText(String.valueOf(banco.rs.getString("numero")));
            txtcep.setText(banco.rs.getString("cep"));
            cbxEstado.addItem(banco.rs.getString("estado"));
            cbxcidade.addItem(banco.rs.getString("cidade"));
            cbxCargo.addItem(banco.rs.getString("cargo"));
            txtCPF.setText(banco.rs.getString("cpf"));
            txtRG.setText(banco.rs.getString("rg"));
            txtNascimento.setDate(banco.rs.getDate("DataNAsc"));
            dataAdmisao.setDate(banco.rs.getDate("dataRegistro"));
            txtComplemento.setText(banco.rs.getString("complemento"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar dados !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    /**
     * Método recupera os dados de um registro anterior em relação a posição
     * atual, exceto se o mesmo estiver na primeira posição.
     *
     * @param evt
     */
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        btnProximo.setEnabled(true);
        cbxcidade.removeAllItems();
        cbxEstado.removeAllItems();
        cbxCargo.removeAllItems();

        try {
            if (banco.rs.isFirst()) {
                btnAnterior.setEnabled(false);
            } else {
                banco.rs.previous();
                txtCodigo.setText(banco.rs.getString("id"));
                txtNomeCompleto.setText(banco.rs.getString("nome"));
                txtEndereco.setText(banco.rs.getString("rua"));
                txtBairro.setText(banco.rs.getString("bairro"));
                txtNumero.setText(String.valueOf(banco.rs.getString("numero")));
                txtcep.setText(banco.rs.getString("cep"));
                cbxEstado.addItem(banco.rs.getString("estado"));
                cbxcidade.addItem(banco.rs.getString("cidade"));
                cbxCargo.addItem(banco.rs.getString("cargo"));
                txtCPF.setText(banco.rs.getString("cpf"));
                txtRG.setText(banco.rs.getString("rg"));
                txtNascimento.setDate(banco.rs.getDate("DataNAsc"));
                dataAdmisao.setDate(banco.rs.getDate("dataRegistro"));
                txtComplemento.setText(banco.rs.getString("complemento"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar dados !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    /**
     * Método recupera os dados de um registro posterior em relação a posição
     * atual, exceto se o mesmo estiver na última posição.
     * @param evt
     */
    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        btnAnterior.setEnabled(true);
        cbxcidade.removeAllItems();
        cbxEstado.removeAllItems();
        cbxCargo.removeAllItems();

        try {
            if (banco.rs.isLast()) {
                btnProximo.setEnabled(false);
            } else {
                banco.rs.next();
                txtCodigo.setText(banco.rs.getString("id"));
                txtNomeCompleto.setText(banco.rs.getString("nome"));
                txtEndereco.setText(banco.rs.getString("rua"));
                txtBairro.setText(banco.rs.getString("bairro"));
                txtNumero.setText(String.valueOf(banco.rs.getString("numero")));
                txtcep.setText(banco.rs.getString("cep"));
                cbxEstado.addItem(banco.rs.getString("estado"));
                cbxcidade.addItem(banco.rs.getString("cidade"));
                cbxCargo.addItem(banco.rs.getString("cargo"));
                txtCPF.setText(banco.rs.getString("cpf"));
                txtRG.setText(banco.rs.getString("rg"));
                txtNascimento.setDate(banco.rs.getDate("DataNAsc"));
                dataAdmisao.setDate(banco.rs.getDate("dataRegistro"));
                txtComplemento.setText(banco.rs.getString("complemento"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar dados !");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnProximoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarFuncionario.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
    private javax.swing.ButtonGroup Cargo;
    private javax.swing.JPanel barraNavegacao;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cbxCargo;
    private javax.swing.JComboBox<String> cbxCentrodis;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox cbxcidade;
    private com.toedter.calendar.JDateChooser dataAdmisao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
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
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblBairro1;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCargo1;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNascimento1;
    private javax.swing.JLabel lblNomeCompleto;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblSenha1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEndereco;
    private com.toedter.calendar.JDateChooser txtNascimento;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtcep;
    // End of variables declaration//GEN-END:variables

}
