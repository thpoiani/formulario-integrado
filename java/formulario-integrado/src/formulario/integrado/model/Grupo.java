package formulario.integrado.model;

import java.util.Date;

public class Grupo extends Model {
    
    private int id;
    private String titulo;
    private Date data;
    
    private int campoId;
    private Campo campo;
    
    private int tipoId;
    private Tipo tipo;

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
     * @return the campo
     */
    public Campo getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    /**
     * @return the tipoId
     */
    public int getTipoId() {
        return tipoId;
    }

    /**
     * @param tipoId the tipoId to set
     */
    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo.getDescricao();
    }
    
    public Tipo getTipoModel() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean validate() {
        if (this.titulo.isEmpty() || this.titulo == null ) {
            super.addErrors("titulo");
        } else {
            if (this.titulo.length() > 50) {
                super.addErrors("titulo");
            }
        }
        
        return super.getErrors().isEmpty();
    }
}
