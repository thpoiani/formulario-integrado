package com.ifsp.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Categoria {
	private int id;
	private String titulo;
	private String descricao;
	private char status;
	private Date data;
	private ArrayList<Formulario> id_formulario;
	
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

	public void setIdFormulario(Formulario formulario) {
		this.id_formulario.add(formulario);
	}
	
	public ArrayList<Formulario> getIdFormulario() {
		return id_formulario;
	}
}
