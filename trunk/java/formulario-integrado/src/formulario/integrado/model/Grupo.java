package formulario.integrado.model;

import java.util.Date;

public class Grupo extends Model {
    
    private int id;
    private String titulo;
    private Date data;
    private int ordem;
    private boolean status;
    
    private int campoId;
    private Campo campo;

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCampoId() {
        return campoId;
    }

    public void setCampoId(int campoId) {
        this.campoId = campoId;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
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
