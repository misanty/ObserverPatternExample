package com.egitim.spring.model;

import java.math.BigDecimal;

public interface ICurrencySubject {

	public void registerObserver(IObserver observer);

	public void removeObserver(IObserver observer);

	public void notifyObservers();

	public void setSpread(IObserver observer, BigDecimal newBidAmount, BigDecimal newAskAmount);

}
