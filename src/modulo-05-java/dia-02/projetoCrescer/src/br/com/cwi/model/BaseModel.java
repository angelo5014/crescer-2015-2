package br.com.cwi.model;

public abstract class BaseModel {
	protected Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
}
