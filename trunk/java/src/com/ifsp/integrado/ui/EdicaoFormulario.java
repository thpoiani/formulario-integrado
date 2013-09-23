package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de listagem de formulários
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class EdicaoFormulario extends javax.swing.JFrame {

    /**
     * Identificação de versão de serialização da classe
     */
	private static final long serialVersionUID = 3797728162669806511L;
	
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
    private javax.swing.JPanel jpanelEditarFormulario;
    private javax.swing.JScrollPane jscrollEditarFormulario;
    private javax.swing.JTable jtblFormulario;
    
    /**
     * Construtor da classe EdicaoFormulario
     */
    public EdicaoFormulario() {
        initComponents();

        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - Formulários");
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }

    /**
     * Construtor da classe EdicaoFormulario
     */
    public EdicaoFormulario(javax.swing.JFrame frame) {
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
        jpanelEditarFormulario = new javax.swing.JPanel();
        jscrollEditarFormulario = new javax.swing.JScrollPane();
        jtblFormulario = new javax.swing.JTable();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnSubir = new javax.swing.JButton();
        jbtnDescer = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();

        // definição de atributos do JTable
        jtblFormulario.setModel(new javax.swing.table.DefaultTableModel(
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
        jscrollEditarFormulario.setViewportView(jtblFormulario);

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

        // definição do GroupLayout
        javax.swing.GroupLayout jpanelEditarFormularioLayout = new javax.swing.GroupLayout(jpanelEditarFormulario);
        jpanelEditarFormulario.setLayout(jpanelEditarFormularioLayout);
        jpanelEditarFormularioLayout.setHorizontalGroup(
            jpanelEditarFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelEditarFormularioLayout.createSequentialGroup()
                .addComponent(jscrollEditarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jpanelEditarFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnDescer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSubir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
            .addGroup(jpanelEditarFormularioLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jbtnCancelar)
                .addGap(94, 94, 94)
                .addComponent(jbtnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelEditarFormularioLayout.setVerticalGroup(
            jpanelEditarFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelEditarFormularioLayout.createSequentialGroup()
                .addGroup(jpanelEditarFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelEditarFormularioLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jscrollEditarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jpanelEditarFormularioLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jbtnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnDescer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpanelEditarFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jpanelEditarFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelEditarFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // cálculo de tamanho da janela
        pack();
        
        // ouvintes
        jbtnCancelar.addActionListener(new EdicaoFormulario.FecharHandler());
        jbtnExcluir.addActionListener(new EdicaoFormulario.ExcluirHandler());
        jbtnEditar.addActionListener(new EdicaoFormulario.EditarHandler());
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
    		if (EdicaoFormulario.this.parentFrame != null) {
    			EdicaoFormulario.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		EdicaoFormulario.this.dispose();
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
					"Deseja realmente remover este formulário?", 
					"Formulário", 
					JOptionPane.YES_NO_OPTION); 

			if (opcao == JOptionPane.YES_OPTION) { // SIM
				javax.swing.JOptionPane.showMessageDialog(null, "Formulário removido com sucesso!");
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
    		new CriacaoForm(EdicaoFormulario.this).setVisible(true);
    		
    		// setar tela invisivel
    		EdicaoFormulario.this.setVisible(false);
        }
    }
}
