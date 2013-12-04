package formulario.integrado.model;

import java.util.ArrayList;

public class Aluno extends Model {
    private int id;
    private String prontuario;
    private String nome;
    private String email;
    
    private ArrayList<Resposta> respostas;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the respostas
     */
    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    /**
     * @param respostas the respostas to set
     */
    public void setRespostas(ArrayList<Resposta> respostas) {
        this.respostas = respostas;
    }

    @Override
    public boolean validate() {
        if (this.prontuario.isEmpty() || this.prontuario == null ) {
            super.addErrors("prontuario");
        } else {
            if (this.prontuario.length() > 10) {
                super.addErrors("prontuario");
            }
        }
        
        if (this.nome.isEmpty() || this.nome == null ) {
            super.addErrors("nome");
        } else {
            if (this.nome.length() > 10) {
                super.addErrors("nome");
            }
        }
        
        return super.getErrors().isEmpty();
    }
}
