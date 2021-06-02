package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User implements Serializable {
	private String name; //ユーザーの名前
	private String pass; //パスワード
	private int totalMoney; //今まで貢いだ総額
	ArrayList<Oshi> oshi_men = new ArrayList<Oshi>(); //自分が推している推しのリスト
	
	public User(String name,String pass,int totalMoney) {
		this.name = name;
		this.pass = pass;
		this.totalMoney = totalMoney;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void addTotalMoney(int money) {
		totalMoney += money; 
	}
} 
