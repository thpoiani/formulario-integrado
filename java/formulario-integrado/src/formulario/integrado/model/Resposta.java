package formulario.integrado.model;

import java.util.Date;

public class Resposta extends Model {
    
    private int alunoId;
    private int formularioId;
    private int campoId;
    private String resposta;
    private Date data;

    /**
     * @return the alunoId
     */
    public int getAlunoId() {
        return alunoId;
    }

    /**
     * @param alunoId the alunoId to set
     */
    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getFormularioId() {
        return formularioId;
    }

    public void setFormularioId(int formularioId) {
        this.formularioId = formularioId;
    }
    
    /**
     * @return the campoId
     */
    public int getCampoId() {
        return campoId;
    }

    /**
     * @param campoId the campoId to set
     */
    public void setCampoId(int campoId) {
        this.campoId = campoId;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean validate() {
        if (this.resposta.isEmpty() || this.resposta == null ) {
            super.addErrors("titulo");
        }
        
        return super.getErrors().isEmpty();
    }
}
