package com.ifsp.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Grupo {
	private int id;
	private String titulo;
	private char tipo;
	private Date data;
	private ArrayList<Campo> id_campo;

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
	
	public void setIdCampo(Campo campo) {
		this.id_campo.add(campo);
	}
	
	public ArrayList<Campo> getIdCampo() {
		return id_campo;
	}
	
}
