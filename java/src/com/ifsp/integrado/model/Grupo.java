package com.ifsp.integrado.model;

import java.util.Date;
import java.util.List;

public class Grupo {
	private int id;
	private String titulo;
	private char tipo;
	private Date data;
	private List<Campo> id_campo;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
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
}
