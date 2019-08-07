package com.example.demo.entity;

import java.io.Serializable;


public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4416539896119324280L;

	private String fid;
	
	private String gid;

    private String name;

    private Integer age;

    private String sex;
    
    private String address;

	public User() {
	
	}

	public User(String fid, String gid, String name, Integer age, String sex, String address) {
		super();
		this.fid = fid;
		this.gid = gid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}
	
	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	@Override
	public String toString() {
		return "User [fid=" + fid + ", gid=" + gid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address="
				+ address + "]";
	}
    
}
