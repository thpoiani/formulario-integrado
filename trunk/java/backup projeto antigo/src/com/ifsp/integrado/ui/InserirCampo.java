package com.ifsp.integrado.ui;

import java.awt.Toolkit;
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
    private javax.swing.JButton jbtnAcrescentarCampos;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnSalvar;
    private javax.swing.JComboBox<String> jcbxTipoCampo;
    private javax.swing.JPanel jpanelInserirCampo;
    private javax.swing.JRadioButton jrdbDescritivo;
    private javax.swing.JRadioButton jrdbMultiplaSelecao;
    private javax.swing.JRadioButton jrdbUnicaSelecao;
    private javax.swing.ButtonGroup group;
    private javax.swing.JTextField jtxtNomeCampo;
	
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
        
        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
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
    	// instanciação dos atributos da classe
        jpanelInserirCampo = new javax.swing.JPanel();
        jtxtNomeCampo = new javax.swing.JTextField();
        jcbxTipoCampo = new javax.swing.JComboBox<String>();
        jrdbDescritivo = new javax.swing.JRadioButton();
        jrdbMultiplaSelecao = new javax.swing.JRadioButton();
        jrdbUnicaSelecao = new javax.swing.JRadioButton();
        jbtnAcrescentarCampos = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalvar = new javax.swing.JButton();
        group = new javax.swing.ButtonGroup();
        
        // definição de atributos do JLabel
        jpanelInserirCampo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        // definição de atributos do JTextField
        jtxtNomeCampo.setFont(new java.awt.Font("Calibri", 2, 12));
        jtxtNomeCampo.setText("");

        // definição de atributos do JComboBox
        jcbxTipoCampo.setFont(new java.awt.Font("Calibri", 2, 12));
        jcbxTipoCampo.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "", "string", "double", "int", "date", "boolean" }));

        // definição de atributos do JRadioButton
        jrdbDescritivo.setFont(new java.awt.Font("Calibri", 0, 14));
        jrdbDescritivo.setText("Descritivo");
        jrdbDescritivo.setSelected(true);

        // definição de atributos do JRadioButton
        jrdbMultiplaSelecao.setFont(new java.awt.Font("Calibri", 0, 14));
        jrdbMultiplaSelecao.setText("Múltipla Seleção");
        
        // definição de atributos do JRadioButton
        jrdbUnicaSelecao.setFont(new java.awt.Font("Calibri", 0, 14));
        jrdbUnicaSelecao.setText("Única Seleção");

        // definição de atributos do ButtonGroup
        group.add(jrdbDescritivo);
        group.add(jrdbMultiplaSelecao);
        group.add(jrdbUnicaSelecao);
                
        // definição de atributos do JButton
        jbtnAcrescentarCampos.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnAcrescentarCampos.setText("Acrescentar Novos Campos");
        
        // definição de atributos do JButton
        jbtnCancelar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnCancelar.setText("Fechar");

        // definição de atributos do JButton
        jbtnSalvar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnSalvar.setText("Salvar");

        // definição do GroupLayout
        javax.swing.GroupLayout jpanelInserirCampoLayout = new javax.swing.GroupLayout(jpanelInserirCampo);
        jpanelInserirCampo.setLayout(jpanelInserirCampoLayout);
        jpanelInserirCampoLayout.setHorizontalGroup(
            jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelInserirCampoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtNomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar))
                .addGroup(jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelInserirCampoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jcbxTipoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jrdbDescritivo)
                        .addGap(18, 18, 18)
                        .addComponent(jrdbMultiplaSelecao)
                        .addGap(18, 18, 18)
                        .addComponent(jrdbUnicaSelecao)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpanelInserirCampoLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jbtnAcrescentarCampos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jpanelInserirCampoLayout.setVerticalGroup(
            jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelInserirCampoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxTipoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrdbDescritivo)
                    .addComponent(jrdbMultiplaSelecao)
                    .addComponent(jrdbUnicaSelecao))
                .addGap(18, 18, 18)
                .addGroup(jpanelInserirCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAcrescentarCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jpanelInserirCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jpanelInserirCampo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        
        // cálculo de tamanho da janela
        pack();
        
        // ouvintes        
        jbtnAcrescentarCampos.addActionListener(new InserirCampoHandler());
        jbtnCancelar.addActionListener(new FecharHandler());
        jbtnSalvar.addActionListener(new SalvarHandler());
        
        jrdbMultiplaSelecao.addActionListener(new GruposHandler());
        jrdbUnicaSelecao.addActionListener(new GruposHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão jbtnAcrescentarCampos
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
    		if (InserirCampo.this.parentFrame != null) {
    			InserirCampo.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		InserirCampo.this.dispose();
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
    		if (InserirCampo.this.parentFrame != null) {
    			InserirCampo.this.parentFrame.setVisible(true);    			
    		}
    		
    		// fecha a janela atual
    		InserirCampo.this.dispose();
    	}
    }

    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do radio jrdbMultiplaSelecao e jrdbUnicaSelecao 
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
