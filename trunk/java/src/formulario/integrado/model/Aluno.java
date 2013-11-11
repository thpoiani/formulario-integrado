package formulario.integrado.model;

import java.util.ArrayList;

public class Aluno {
    private int id;
    private String prontuario;
    private String nome;
    
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
}
