package com.ifsp.integrado;

import com.ifsp.integrado.business.database.Database;
import com.ifsp.integrado.ui.Login;

/**
 * Formulário integrado ao Programa de Assistência Estudantil - IFSP São Carlos
 * 
 * O projeto tem como objetivo o dinamismo e a facilidade para gerenciamento de 
 * formulários, principalmente o do Programa de Assistência Estudantil – PAE, 
 * pelos técnicos administrativos do IFSP, assim como a relação de usuários que 
 * os responderam, com seus dados.
 * 
 * Essa classe é responsável por atribuir a interface gráfica do projeto 
 * (Look and Feel) e por instânciar a primeira tela do sistema: Login.
 * 
 * @author Gislaine Ferreira Gonçalves
 * @author Thiago Henrique Poiani 
 */
public class FormularioIntegrado {
	
	/**
	 * O método principal do sistema
	 */
    public static void main(String args[]) {
    	
    	// tentativa de instanciação do Look and Feel Nimbus
        try {
        	javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        // tratativas de erros
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        // instanciação da classe Login que estende JFrame 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new Login().setVisible(true);
            }
        });
    }
    
}
