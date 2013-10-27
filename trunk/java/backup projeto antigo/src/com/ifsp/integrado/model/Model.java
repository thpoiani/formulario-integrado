package com.ifsp.integrado.model;

public abstract class Model {

	public abstract int getId();
	public abstract void setId(int id);
	
	public abstract void validate();
	
	protected boolean isNotNullOrEmpty(String string) {
		return string != null && !string.isEmpty() && !string.trim().isEmpty();
	}
}
