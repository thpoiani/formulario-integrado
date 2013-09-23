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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<Object> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<Object>();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criação de Formulário");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel2.setText("Título");

        jTextField1.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextField1.setText("Título do Formulário");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel3.setText("Cabeçalho");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextArea1.setRows(5);
        jTextArea1.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu cabeçalho personalizado");
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel5.setText("Rodapé");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Calibri", 2, 12));
        jTextArea2.setRows(5);
        jTextArea2.setText("Aqui teremos outro tipo de ferramenta para que o usuário possa criar seu rodapé personalizado");
        jScrollPane2.setViewportView(jTextArea2);

        jButton2.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton2.setText("Criar Nova Categoria");

        jButton3.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton3.setText("Cancelar Formulário");

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton4.setText("Salvar Formulário");

        jButton5.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton5.setText("Limpar Formulário");
        
        jButton6.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton6.setText("Editar Categorias");

        jList2.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList2);

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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton2)
                                            .addComponent(jButton6))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
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

        pack();
        
        // ouvintes
        jButton2.addActionListener(new CriacaoForm.CriarCategoriaHandler());
        jButton3.addActionListener(new CriacaoForm.FecharHandler());
        jButton4.addActionListener(new CriacaoForm.SalvarHandler());
        jButton5.addActionListener(new CriacaoForm.LimparHandler());
        jButton6.addActionListener(new CriacaoForm.EditarCategoriaHandler());
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
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton6
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
