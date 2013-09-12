package com.ifsp.integrado.model;

import java.util.Date;
import java.util.List;

public class Formulario {
	private int id;
	private String titulo;
	private String cabecalho;
	private String rodape;
	private char status;
	private char aberto;
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
	
	public String getCabecalho() {
		return cabecalho;
	}
	
	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}
	
	public String getRodape() {
		return rodape;
	}
	
	public void setRodape(String rodape) {
		this.rodape = rodape;
	}
	
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public char getAberto() {
		return aberto;
	}
	
	public void setAberto(char aberto) {
		this.aberto = aberto;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Categoria> getCategoria() {
		return id_categoria;
	}
	
	public void setCategoria(List<Categoria> id_categoria) {
		this.id_categoria = id_categoria;
	}
}
