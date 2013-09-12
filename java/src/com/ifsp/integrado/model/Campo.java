package com.ifsp.integrado.model;

import java.util.Date;
import java.util.List;

public class Campo {
	private int id;
	private String titulo;
	private int maxlength;
	private String regex;
	private char tipo;
	private char status;
	private Date data;
	private List<Categoria> id_categoria;

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
	
	public int getMaxlength() {
		return maxlength;
	}
	
	public void setMaxlength(int maxlength) {
		this.maxlength = maxlength;
	}
	
	public String getRegex() {
		return regex;
	}
	
	public void setRegex(String regex) {
		this.regex = regex;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Categoria> getIdCategoria() {
		return id_categoria;
	}
	
	public void setIdCategoria(List<Categoria> id_categoria) {
		this.id_categoria = id_categoria;
	}	
}
