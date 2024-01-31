package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;

	private String sname;

	private double smarks;

	Student() {

	}

	public Student(int sid, String sname, double smarks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.smarks = smarks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", smarks=" + smarks + "]";
	}

}
