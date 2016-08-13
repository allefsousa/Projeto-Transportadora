/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Felipe
 */
public class Entrega extends javax.swing.JFrame {

    /**
     * Creates new form Entrega
     */
    public Entrega() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
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
        jSeparator10 = new javax.swing.JToolBar.Separator();
        btnUltimo = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        lblNumeroEntrega = new javax.swing.JLabel();
        lblTipoEntrega = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblCEP = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblDataEntrega = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNumeroEntrega = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        cbxCidade = new javax.swing.JComboBox();
        cbxEstado = new javax.swing.JComboBox();
        txtCEP = new javax.swing.JFormattedTextField();
        txtData = new com.toedter.calendar.JDateChooser();
        cbxEntrega = new javax.swing.JComboBox();
        lblRota = new javax.swing.JLabel();
        cbxRota = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Entrega"); // NOI18N
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
        lblTitulo.setText("ENTREGA");

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
        btnPrimeiro.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnAnterior.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnNovo.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnGravar.setBorder(null);
        btnGravar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGravar.setFocusable(false);
        btnGravar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGravar.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnEditar.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnLimpar.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnExcluir.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnPesquisar.setMaximumSize(new java.awt.Dimension(70, 60));
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
        btnProximo.setMaximumSize(new java.awt.Dimension(70, 60));
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
        jToolBar1.add(btnProximo);
        jToolBar1.add(jSeparator10);

        btnUltimo.setBackground(new java.awt.Color(0, 28, 119));
        btnUltimo.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        btnUltimo.setForeground(new java.awt.Color(255, 255, 255));
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Ultimo.png"))); // NOI18N
        btnUltimo.setText("ULTIMO");
        btnUltimo.setBorder(null);
        btnUltimo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUltimo.setFocusable(false);
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUltimo.setMaximumSize(new java.awt.Dimension(70, 60));
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
        jToolBar1.add(btnUltimo);
        jToolBar1.add(jSeparator11);

        lblNumeroEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumeroEntrega.setText("Numero da Entrega:");

        lblTipoEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTipoEntrega.setText("Tipo de Entrega:");

        lblEndereco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblBairro.setText("Bairro:");

        lblCEP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCEP.setText("CEP:");

        lblCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCidade.setText("Cidade:");

        lblDataEntrega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDataEntrega.setText("Data Entrega:");

        lblEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEstado.setText("Estado:");

        lblNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumero.setText("Numero:");

        txtNumeroEntrega.setPreferredSize(new java.awt.Dimension(60, 20));

        cbxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha uma cidade...", " " }));
        cbxCidade.setPreferredSize(new java.awt.Dimension(100, 20));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SP", "MG" }));

        cbxEntrega.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbxEntrega.setPreferredSize(new java.awt.Dimension(100, 20));

        lblRota.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRota.setText("Rota:");

        cbxRota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbxRota.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTipoEntrega)
                            .addComponent(lblNumeroEntrega)
                            .addComponent(lblEndereco)
                            .addComponent(lblBairro)
                            .addComponent(lblCEP)
                            .addComponent(lblCidade)
                            .addComponent(lblDataEntrega)
                            .addComponent(lblRota))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblEstado))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblNumero)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(167, 167, 167))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumeroEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxRota, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BarraMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroEntrega)
                            .addComponent(txtNumeroEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoEntrega)
                            .addComponent(cbxEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEndereco)
                            .addComponent(lblNumero)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblBairro))
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCidade)
                    .addComponent(lblEstado)
                    .addComponent(cbxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataEntrega)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRota)
                    .addComponent(cbxRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraMenu;
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
    private javax.swing.JComboBox cbxCidade;
    private javax.swing.JComboBox cbxEntrega;
    private javax.swing.JComboBox cbxEstado;
    private javax.swing.JComboBox cbxRota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
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
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblDataEntrega;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblNumeroEntrega;
    private javax.swing.JLabel lblRota;
    private javax.swing.JLabel lblTipoEntrega;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumeroEntrega;
    // End of variables declaration//GEN-END:variables
}