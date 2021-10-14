package com.egitim.spring.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import org.springframework.context.annotation.Scope;


public class Currency implements ICurrencySubject {
	
	
	
	private List<IObserver> observers = new ArrayList();
	
	private String symbolName;
	private BigDecimal bidAmount;
	private BigDecimal askAmount;
	

	private BigDecimal spread;
	private IObserver observer;
	
	

	public Currency() {
		
	}
	


	public Currency(String symbolName) {
		
		this.symbolName = symbolName;
		
		
	}
	
	public BigDecimal setSpread(BigDecimal bidAmount, BigDecimal askAmount) {
		return askAmount.subtract(bidAmount);
	}
	
	public String getSymbolName() {
		return symbolName;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}

	public BigDecimal getSpread() {
		return spread;
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
		System.out.println("-------------------------"+observer+" is no longer applicable -------------------------");
		
	}

	@Override
	public void notifyObservers() {
		  System.out.println("-----------------It seems like a good trade----------------");
	        for (IObserver ob : observers) {
	            ob.update(this.observer,this.symbolName,this.getSpread());
	        }
	        
		
	}

	@Override
	public void setSpread(IObserver observer, BigDecimal newBidAmount, BigDecimal newAskAmount) {
		int diff = getSpread().compareTo(setSpread(newAskAmount, newBidAmount));
		if(diff == 1) {
			this.observer = observer;
			this.spread = setSpread(newAskAmount, newBidAmount);
			notifyObservers();
			
		}else if(diff == -1) {
			System.out.println("Spread is way too big, stay away!");
		}
		
	}

	public BigDecimal getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}

	public BigDecimal getAskAmount() {
		return askAmount;
	}

	public void setAskandBidAmount(BigDecimal askAmount, BigDecimal bidAmount) {
		this.askAmount = askAmount;
		this.bidAmount = bidAmount;
		this.spread = setSpread(askAmount, bidAmount);
		
	}

}
