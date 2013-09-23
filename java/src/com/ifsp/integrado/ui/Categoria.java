/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    
    /**
 *
 * @author Gislaine
 */
public class Categoria extends javax.swing.JFrame {
    
    /**
     * Identificação de versão de serialização da classe
     */
    private static final long serialVersionUID = -7515137817916302227L;

    /**
     * Referência do JFrame anterior
     */
    private javax.swing.JFrame parentFrame;

    /**
     * Atributos
     */
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnNovoCampo;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JLabel jlblNome;
    private javax.swing.JLabel jlblDescricao;
    private javax.swing.JPanel jpanelCategoria;
    private javax.swing.JScrollPane jscrollDescricao;
    private javax.swing.JTextArea jtxaDescricao;
    private javax.swing.JTextField jtxtNome;
    
    
    /**
     * Construtor da classe Categoria
     */

    public Categoria() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Categoria");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
    }

    public Categoria(javax.swing.JFrame frame) {
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
        jpanelCategoria = new javax.swing.JPanel();
        jlblNome = new javax.swing.JLabel();
        jtxtNome = new javax.swing.JTextField();
        jlblDescricao = new javax.swing.JLabel();
        jscrollDescricao = new javax.swing.JScrollPane();
        jtxaDescricao = new javax.swing.JTextArea();
        jbtnCancelar = new javax.swing.JButton();
        jbtnNovoCampo = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));

        
        // definição de atributos do JLabel
        jlblNome.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblNome.setText("Nome da Categoria: ");

        // definição de atributos do JTextField
        jtxtNome.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtNome.setText("");

        // definição de atributos do JLabel
        jlblDescricao.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblDescricao.setText("Descrição: ");
        
        // definição de atributos do JTextArea
        jtxaDescricao.setColumns(20);
        jtxaDescricao.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxaDescricao.setRows(5);
        jtxaDescricao.setText("");
        jscrollDescricao.setViewportView(jtxaDescricao);
        
        // definição de atributos do JButton
        jbtnLimpar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnLimpar.setText("Limpar");
        
        // definição de atributos do JButton
        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCancelar.setText("Cancelar");
        
        // definição de atributos do JButton
        jbtnNovoCampo.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnNovoCampo.setText("Novo Campo");

        // definição de atributos do JButton
        jbtnSalvar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnSalvar.setText("Salvar");

        // definição do GroupLayout
        javax.swing.GroupLayout jpanelCategoriaLayout = new javax.swing.GroupLayout(jpanelCategoria);
        jpanelCategoria.setLayout(jpanelCategoriaLayout);
        jpanelCategoriaLayout.setHorizontalGroup(
            jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                        .addComponent(jlblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNome))
                    .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                        .addComponent(jlblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnLimpar)
                                .addGap(76, 76, 76)
                                .addComponent(jbtnCancelar)
                                .addGap(82, 82, 82)
                                .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jbtnNovoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jscrollDescricao)))))
                .addContainerGap())
        );
        jpanelCategoriaLayout.setVerticalGroup(
            jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCategoriaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblNome)
                    .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDescricao)
                    .addComponent(jscrollDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtnSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnNovoCampo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

		 // cálculo de tamanho da janela
        pack();
		
		 // ouvintes
        jbtnLimpar.addActionListener(new Categoria.LimparHandler());
        jbtnCancelar.addActionListener(new Categoria.FecharHandler());
        jbtnNovoCampo.addActionListener(new Categoria.CriarCampoHandler());
        jbtnSalvar.addActionListener(new Categoria.SalvarHandler());
    }

    
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton1
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class LimparHandler implements ActionListener {
        
        /**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */        
        public void actionPerformed(ActionEvent arg0) {
            
        }

        
        
    }
    
    private class FecharHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// torna a tela Principal visível novamente
    		if (Categoria.this.parentFrame != null) {
    			Categoria.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		Categoria.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton2
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class CriarCampoHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// instânciação da classe Categoria que estende JFrame
    		new InserirCampo(Categoria.this).setVisible(true);
    		
    		// setar tela invisível
    		Categoria.this.setVisible(false);
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
    		if (Categoria.this.parentFrame != null) {
    			Categoria.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		Categoria.this.dispose();
    	}
    }

}