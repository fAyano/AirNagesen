package model;

public class Oshi {
	private String name;//(推しの)名前
	private int totalMoney, totalFans;//貢がれた総額、ファンの総数
	private String userName;//作成したUserの名前
	
	public Oshi() {}	
	
	public Oshi(String name, int firstMoney, String userName) {
		this.name = name;
		this.totalMoney = firstMoney;
		this.totalFans = 1;
		this.userName= userName;
	}
	//推しの名前を返す
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//貢がれた総額を返す
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void addTotalMoney(int money) {
		totalMoney += money;
	}
	//ファンの総数を返す
	public int getTotalFans() {
		return totalFans;
	}
	
	public void addTotalFans() {
		totalFans++;
	}
	//推しを作成したユーザー名を返す
	public String getUserName() {
		return userName;
	}
	
}
