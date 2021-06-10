package model;

import java.util.ArrayList;

public class User  {
	private String name; //ユーザーの名前
	private String pass; //パスワード
	private int totalMoney; //今まで貢いだ総額
	ArrayList<Oshi> oshiMen;  //自分が推している推しのリスト
	
	public User(String name,String pass) {
		this.name = name;
		this.pass = pass;
		this.totalMoney = 0;
		oshiMen = new ArrayList<Oshi>();
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
	
	public void addNewOshi(Oshi newOshi) {
		oshiMen.add(newOshi);
	}
	
	public ArrayList<Oshi> getNewOshi() {
		return oshiMen;
	}
} 
