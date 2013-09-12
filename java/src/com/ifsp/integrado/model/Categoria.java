package com.ifsp.integrado.model;

import java.util.Date;
import java.util.List;

public class Categoria {
	private int id;
	private String titulo;
	private String descricao;
	private char status;
	private Date data;
	private List<Formulario> id_formulario;
	
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
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	public List<Formulario> getFormulario() {
		return id_formulario;
	}
	
	public void setFormulario(List<Formulario> id_formulario) {
		this.id_formulario = id_formulario;
	}
}
