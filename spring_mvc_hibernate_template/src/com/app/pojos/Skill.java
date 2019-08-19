package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skill {
	
	private int sid;
	private String skill;
	
	public Skill() {
		System.out.println("in constr of "+getClass().getName());
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	@Override
	public String toString() {
		return "Skill [sid=" + sid + ", skill=" + skill + "]";
	}

}
