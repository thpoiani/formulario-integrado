package com.ifsp.integrado.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de criação de formulário
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class CriacaoFormulario extends javax.swing.JFrame {

	/**
	 * Identificação de versão de serialização da classe
	 */
	private static final long serialVersionUID = 2813003822474503521L;
	
	/**
	 * Referência do JFrame anterior
	 */
	private javax.swing.JFrame parentFrame;
	
	/**
	 * Atributos
	 */
	private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;

    /**
     * Construtor da classe CriacaoFormulario
     */
    public CriacaoFormulario() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Formulário");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
    }

    /**
     * Construtor da classe CriacaoFormulario
     * @param javax.swing.JFrame frame
     */
    public CriacaoFormulario(javax.swing.JFrame frame) {
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
    	jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        
        // definição de atributos do JLabel
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criação de Formulário");
        
        // definição de atributos do JLabel
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel2.setText("Título");

        // definição de atributos do JLabel
        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel3.setText("Cabeçalho");
        
        // definição de atributos do JLabel
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel4.setText("Categoria");
        
        // definição de atributos do JLabel
        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel5.setText("Rodapé");
        
        // definição de atributos do JTextField
        jTextField1.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextField1.setText("Título do Formulário");

        // definição de atributos do JTextArea
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextArea1.setRows(5);
        jTextArea1.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu cabeçalho personalizado");
        jScrollPane1.setViewportView(jTextArea1);

        // definição de atributos do JComboBox
        jComboBox1.setFont(new java.awt.Font("Calibri", 2, 12));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "Categoria 1", "Categoria 2", "Categoria 3", "Categoria 4" }));

        // definição de atributos do JTextArea
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextArea2.setRows(5);
        jTextArea2.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu rodapé personalizado");
        jScrollPane2.setViewportView(jTextArea2);

        // definição de atributos do JButton
        jButton2.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton2.setText("Criar Nova Categoria");

        // definição de atributos do JButton
        jButton3.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton3.setText("Cancelar Formulário");
        
        // definição de atributos do JButton
        jButton4.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton4.setText("Salvar Formulário");
        
        // definição de atributos do JButton
        jButton5.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton5.setText("Limpar Formulário");

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(60, 60, 60)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(283, 283, 283))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // cálculo de tamanho da janela
        pack();

        // ouvintes
        jButton2.addActionListener(new CriarCategoriaHandler());
        jButton3.addActionListener(new FecharHandler());
        jButton4.addActionListener(new SalvarHandler());
        jButton5.addActionListener(new LimparHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton2
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class CriarCategoriaHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// instânciação da classe CriarCategoria que estende JFrame
    		new CriarCategoria().setVisible(true);
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton3
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
    		if (CriacaoFormulario.this.parentFrame != null) {
    			CriacaoFormulario.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoFormulario.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton4
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
    		if (CriacaoFormulario.this.parentFrame != null) {
    			CriacaoFormulario.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoFormulario.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton5
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class LimparHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    	}
    }
}
