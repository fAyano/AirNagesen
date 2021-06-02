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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void addTotalMoney(int money) {
		totalMoney += money;
	}
	
	public int getTotalFans() {
		return totalFans;
	}
	
	public void addTotalFans() {
		totalFans++;
	}
	
	public String getUserName() {
		return userName;
	}
	
}
