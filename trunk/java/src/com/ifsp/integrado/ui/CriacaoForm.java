/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de criação de formulário
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class CriacaoForm extends javax.swing.JFrame {

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
    private javax.swing.JButton jbtnNovaCategoria;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnEditarCategoria;
    private javax.swing.JLabel jlblCriacao;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblCabecalho;
    private javax.swing.JLabel jlblRodape;
    private javax.swing.JList<Object> jlistLista;
    private javax.swing.JPanel jpanelCriacaoForm;
    private javax.swing.JScrollPane jscrollCabecalho;
    private javax.swing.JScrollPane jscrollRodape;
    private javax.swing.JScrollPane jscrollLista;
    private javax.swing.JTextArea jtxaCabecalho;
    private javax.swing.JTextArea jtxaRodape;
    private javax.swing.JTextField jtxtTitulo;

    /**
     * Construtor da classe CriacaoFormulario
     */
    public CriacaoForm() {
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
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }

    /**
     * Construtor da classe CriacaoFormulario
     * @param javax.swing.JFrame frame
     */
    public CriacaoForm(javax.swing.JFrame frame) {
    	// chamada do construtor sem parâmetros
    	this();
    	
    	// referência do JFrame anterior
    	this.parentFrame = frame;
	}

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    @SuppressWarnings("serial")
	private void initComponents() {

        jpanelCriacaoForm = new javax.swing.JPanel();
        jlblCriacao = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jtxtTitulo = new javax.swing.JTextField();
        jlblCabecalho = new javax.swing.JLabel();
        jscrollCabecalho = new javax.swing.JScrollPane();
        jtxaCabecalho = new javax.swing.JTextArea();
        jlblRodape = new javax.swing.JLabel();
        jscrollRodape = new javax.swing.JScrollPane();
        jtxaRodape = new javax.swing.JTextArea();
        jbtnNovaCategoria = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jscrollLista = new javax.swing.JScrollPane();
        jlistLista = new javax.swing.JList<Object>();
        jbtnEditarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlblCriacao.setFont(new java.awt.Font("Calibri", 0, 18));
        jlblCriacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblCriacao.setText("Criação de Formulário");

        jlblTitulo.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTitulo.setText("Título");

        jtxtTitulo.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtTitulo.setText("Título do Formulário");

        jlblCabecalho.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblCabecalho.setText("Cabeçalho");

        jtxaCabecalho.setColumns(20);
        jtxaCabecalho.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxaCabecalho.setRows(5);
        jtxaCabecalho.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu cabeçalho personalizado");
        jscrollCabecalho.setViewportView(jtxaCabecalho);

        jlblRodape.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblRodape.setText("Rodapé");

        jtxaRodape.setColumns(20);
        jtxaRodape.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxaRodape.setRows(5);
        jtxaRodape.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu rodapé personalizado");
        jscrollRodape.setViewportView(jtxaRodape);

        jbtnNovaCategoria.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnNovaCategoria.setText("Criar Nova Categoria");

        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCancelar.setText("Cancelar Formulário");

        jbtnSalvar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnSalvar.setText("Salvar Formulário");

        jbtnLimpar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnLimpar.setText("Limpar Formulário");
        
        jbtnEditarCategoria.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnEditarCategoria.setText("Editar Categorias");

        jlistLista.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jscrollLista.setViewportView(jlistLista);

        javax.swing.GroupLayout jpanelCriacaoFormLayout = new javax.swing.GroupLayout(jpanelCriacaoForm);
        jpanelCriacaoForm.setLayout(jpanelCriacaoFormLayout);
        jpanelCriacaoFormLayout.setHorizontalGroup(
            jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jbtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnLimpar)
                .addGap(60, 60, 60)
                .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelCriacaoFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelCriacaoFormLayout.createSequentialGroup()
                .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrollRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanelCriacaoFormLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrollCabecalho)
                            .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtTitulo))
                            .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                                .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                                        .addComponent(jscrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jbtnNovaCategoria)
                                            .addComponent(jbtnEditarCategoria))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        jpanelCriacaoFormLayout.setVerticalGroup(
            jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblCriacao)
                .addGap(18, 18, 18)
                .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTitulo)
                    .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jlblCabecalho)
                .addGap(18, 18, 18)
                .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                        .addComponent(jscrollCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jscrollLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelCriacaoFormLayout.createSequentialGroup()
                        .addComponent(jbtnEditarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnNovaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jlblRodape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscrollRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jpanelCriacaoFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelCriacaoForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelCriacaoForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        
        // ouvintes
        jbtnNovaCategoria.addActionListener(new CriacaoForm.CriarCategoriaHandler());
        jbtnCancelar.addActionListener(new CriacaoForm.FecharHandler());
        jbtnSalvar.addActionListener(new CriacaoForm.SalvarHandler());
        jbtnLimpar.addActionListener(new CriacaoForm.LimparHandler());
        jbtnEditarCategoria.addActionListener(new CriacaoForm.EditarCategoriaHandler());
    }
    
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnNovaCategoria
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
    		new Categoria(CriacaoForm.this).setVisible(true);
    		
    		CriacaoForm.this.setVisible(false);
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnCancelar
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
    		if (CriacaoForm.this.parentFrame != null) {
    			CriacaoForm.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoForm.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnSalvar
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
    		if (CriacaoForm.this.parentFrame != null) {
    			CriacaoForm.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoForm.this.dispose();
    	}
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnLimpar
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
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnEditarCategoria
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class EditarCategoriaHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		// instânciação da classe Categoria que estende JFrame
    		new EdicaoCategoria(CriacaoForm.this).setVisible(true);
    		
    		// setar tela invisível
    		CriacaoForm.this.setVisible(false);
    	}
    }
}
