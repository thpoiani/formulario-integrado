package com.ifsp.integrado.ui;

import java.awt.Toolkit;
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
    private javax.swing.JButton jbtnAbrirForm;
    private javax.swing.JButton jbtnAbrirCategoria;
    private javax.swing.JButton jbtnCriarForm;
    private javax.swing.JButton jbtnEditarCategoria;
    private javax.swing.JLabel jlblImagem;
    private javax.swing.JPanel jpanelPrincipal;
    private javax.swing.JSeparator jSeparator1;

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
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	// instânciação dos atributos da classe
        jpanelPrincipal = new javax.swing.JPanel();
        jbtnAbrirForm = new javax.swing.JButton();
        jbtnAbrirCategoria = new javax.swing.JButton();
        jbtnEditarCategoria = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();       
        jbtnCriarForm = new javax.swing.JButton();
        jlblImagem = new javax.swing.JLabel();
        
        // definição de atributos do JLabel
        jlblImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ifsp/integrado/assets/ifsp.png")));
        
        // definição de atributos do JFrame
        jpanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jpanelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        // definição de atributos do JButton
        jbtnAbrirForm.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnAbrirForm.setText("Editar Formulário");

        // definição de atributos do JButton
        jbtnAbrirCategoria.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnAbrirCategoria.setText("Abrir Categoria");

        // definição de atributos do JButton
        jbtnCriarForm.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCriarForm.setText("Criar Formulário");
        
        // definição de atributos do JButton
        jbtnEditarCategoria.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnEditarCategoria.setText("Editar Categoria");
        
        // definição de atributos do Separator
        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));

        // definição do GroupLayout
        javax.swing.GroupLayout jpanelPrincipalLayout = new javax.swing.GroupLayout(jpanelPrincipal);
        jpanelPrincipal.setLayout(jpanelPrincipalLayout);
        jpanelPrincipalLayout.setHorizontalGroup(
            jpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jpanelPrincipalLayout.createSequentialGroup()
                .addGap(179, 179, 179)                
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelPrincipalLayout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnAbrirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCriarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAbrirForm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jpanelPrincipalLayout.setVerticalGroup(
            jpanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelPrincipalLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jbtnCriarForm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)               
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnAbrirForm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtnAbrirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jbtnEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlblImagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jlblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        // cálculo de tamanho da janela
        pack();
        
        // ouvintes
        jbtnAbrirForm.addActionListener(new Principal.AbriFormHandler());
        jbtnAbrirCategoria.addActionListener(new Principal.CriarCategoriaHandler());
        jbtnCriarForm.addActionListener(new Principal.CriacaoFormularioHandler());
        jbtnEditarCategoria.addActionListener(new Principal.EdicaoCategoriaHandler());
        
    }                     

    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton6
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class EdicaoCategoriaHandler implements ActionListener{
        
        /**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// instânciação da classe Categoria que estende JFrame
    		new EdicaoCategoria(Principal.this).setVisible(true);
    		
    		// setar tela invisível
    		Principal.this.setVisible(false);
    	}
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
    		// instânciação da classe Categoria que estende JFrame
    		new EdicaoFormulario(Principal.this).setVisible(true);
    		
    		// setar tela invisível
    		Principal.this.setVisible(false);
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
    		// instânciação da classe Categoria que estende JFrame
    		new Categoria(Principal.this).setVisible(true);
    		
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
    		// instânciação da classe CriacaoForm que estende JFrame
    		new CriacaoForm(Principal.this).setVisible(true);
    		
    		// setar tela invisivel
    		Principal.this.setVisible(false);
    	}
    }


}

