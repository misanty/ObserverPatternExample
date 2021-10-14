package com.egitim.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egitim.spring.model.Currency;
import com.egitim.spring.model.ICurrencySubject;
import com.egitim.spring.model.IObserver;
import com.egitim.spring.model.PriceChange;

class ObserverTest {

	@Test
	void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		System.out.println(context);

		Currency currency = (Currency) context.getBean("Currency",Currency.class);
		currency.setSymbolName("USDTRY");
		currency.setAskandBidAmount(new BigDecimal("9.17628"),new BigDecimal("9.17302"));
		System.out.println(currency.getSpread());
		
		
		Currency currency2 = context.getBean("Currency", Currency.class);
		currency2.setSymbolName("EURUSD");
		currency2.setAskandBidAmount(new BigDecimal("1.15889"),new BigDecimal("1.15888"));
		System.out.println(currency2.getSpread());
		
		
		PriceChange observer = context.getBean("PriceChange", PriceChange.class);
		observer.setNow(DateTime.now());
		
		PriceChange observer1 = context.getBean("PriceChange", PriceChange.class);
		observer1.setNow(DateTime.now());
		
		
		currency.registerObserver(observer);
		currency2.registerObserver(observer1);
		
		currency.setSpread(observer, new BigDecimal("9.17302"), new BigDecimal("9.17313"));
		System.out.println(currency.getSpread());
		currency2.setSpread(observer1, new BigDecimal("1.15881"), new BigDecimal("1.15886"));
		System.out.println(currency2.getSpread());
		currency2.removeObserver(observer1);;
		
	

	}

}
