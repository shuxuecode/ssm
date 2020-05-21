package com.zsx.web.entity;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;//
	  
	private String name;//
	  
	private String pwd;//
	  
	public String getId() {
		 return id;
	}
	
	public void setId(String id) {
		 this.id = id;
	}
	
	public String getName() {
		 return name;
	}
	
	public void setName(String name) {
		 this.name = name;
	}
	
	public String getPwd() {
		 return pwd;
	}
	
	public void setPwd(String pwd) {
		 this.pwd = pwd;
	}
	
	
}