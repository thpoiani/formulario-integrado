package formulario.integrado.model;

public class Login implements IModel {
    
    private String prontuario;
    private String senha;
    
    private static boolean session;

    /**
     * @return the prontuario
     */
    public String getProntuario() {
        return prontuario;
    }

    /**
     * @param prontuario the prontuario to set
     */
    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Método para verificar se usuário está logado em sessão autorizada
     * @return boolean
     */
    public static boolean Session() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
