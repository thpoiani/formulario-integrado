package formulario.integrado.model;

public class Login extends Model {
    
    private String prontuario;
    private String senha;

    public Login() {
        super();
    }

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

    @Override
    public boolean validate() {
        if (this.prontuario.isEmpty() || this.prontuario == null ) {
            super.addErrors("prontuario");
        }
        
        if (this.senha.isEmpty() || this.senha == null ) {
            super.addErrors("senha");
        }
        
        return super.getErrors().isEmpty();
    }
    
}
