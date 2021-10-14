package com.egitim.spring.model;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;



public class PriceChange implements IObserver {

	private DateTime now;
	private String currencyName;

	public PriceChange(String currencyName) {
		this.currencyName = currencyName;
		setNow(now);
	}
	
	public PriceChange() {
		setNow(now);
	}
	
	@Override
	public void update(IObserver observer, String currencyName, BigDecimal spread) {
		if (observer.toString().equals(currencyName)) {
			System.out.println("New spread is " + spread + " of " + observer + " on " + getNow());
		} else {
			System.out.println("New spread is " + spread + " of " + observer + " on " + getNow());
		}
		

	}

	public DateTime getNow() {
		return now;
	}

	public void setNow(DateTime now) {
		this.now = now != null ? now : DateTime.now();
	}

	@Override
	public boolean equals(Object obj) {
		
		return getNow().isAfterNow();
	}

	@Override
	public String toString() {
		
		return this.currencyName;
	}

	
}
