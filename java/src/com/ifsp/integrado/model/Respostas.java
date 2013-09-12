package com.ifsp.integrado.model;

import java.util.Date;
import java.util.List;

public class Respostas {
	private int id;
	private String prontuario;
	private String resposta;
	private Date data;
	private List<Campo> id_campo;
	private List<Grupo> id_grupo;
	
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
	
	public List<Campo> getIdCampo() {
		return id_campo;
	}
	
	public void setIdCampo(List<Campo> id_campo) {
		this.id_campo = id_campo;
	}
	
	public List<Grupo> getIdGrupo() {
		return id_grupo;
	}
	
	public void setIdGrupo(List<Grupo> id_grupo) {
		this.id_grupo = id_grupo;
	}
}
