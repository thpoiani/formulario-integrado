package formulario.integrado.model;

import java.util.Date;
import java.util.List;

public class Campo extends Model {
    
    private int id;
    private String titulo;
    private int maxlength;
    private String regex;
    private boolean status;
    private int ordem;
    private Date data;
    
    private List<Grupo> grupos;
    
    private int categoriaId;
    private Categoria categoria;
    
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
     * @return the maxlength
     */
    public int getMaxlength() {
        return maxlength;
    }

    /**
     * @param maxlength the maxlength to set
     */
    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    /**
     * @return the regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex the regex to set
     */
    public void setRegex(String regex) {
        this.regex = regex;
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
     * @return the categoriaId
     */
    public int getCategoriaId() {
        return categoriaId;
    }

    /**
     * @param categoriaId the categoriaId to set
     */
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
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
        
        if (this.maxlength > 99999) {
            super.addErrors("maxlength");
        }
        
        return super.getErrors().isEmpty();
    }
        
}
