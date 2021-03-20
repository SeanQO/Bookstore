package model;

import java.util.ArrayList;
import java.util.List;
import collections.*;

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
		
	}




	private void addPrice() {
		double toAdd = client.getBasket().top().getT().getPrice();
		prices.add(toAdd);	
	}
	
}
