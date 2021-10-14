package com.egitim.spring.model;

import java.math.BigDecimal;

public interface IObserver {

	public void update(IObserver observer, String currencyName, BigDecimal spread);

	

}
