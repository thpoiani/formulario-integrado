package formulario.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Formulario extends Model {
    
    private int id;
    private String titulo;
    private boolean aberto;
    private boolean status;
    private Date data;
    private ArrayList<Categoria> categorias;

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
     * @return the aberto
     */
    public boolean isAberto() {
        return aberto;
    }

    /**
     * @return the aberto
     */
    public String getAberto() {
        return aberto ? "Sim" : "Não";
    }
    
    /**
     * @param aberto the aberto to set
     */
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
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
     * @return the categorias
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean validate() {
        if (this.titulo.isEmpty() || this.titulo == null ) {
            super.addErrors("titulo");
        } else {
            if (this.titulo.length() > 100) {
                super.addErrors("titulo");
            }
        }
        
        return super.getErrors().isEmpty();
    }
}
