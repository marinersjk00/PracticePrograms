package jskusch;


public class Restaurant {

	protected int fruit_stock;
	protected int veg_stock;
	protected int meat_stock;
	protected int dairy_stock;
	protected double budget;
	protected double income;
	
	
	Restaurant(){}
	
	Restaurant(int fruit, int veg, int meat, int dairy, double budget, double income){
		this.fruit_stock = fruit;
		this.veg_stock = veg;
		this.meat_stock = meat;
		this.dairy_stock = dairy;
		this.budget = budget;
		this.income = income;
	}
	
	public int getFruit() {
		return fruit_stock;
	}
	
	public void setFruit(int fruit) {
		this.fruit_stock = fruit;
	}
	
	public int getVeg() {
		return veg_stock;
	}
	
	public void setVeg(int veg) {
		this.veg_stock = veg;
	}
	
	public int getMeat() {
		return meat_stock;
	}
	
	public void setMeat(int meat) {
		this.meat_stock = meat;
	}
	
	public int getDairy() {
		return dairy_stock;
	}
	
	public void setDairy(int dairy) {
		this.dairy_stock = dairy;
	}
	
	public double getBudget() {
		return budget;
	}
	
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public double getIncome() {
		return income;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
}
