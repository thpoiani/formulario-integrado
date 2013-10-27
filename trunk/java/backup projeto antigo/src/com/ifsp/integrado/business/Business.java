package com.ifsp.integrado.business;

import com.ifsp.integrado.model.Model;

public class Business implements IBusiness {
	
	private Model model;
	
	public Business(Model model) {
		this.model = model;
	}
	
	public void save() {
		if (this.model.getId() > 0) {
			update();
		} else {
			create();
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
