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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnEntrar;
    private javax.swing.JLabel jlblLogin;
    private javax.swing.JLabel jlblSenha;
    private javax.swing.JPanel jpanelLogin;
    private javax.swing.JPasswordField jpsswSenha;
    private javax.swing.JTextField jtxtLogin;
    // End of variables declaration//GEN-END:variables
    
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

        // inserção do ícone do projeto
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/ifsp/integrado/assets/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelLogin = new javax.swing.JPanel();
        jlblLogin = new javax.swing.JLabel();
        jlblSenha = new javax.swing.JLabel();
        jpsswSenha = new javax.swing.JPasswordField();
        jtxtLogin = new javax.swing.JTextField();
        jbtnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fazer Login");
        setResizable(false);

        jpanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblLogin.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlblLogin.setText("Login: ");

        jlblSenha.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jlblSenha.setText("Senha: ");

        jpsswSenha.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jpsswSenha.setText("jPasswordField1");

        jtxtLogin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jbtnEntrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jbtnEntrar.setText("Entrar");

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
                    .addComponent(jpsswSenha))
                .addContainerGap(27, Short.MAX_VALUE))
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
                    .addComponent(jpsswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pack();
        
        jbtnEntrar.addActionListener(new PrincipalHandler());
    }// </editor-fold>//GEN-END:initComponents
    
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