package com.KafkaExample;

import java.io.Serializable;

public class Customer implements Serializable{

	private int id;
	private String name;
	private String category;


	private String addr;

    public Customer()
    {
     super();
    }
	public Customer(int id, String name, String addr, String category) {
		
		this.id = id;
		this.name = name;
		this.addr=addr;
		this.category=category;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}

