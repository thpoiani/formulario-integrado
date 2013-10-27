package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de inserção de grupos
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class Grupos extends javax.swing.JFrame {

    /**
     * Identificação de versão de serialização da classe 
	 */
	private static final long serialVersionUID = 5013018251635518633L;
	
	/**
	 * Referência do JFrame anterior
	 */
	private javax.swing.JFrame parentFrame;

	/**
	 * Atributos
	 */
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox<String> jcbxTipoOp1;
    private javax.swing.JComboBox<String> jcbxTipoOp2;
    private javax.swing.JComboBox<String> jcbxTipoOp3;
    private javax.swing.JComboBox<String> jcbxTipoOp4;
    private javax.swing.JComboBox<String> jcbxTipoOp5;
    private javax.swing.JComboBox<String> jcbxTipoOp6;
    private javax.swing.JLabel jlblOp1;
    private javax.swing.JLabel jlblTipo4;
    private javax.swing.JLabel jlblOp5;
    private javax.swing.JLabel jlblTipo5;
    private javax.swing.JLabel jlbOp6;
    private javax.swing.JLabel jlbTipo6;
    private javax.swing.JLabel jlblTipo1;
    private javax.swing.JLabel jlblOp2;
    private javax.swing.JLabel jlblTipo2;
    private javax.swing.JLabel jlblOp3;
    private javax.swing.JLabel jlblTipo3;
    private javax.swing.JLabel jlblOp4;
    private javax.swing.JPanel jpanelGrupos;
    private javax.swing.JPanel jpanelOp1;
    private javax.swing.JPanel jpanelOp2;
    private javax.swing.JPanel jpanelOp3;
    private javax.swing.JPanel jpanelOp4;
    private javax.swing.JPanel jpanelOp5;
    private javax.swing.JPanel jpanelOp6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jtxtOp1;
    private javax.swing.JTextField jtxtOp2;
    private javax.swing.JTextField jtxtOp3;
    private javax.swing.JTextField jtxtOp4;
    private javax.swing.JTextField jtxtOp5;
    private javax.swing.JTextField jtxtOp6;
	
    /**
     * Construtor da classe CriacaoFormulario
     */
    public Grupos() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Grupo");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);

        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }
    
    /**
     * Construtor da classe CriacaoFormulario
     * @param javax.swing.JFrame frame
     */
    public Grupos(javax.swing.JFrame frame) {
    	// chamada do construtor sem parâmetros
    	this();
    	
    	// referência do JFrame anterior
    	this.parentFrame = frame;
	}
    
    /**
     * Construtor da classe CriacaoFormulario
     * @param javax.swing.JFrame frame
     * @param Object arg
     */
    public Grupos(javax.swing.JFrame frame, javax.swing.JRadioButton arg) {
    	// chamada do construtor sem parâmetros
    	this(frame);
    	
    	switch(arg.getText()) {
    		case "Múltipla Seleção" :
    			// TODO check
    			break;
    		case "Única Seleção" :
    			// TODO radio
    			break;
    	}
    	
	}
   

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	
    	// instânciação dos atributos da classe
        jpanelGrupos = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jpanelOp1 = new javax.swing.JPanel();
        jlblOp1 = new javax.swing.JLabel();
        jtxtOp1 = new javax.swing.JTextField();
        jlblTipo1 = new javax.swing.JLabel();
        jcbxTipoOp1 = new javax.swing.JComboBox<String>();
        jpanelOp2 = new javax.swing.JPanel();
        jlblOp2 = new javax.swing.JLabel();
        jtxtOp2 = new javax.swing.JTextField();
        jlblTipo2 = new javax.swing.JLabel();
        jcbxTipoOp2 = new javax.swing.JComboBox<String>();
        jpanelOp3 = new javax.swing.JPanel();
        jlblOp3 = new javax.swing.JLabel();
        jtxtOp3 = new javax.swing.JTextField();
        jlblTipo3 = new javax.swing.JLabel();
        jcbxTipoOp3 = new javax.swing.JComboBox<String>();
        jpanelOp4 = new javax.swing.JPanel();
        jlblOp4 = new javax.swing.JLabel();
        jtxtOp4 = new javax.swing.JTextField();
        jlblTipo4 = new javax.swing.JLabel();
        jcbxTipoOp4 = new javax.swing.JComboBox<String>();
        jSeparator2 = new javax.swing.JSeparator();
        jpanelOp6 = new javax.swing.JPanel();
        jlbOp6 = new javax.swing.JLabel();
        jtxtOp6 = new javax.swing.JTextField();
        jlbTipo6 = new javax.swing.JLabel();
        jcbxTipoOp6 = new javax.swing.JComboBox<String>();
        jpanelOp5 = new javax.swing.JPanel();
        jlblOp5 = new javax.swing.JLabel();
        jtxtOp5 = new javax.swing.JTextField();
        jlblTipo5 = new javax.swing.JLabel();
        jcbxTipoOp5 = new javax.swing.JComboBox<String>();
        jbtnCancelar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        
        // definição de atributos do JSeparator
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        // definição de atributos do JPanel
        jpanelOp1.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 1"));

        // definição de atributos do JLabel
        jlblOp1.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblOp1.setText("Opção: ");

        // definição de atributos do JLabel
        jtxtOp1.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp1.setText("");
        
        // definição de atributos do JLabel
        jlblTipo1.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTipo1.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp1.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jpanelOp1);
        jpanelOp1.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblOp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblTipo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOp1)
                    .addComponent(jtxtOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblTipo1)
                    .addComponent(jcbxTipoOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JPanel
        jpanelOp2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 2"));

        // definição de atributos do JLabel
        jlblOp2.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblOp2.setText("Opção: ");
        
        // definição de atributos do JTextField
        jtxtOp2.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp2.setText("");

        // definição de atributos do JLabel
        jlblTipo2.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTipo2.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp2.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jpanelOp2);
        jpanelOp2.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlblOp2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlblTipo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOp2)
                    .addComponent(jtxtOp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblTipo2)
                    .addComponent(jcbxTipoOp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JPanel
        jpanelOp3.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 3"));

        // definição de atributos do JLabel
        jlblOp3.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblOp3.setText("Opção: ");

        // definição de atributos do JTextField
        jtxtOp3.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp3.setText("");

        // definição de atributos do JLabel
        jlblTipo3.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTipo3.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp3.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jpanelOp3);
        jpanelOp3.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlblOp3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jlblTipo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOp3)
                    .addComponent(jtxtOp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblTipo3)
                    .addComponent(jcbxTipoOp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JButton
        jpanelOp4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 4"));

        // definição de atributos do JLabel
        jlblOp4.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblOp4.setText("Opção: ");

        // definição de atributos do JTextField
        jtxtOp4.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp4.setText("");

        // definição de atributos do JLabel
        jlblTipo4.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTipo4.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp4.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição de GroupLayout
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jpanelOp4);
        jpanelOp4.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jlblOp4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jlblTipo4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOp4)
                    .addComponent(jtxtOp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblTipo4)
                    .addComponent(jcbxTipoOp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JSeparator
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        // definição de atributos do JPanel
        jpanelOp6.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 6"));

        // definição de atributos do JLabel
        jlbOp6.setFont(new java.awt.Font("Calibri", 0, 14));
        jlbOp6.setText("Opção: ");

        // definição de atributos do JTextField
        jtxtOp6.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp6.setText("");

        // definição de atributos do JLabel
        jlbTipo6.setFont(new java.awt.Font("Calibri", 0, 14));
        jlbTipo6.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp6.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição de GroupLayout
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jpanelOp6);
        jpanelOp6.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlbOp6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jlbTipo6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbOp6)
                    .addComponent(jtxtOp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTipo6)
                    .addComponent(jcbxTipoOp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JPanel
        jpanelOp5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opção 5"));

        // definição de atributos do JLabel
        jlblOp5.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblOp5.setText("Opção: ");

        // definição de atributos do JTextField
        jtxtOp5.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtOp5.setText("");

        // definição de atributos do JLabel
        jlblTipo5.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTipo5.setText("Tipo:");

        // definição de atributos do JComboBox
        jcbxTipoOp5.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição de atributos do JGroupBox
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jpanelOp5);
        jpanelOp5.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jlblOp5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jlblTipo5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxTipoOp5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOp5)
                    .addComponent(jtxtOp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblTipo5)
                    .addComponent(jcbxTipoOp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // definição de atributos do JButton
        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCancelar.setText("Fechar");
        
        // definição de atributos do JButton
        jbtnLimpar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnLimpar.setText("Limpar");

        // definição de atributos do JButton
        jbtnSalvar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnSalvar.setText("Salvar");
        
        // definição de atributos do JGroupLayout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jpanelGrupos);
        jpanelGrupos.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpanelOp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpanelOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jpanelOp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpanelOp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jbtnLimpar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpanelOp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpanelOp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanelOp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelOp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanelOp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpanelOp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jpanelOp4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        // definição de GroupLayout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // cálculo de tamanho da janela
        pack();
        
        jbtnCancelar.addActionListener(new FecharHandler());
        jbtnLimpar.addActionListener(new LimparHandler());
        jbtnSalvar.addActionListener(new SalvarHandler());
    }

    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton1
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class FecharHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// torna a tela Principal visível novamente
    		if (Grupos.this.parentFrame != null) {
    			Grupos.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		Grupos.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton2
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class SalvarHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		// torna a tela Principal visível novamente
    		if (Grupos.this.parentFrame != null) {
    			Grupos.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		Grupos.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton3
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class LimparHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		jtxtOp1.setText("");
    		jcbxTipoOp1.setSelectedIndex(0);
    		
    		jtxtOp2.setText("");
    		jcbxTipoOp2.setSelectedIndex(0);
    		
    		jtxtOp3.setText("");
    		jcbxTipoOp3.setSelectedIndex(0);
    		
    		jtxtOp4.setText("");
    		jcbxTipoOp4.setSelectedIndex(0);
    		
    		jtxtOp5.setText("");
    		jcbxTipoOp5.setSelectedIndex(0);
    		
    		jtxtOp6.setText("");
    		jcbxTipoOp6.setSelectedIndex(0);
    	}
    }
}
