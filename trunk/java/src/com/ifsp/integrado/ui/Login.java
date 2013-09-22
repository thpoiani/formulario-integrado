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
    private javax.swing.JButton jbtnEntrar;
    private javax.swing.JLabel jlblLogin;
    private javax.swing.JLabel jlblSenha;
    private javax.swing.JPanel jpanelLogin;
    private javax.swing.JPasswordField jpswSenha;
    private javax.swing.JTextField jtxtLogin;
    
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
               
        // setar se a janela pode ser redimensionada
        this.setResizable(false);
        
        // setar botão padrão da janela
        this.getRootPane().setDefaultButton(jbtnEntrar);
    }

    /**
     * Método responsável por gerenciar os componentes do JFrame
     */
    private void initComponents() {
    	// instânciação dos atributos da classe
        this.jpanelLogin = new javax.swing.JPanel();
        this.jlblLogin = new javax.swing.JLabel();
        this.jlblSenha = new javax.swing.JLabel();
        this.jpswSenha = new javax.swing.JPasswordField();
        this.jtxtLogin = new javax.swing.JTextField();
        this.jbtnEntrar = new javax.swing.JButton();

        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
        
        // definição de atributos do JPanel
        jpanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        // definição de atributos do JLabel
        jlblLogin.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblLogin.setText("Login: ");
        
        // definição de atributos do JLabel
        jlblSenha.setFont(new java.awt.Font("Calibri", 0, 14));
        jlblSenha.setText("Senha: ");
        
        // definição de atributos do JPasswordField
        jpswSenha.setFont(new java.awt.Font("Calibri", 0, 12));
        jpswSenha.setText("jpswSenha");

        // definição de atributos do JTextField
        jtxtLogin.setFont(new java.awt.Font("Calibri", 0, 12));

        // definição de atributos do JButton
        jbtnEntrar.setFont(new java.awt.Font("Calibri", 0, 14));
        jbtnEntrar.setText("Entrar");

        // definição do GroupLayout
        javax.swing.GroupLayout jpanelLoginLayout = new javax.swing.GroupLayout(jpanelLogin);
        jpanelLogin.setLayout(jpanelLoginLayout);
        jpanelLoginLayout.setHorizontalGroup(
            jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLoginLayout.createSequentialGroup()
                        .addComponent(jlblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jpanelLoginLayout.createSequentialGroup()
                        .addComponent(jlblLogin)
                        .addGap(8, 8, 8)))
                .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtxtLogin)
                    .addComponent(jpswSenha))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanelLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jpanelLoginLayout.setVerticalGroup(
            jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLoginLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblLogin)
                    .addComponent(jtxtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jpanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblSenha)
                    .addComponent(jpswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbtnEntrar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // cálculo de tamanho da janela 
        pack();

        // ouvinte
        jbtnEntrar.addActionListener(new PrincipalHandler());
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