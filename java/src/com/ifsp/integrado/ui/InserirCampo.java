package com.ifsp.integrado.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de inserção de campos
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class InserirCampo extends javax.swing.JFrame {

    /**
	 * Identificação de versão de serialização da classe
	 */
	private static final long serialVersionUID = 1823124884274190772L;
	
	/**
	 * Referência do JFrame anterior
	 */
	private javax.swing.JFrame parentFrame;
	
	/**
	 * Atributos
	 */
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.ButtonGroup group;
    private javax.swing.JTextField jTextField2;
	
    /**
     * Construtor da classe CriacaoFormulario
     */
    public InserirCampo() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Campo");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
    }

    /**
     * Construtor da classe CriacaoFormulario
     * @param javax.swing.JFrame frame
     */
    public InserirCampo(javax.swing.JFrame frame) {
    	// chamada do construtor sem parâmetros
    	this();
    	
    	// referência do JFrame anterior
    	this.parentFrame = frame;
	}

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	// instânciação dos atributos da classe
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        group = new javax.swing.ButtonGroup();
        
        // definição de atributos do JLabel
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        // definição de atributos do JTextField
        jTextField2.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextField2.setText("Nome do Campo");

        // definição de atributos do JComboBox
        jComboBox2.setFont(new java.awt.Font("Calibri", 2, 12));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "string", "double", "int", "date", "boolean" }));

        // definição de atributos do JRadioButton
        jRadioButton1.setFont(new java.awt.Font("Calibri", 0, 14));
        jRadioButton1.setText("Descritivo");
        jRadioButton1.setSelected(true);

        // definição de atributos do JRadioButton
        jRadioButton2.setFont(new java.awt.Font("Calibri", 0, 14));
        jRadioButton2.setText("Múltipla Seleção");
        
        // definição de atributos do JRadioButton
        jRadioButton3.setFont(new java.awt.Font("Calibri", 0, 14));
        jRadioButton3.setText("Única Seleção");

        // definição de atributos do ButtonGroup
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
                
        // definição de atributos do JButton
        jButton1.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton1.setText("Acrescentar Novos Campos");
        
        // definição de atributos do JButton
        jButton2.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton2.setText("Fechar");

        // definição de atributos do JButton
        jButton3.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton3.setText("Salvar");

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        
        // cálculo de tamanho da janela
        pack();
        
        // ouvintes        
        jButton1.addActionListener(new InserirCampoHandler());
        jButton2.addActionListener(new FecharHandler());
        jButton3.addActionListener(new SalvarHandler());
        
        jRadioButton2.addActionListener(new GruposHandler());
        jRadioButton3.addActionListener(new GruposHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton1
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class InserirCampoHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		// instânciação da classe CriarCategoria que estende JFrame
    		if (InserirCampo.this.parentFrame != null) {
    			new InserirCampo(InserirCampo.this.parentFrame).setVisible(true);
    		}
    		
    		InserirCampo.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton2
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
    		if (InserirCampo.this.parentFrame != null) {
    			InserirCampo.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		InserirCampo.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton3
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
    		if (InserirCampo.this.parentFrame != null) {
    			InserirCampo.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		InserirCampo.this.dispose();
    	}
    }

    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do radio JRadioButton2 e JRadioButton3 
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class GruposHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do radio
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		new Grupos(InserirCampo.this, (javax.swing.JRadioButton) arg0.getSource()).setVisible(true);
    		
    		// setar tela invisível
    		InserirCampo.this.setVisible(false);
    	}
    }    
    
}
