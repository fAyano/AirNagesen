package model;

import java.util.ArrayList;
import java.util.List;

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
	//ユーザーの名前を返す
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//パスワードを返す
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	//ユーザーが今までに貢いだ総額を返す
	public int getTotalMoney() {
		return totalMoney;
	}
	//ユーザーが今までに推してきた推しを返す
	public List<Oshi> getOshiMen(){
		return oshiMen;
	}
	
	public void addTotalMoney(int money) {
		totalMoney += money; 
	}
	
	public void addNewOshi(Oshi newOshi) {
		oshiMen.add(newOshi);
	}
	
	public void removeOshi(int index) {
		oshiMen.remove(index);
	}
	
} 
