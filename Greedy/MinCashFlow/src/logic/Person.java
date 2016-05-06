package logic;

public class Person {
	private int money;
	private String name;
	
	public Person(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
