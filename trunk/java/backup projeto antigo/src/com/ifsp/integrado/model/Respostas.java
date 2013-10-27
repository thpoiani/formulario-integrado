package com.ifsp.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Respostas extends Model {
	private int id;
	private String prontuario;
	private String resposta;
	private Date data;
	private ArrayList<Campo> id_campo;
	private ArrayList<Grupo> id_grupo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProntuario() {
		return prontuario;
	}
	
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	
	public String getResposta() {
		return resposta;
	}
	
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setIdCampo(Campo id_campo) {
		this.id_campo.add(id_campo);
	}
	
	public ArrayList<Campo> getIdCampo() {
		return id_campo;
	}
	
	public void setIdGrupo(Grupo grupo) {
		this.id_grupo.add(grupo);
	}
	
	public ArrayList<Grupo> getIdGrupo() {
		return id_grupo;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
