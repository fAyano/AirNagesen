package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Oshi implements Serializable{
	private String name;
	private int totalMoney, totalFans;
	
	public Oshi() {}
	
	public Oshi(String name) {
		this.name = name;
		totalMoney = 0;
		totalFans = 1;
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
	
	
}
