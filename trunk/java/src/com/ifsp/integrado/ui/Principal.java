package com.ifsp.integrado.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela principal possuindo o 
 * redirecionamento para as telas de Criação de Formulário, Importação de
 * Formulário e Abertura de Categorias 
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class Principal extends javax.swing.JFrame {

	/**
	 * Identificação de versão de serialização da classe
	 */
	private static final long serialVersionUID = 7997028687274933146L;
	
	/**
	 * Atributos
	 */
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;

    /**
     * Construtor da classe Principal
     */
    public Principal() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - IFSP");
        
        // setar cor de fundo do JFrame
        this.setBackground(new java.awt.Color(255, 255, 255));
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
    }
    
    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	// instânciação dos atributos da classe
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        
        // definição de atributos do JLabel
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ifsp/integrado/assets/ifsp.png")));
        
        // definição de atributos do JFrame
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        // definição de atributos do JButton
        jButton2.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton2.setText("Abrir Formulário");

        // definição de atributos do JButton
        jButton4.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton4.setText("Abrir Categoria");

        // definição de atributos do JButton
        jButton5.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton5.setText("Criar Formulário");
        
        // definição de atributos do Separator
        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        // definição de atributos do JSeparator
        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        // cálculo de tamanho da janela
        pack();
        
        // ouvintes
        jButton2.addActionListener(new AbriFormHandler());
        jButton4.addActionListener(new CriarCategoriaHandler());
        jButton5.addActionListener(new CriacaoFormularioHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton2
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class AbriFormHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		javax.swing.JFileChooser jFileChooser1 = new javax.swing.JFileChooser();
    		
    		if (jFileChooser1.showOpenDialog(Principal.this) == javax.swing.JFileChooser.APPROVE_OPTION) { 
    		      System.out.println("Diretório: " + jFileChooser1.getCurrentDirectory());
    		      System.out.println("Arquivo : " + jFileChooser1.getSelectedFile());
    		}
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton4
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
    		new CriarCategoria(Principal.this).setVisible(true);
    		
    		// setar tela invisível
    		Principal.this.setVisible(false);
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton5
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class CriacaoFormularioHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// instânciação da classe CriacaoFormulario que estende JFrame
    		new CriacaoFormulario(Principal.this).setVisible(true);
    		
    		// setar tela invisivel
    		Principal.this.setVisible(false);
    	}
    }
}
