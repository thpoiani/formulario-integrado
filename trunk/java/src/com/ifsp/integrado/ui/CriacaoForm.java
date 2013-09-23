/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifsp.integrado.ui;

import java.awt.Toolkit;
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
    private javax.swing.JButton jbtnCriarCategoria;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JLabel jlblPrinc;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblCabecalho;
    private javax.swing.JLabel jlblCategoria;
    private javax.swing.JLabel jlblRodape;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jpanelCriarForm;
    private javax.swing.JScrollPane jscrollCabecalho;
    private javax.swing.JScrollPane jscrollRodape;
    private javax.swing.JScrollPane jScrollPane3;
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
    private void initComponents() {
    	// instânciação dos atributos da classe

        jpanelCriarForm = new javax.swing.JPanel();
        jlblPrinc = new javax.swing.JLabel();
        jlblTitulo = new javax.swing.JLabel();
        jtxtTitulo = new javax.swing.JTextField();
        jlblCabecalho = new javax.swing.JLabel();
        jscrollCabecalho = new javax.swing.JScrollPane();
        jtxaCabecalho = new javax.swing.JTextArea();
        jlblCategoria = new javax.swing.JLabel();
        jlblRodape = new javax.swing.JLabel();
        jscrollRodape = new javax.swing.JScrollPane();
        jtxaRodape = new javax.swing.JTextArea();
        jbtnCriarCategoria = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();

         // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
        
        // definição de atributos do JLabel
        jlblPrinc.setFont(new java.awt.Font("Calibri", 0, 18));
        jlblPrinc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblPrinc.setText("Criação de Formulário");
        
        // definição de atributos do JLabel
        jlblTitulo.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblTitulo.setText("Título");

        // definição de atributos do JLabel
        jlblCabecalho.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblCabecalho.setText("Cabeçalho");
        
        // definição de atributos do JLabel
        jlblCategoria.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblCategoria.setText("Categoria");
        
        // definição de atributos do JLabel
        jlblRodape.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblRodape.setText("Rodapé");
        
        // definição de atributos do JTextField
        jtxtTitulo.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtTitulo.setText("Título do Formulário");

        // definição de atributos do JTextArea
        jtxaCabecalho.setColumns(20);
        jtxaCabecalho.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxaCabecalho.setRows(5);
        jtxaCabecalho.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu cabeçalho personalizado");
        jscrollCabecalho.setViewportView(jtxaCabecalho);
		
		jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jbtnCriarCategoria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbtnCriarCategoria.setText("Criar Nova Categoria");

        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbtnCancelar.setText("Cancelar Formulário");

        jbtnSalvar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbtnSalvar.setText("Salvar Formulário");

        jbtnLimpar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbtnLimpar.setText("Limpar Formulário");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jpanelCriarForm);
        jpanelCriarForm.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jbtnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnLimpar)
                .addGap(60, 60, 60)
                .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblPrinc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrollCabecalho)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtTitulo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnCriarCategoria)
                                .addGap(61, 61, 61))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jscrollRodape, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblPrinc)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblTitulo)
                    .addComponent(jtxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jlblCabecalho)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jscrollRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCategoria)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnCriarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)))
                .addComponent(jlblRodape)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jscrollRodape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                .addComponent(jpanelCriarForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelCriarForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        // cálculo de tamanho da janela
        pack();

        // ouvintes
        jbtnCriarCategoria.addActionListener(new CriacaoForm.CriarCategoriaHandler());
        jbtnCancelar.addActionListener(new CriacaoForm.FecharHandler());
        jbtnSalvar.addActionListener(new CriacaoForm.SalvarHandler());
        jbtnLimpar.addActionListener(new CriacaoForm.LimparHandler());
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
    		new Categoria(CriacaoForm.this).setVisible(true);
    		
    		CriacaoForm.this.setVisible(false);
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
    		if (CriacaoForm.this.parentFrame != null) {
    			CriacaoForm.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoForm.this.dispose();
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
    		if (CriacaoForm.this.parentFrame != null) {
    			CriacaoForm.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		CriacaoForm.this.dispose();
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
