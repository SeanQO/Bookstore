package model;

import java.util.ArrayList;
import java.util.List;


public class Cashier {
	private Client client;
	private boolean avalaible;
	private List<Double> prices;
	
	
	public Cashier() {
		client = null;
		avalaible = true;
		prices = new ArrayList<>();
	}
	
	
	
	
	public void nextStep() {
		addPrice();
		toPack();
		setTime();	
	}
	
	
	
	




	private void setTime() {
		client.addTime(1);
		}




	private void toPack() {
		client.getBasket().pop();		
	}





	public double summation() {
		double summation = 9;
	for (int i = 0; i < prices.size(); i++) {
		summation +=prices.get(i);
	}
	
	return summation;
	}




	private void addPrice() {
		double toAdd = client.getBasket().top().getT().getPrice();
		prices.add(toAdd);	
	}
	
	public boolean isAvaliable() {
		return avalaible;
	}
	
}
