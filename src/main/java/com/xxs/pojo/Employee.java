package com.xxs.pojo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer eid;
	private String name;
	private char sex;
	private Date birthday;
	private double salary;
	private String hobby;
	private Date registerTime;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", salary="
				+ salary + ", hobby=" + hobby + ", registerTime=" + registerTime + "]";
	}
	
	
}
