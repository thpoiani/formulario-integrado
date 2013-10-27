package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de listagem de categorias
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class EdicaoCategoria extends javax.swing.JFrame {

    /**
	 * Identificação de versão de serialização da classe
	 */
	private static final long serialVersionUID = 6059170216898900229L;
	
	/**
     * Referência do JFrame anterior
     */
    private javax.swing.JFrame parentFrame;
    
    /**
     * Atributos
     */
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnDescer;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JButton jbtnSubir;
    private javax.swing.JPanel jpanelEditarCategoria;
    private javax.swing.JScrollPane jscrollEditarCategoria;
    private javax.swing.JTable jtblCategoria;

    /**
     * Construtor da classe EdicaoFormulario
     */
    public EdicaoCategoria() {
        initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Categorias");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }

    /**
     * Construtor da classe EdicaoCategoria
     */
    public EdicaoCategoria(javax.swing.JFrame frame) {
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
        jpanelEditarCategoria = new javax.swing.JPanel();
        jscrollEditarCategoria = new javax.swing.JScrollPane();
        jtblCategoria = new javax.swing.JTable();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnSubir = new javax.swing.JButton();
        jbtnDescer = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();

        // definição de atributos do JTable
        jtblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Status"
            }
        ));
        jscrollEditarCategoria.setViewportView(jtblCategoria);

        // definição de atributos do JButton
        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCancelar.setText("Fechar");

        // definição de atributos do JButton
        jbtnEditar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnEditar.setText("Editar");

        // definição de atributos do JButton
        jbtnSubir.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnSubir.setText("Subir");

        // definição de atributos do JButton
        jbtnDescer.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnDescer.setText("Descer");

        // definição de atributos do JButton
        jbtnExcluir.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnExcluir.setText("Excluir");
        
        // definição de atributos do JGroupLayout
        javax.swing.GroupLayout jpanelEditarCategoriaLayout = new javax.swing.GroupLayout(jpanelEditarCategoria);
        jpanelEditarCategoria.setLayout(jpanelEditarCategoriaLayout);
        jpanelEditarCategoriaLayout.setHorizontalGroup(
            jpanelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelEditarCategoriaLayout.createSequentialGroup()
                .addComponent(jscrollEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jpanelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnDescer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSubir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jpanelEditarCategoriaLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jbtnCancelar)
                .addGap(94, 94, 94)
                .addComponent(jbtnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelEditarCategoriaLayout.setVerticalGroup(
            jpanelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelEditarCategoriaLayout.createSequentialGroup()
                .addGroup(jpanelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelEditarCategoriaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jscrollEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jpanelEditarCategoriaLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jbtnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnDescer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpanelEditarCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelEditarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelEditarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // cálculo de tamanho da janela
        pack();
        
        // ouvintes        
        jbtnCancelar.addActionListener(new EdicaoCategoria.FecharHandler());
        jbtnExcluir.addActionListener(new EdicaoCategoria.ExcluirHandler());
        jbtnEditar.addActionListener(new EdicaoCategoria.EditarHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton Cancelar
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class FecharHandler implements ActionListener {
        
        /**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */        
        public void actionPerformed(ActionEvent arg0) {
    		// torna a tela Principal visível novamente
    		if (EdicaoCategoria.this.parentFrame != null) {
    			EdicaoCategoria.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		EdicaoCategoria.this.dispose();
        }
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton Excluir
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class ExcluirHandler implements ActionListener {
        
        /**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */        
        public void actionPerformed(ActionEvent arg0) {
        	// TODO
        	
        	int opcao = JOptionPane.showConfirmDialog(null,
					"Deseja realmente remover esta categoria?", 
					"Categoria", 
					JOptionPane.YES_NO_OPTION); 

			if (opcao == JOptionPane.YES_OPTION) { // SIM
				javax.swing.JOptionPane.showMessageDialog(null, "Categoria removida com sucesso!");
			} else { // NAO 
				return;
			}
        }
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton Editar
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class EditarHandler implements ActionListener {
        
        /**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */        
        public void actionPerformed(ActionEvent arg0) {
        	// TODO
        	
        	// instânciação da classe CriacaoForm que estende JFrame
    		new Categoria(EdicaoCategoria.this).setVisible(true);
    		// CriarForm
    		
    		// setar tela invisivel
    		EdicaoCategoria.this.setVisible(false);
        }
    }
}
