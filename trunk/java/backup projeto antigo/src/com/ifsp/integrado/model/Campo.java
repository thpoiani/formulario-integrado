package com.ifsp.integrado.model;

import java.util.ArrayList;
import java.util.Date;

public class Campo extends Model {
	
	private int id;
	private String titulo;
	private int maxlength;
	private String regex;
	private char tipo;
	private char status;
	private Date data;
	private ArrayList<Categoria> id_categoria;

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

	public void setIdCategoria(Categoria categoria) {
		this.id_categoria.add(categoria);
	}
	
	public ArrayList<Categoria> getIdCategoria() {
		return id_categoria;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @param Campo campo Novo objeto após assemblyRequest()
	 * @return
	 */
	public Campo mergeObjects(Campo campo) {
		int id        = campo.getId();
		String titulo = campo.getTitulo();
		int maxlength = campo.getMaxlength();
		String regex  = campo.getRegex();
		char tipo     = campo.getTipo();
		char status   = campo.getStatus();
		Date data     = campo.getData();
		
		if (this.isNotNullOrEmpty(String.valueOf(id)) && id != 0) {
			this.id = id;
		}
		
		if (this.isNotNullOrEmpty(titulo)) {
			this.titulo = titulo;
		}
		
		if (this.isNotNullOrEmpty(String.valueOf(maxlength)) && maxlength != 0) {
			this.maxlength = maxlength;
		}
		
		if (this.isNotNullOrEmpty(regex)) {
			this.regex = regex;
		}
		
		if (this.isNotNullOrEmpty(String.valueOf(tipo))) {
			this.tipo = tipo;
		}
		
		if (this.isNotNullOrEmpty(String.valueOf(status))) {
			this.status = status;
		}
		
		if (this.isNotNullOrEmpty(data.toString())) {
			this.data = data;
		}
		
		return campo;
	}
		
}
