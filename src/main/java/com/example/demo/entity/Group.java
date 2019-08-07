package com.example.demo.entity;

import java.io.Serializable;

public class Group implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -8832170371568161605L;

	private String id;

    private String name;
    
    public Group() {
		super();
	}

	public Group(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

    
}
