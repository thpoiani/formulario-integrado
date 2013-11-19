package formulario.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Categoria extends Model {

    private int id;
    private String titulo;
    private String descricao;
    private boolean status;
    private Date data;
    private int ordem;
    private ArrayList<Formulario> formulario;
    private ArrayList<Campo> campos;

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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
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

    /**
     * @return the ordem
     */
    public int getOrdem() {
        return ordem;
    }

    /**
     * @param ordem the ordem to set
     */
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    /**
     * @return the formulario
     */
    public ArrayList<Formulario> getFormulario() {
        return formulario;
    }

    /**
     * @param formulario the formulario to set
     */
    public void setFormulario(ArrayList<Formulario> formulario) {
        this.formulario = formulario;
    }

    /**
     * @return the campos
     */
    public ArrayList<Campo> getCampos() {
        return campos;
    }

    /**
     * @param campos the campos to set
     */
    public void setCampos(ArrayList<Campo> campos) {
        this.campos = campos;
    }

    @Override
    public boolean validate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
