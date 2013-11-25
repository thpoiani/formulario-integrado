package formulario.integrado.model;

import java.util.Objects;

public class Tipo extends Model {
    
    private int id;
    private String descricao;

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

    @Override
    public boolean validate() {
        if (this.descricao.isEmpty() || this.descricao == null ) {
            super.addErrors("descricao");
        } else {
            if (this.descricao.length() > 10) {
                super.addErrors("descricao");
            }
        }
        
        return super.getErrors().isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return this.descricao;
    }
}
