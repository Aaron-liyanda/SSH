package com.wcj.entity;

import java.io.Serializable;
import java.util.Date;

public class Hero  implements Serializable{
	Integer id;
	String name;
	String nickname;
	char sex;
	String first;
	String second;
	String Q;
	String W;
	String  E;
	String R;
	String passivity;
	String img;
	//Date birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}
	public String getQ() {
		return Q;
	}
	public void setQ(String q) {
		Q = q;
	}
	public String getW() {
		return W;
	}
	public void setW(String w) {
		W = w;
	}
	public String getE() {
		return E;
	}
	public void setE(String e) {
		E = e;
	}
	public String getR() {
		return R;
	}
	public void setR(String r) {
		R = r;
	}
	public String getPassivity() {
		return passivity;
	}
	public void setPassivity(String passivity) {
		this.passivity = passivity;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
//	public Date getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
	public Hero(Integer id, String name, String nickname, char sex, String first, String second, String q, String w,
			String e, String r, String passivity, String img) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.sex = sex;
		this.first = first;
		this.second = second;
		Q = q;
		W = w;
		E = e;
		R = r;
		this.passivity = passivity;
		this.img = img;
		//this.birthday = birthday;
	}
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	

}
