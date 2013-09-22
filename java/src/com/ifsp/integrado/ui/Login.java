package com.ifsp.integrado.ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * Essa classe é responsável por exibir a tela de login possuindo as chamadas 
 * das regras de autenticação.
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class Login extends javax.swing.JFrame {
	
	/**
	 * Identificação de versão de serialização da classe
	 */
	private static final long serialVersionUID = -1562828853183792632L;
	
	/**
	 * Atributos
	 */
	private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    
    /**
     * Construtor da classe Login
     */
    public Login() {
        this.initComponents();
        
        // setar a localização da janela sem relação a nenhum componente específico
        // janela centralizada
        this.setLocationRelativeTo(null);
        
        // setar a operação padrão que ocorrerá quando fechar a janela
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // setar título do JFrame
        this.setTitle("Formulário Integrado - IFSP");
        
        //setar icone
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/LogoIFSP.jpg")));
        
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
        
        // setar botão padrão da janela
        this.getRootPane().setDefaultButton(jButton1);
    }

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	// instânciação dos atributos da classe
        this.jPanel1 = new javax.swing.JPanel();
        this.jLabel1 = new javax.swing.JLabel();
        this.jLabel2 = new javax.swing.JLabel();
        this.jPasswordField1 = new javax.swing.JPasswordField();
        this.jTextField1 = new javax.swing.JTextField();
        this.jButton1 = new javax.swing.JButton();

        // definição de atributos do JPanel
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        // definição de atributos do JLabel
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel1.setText("Login: ");
        
        // definição de atributos do JLabel
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14));
        jLabel2.setText("Senha: ");
        
        // definição de atributos do JPasswordField
        jPasswordField1.setFont(new java.awt.Font("Calibri", 0, 12));
        jPasswordField1.setText("jPasswordField1");

        // definição de atributos do JTextField
        jTextField1.setFont(new java.awt.Font("Calibri", 0, 12));

        // definição de atributos do JButton
        jButton1.setFont(new java.awt.Font("Calibri", 0, 14));
        jButton1.setText("Entrar");

        // definição do GroupLayout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField1))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // cálculo de tamanho da janela 
        pack();

        // ouvinte
        jButton1.addActionListener(new PrincipalHandler());
    }
    
    /**
     * Classe privada responsável por implementar as ações do evento de clique
     * do botão JButton1
     * 
     * @author Gislaine Ferreira Gonçalves
     * @author Thiago Henrique Poiani
     */
    private class PrincipalHandler implements ActionListener{

    	/**
    	 * Método responsável pela funcionalidade do clique do botão
    	 */
    	public void actionPerformed(ActionEvent arg0) {
    		// TODO
    		
    		// instânciação da classe Principal que estende JFrame
    		new Principal().setVisible(true);
    		
    		// fecha a janela atual
    		Login.this.dispose();
    	}
    }
}