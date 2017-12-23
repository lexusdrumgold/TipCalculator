package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.*;

public class TipCalculatorTests {

	@Test
	public void testConstructor() throws IllegalBillAmountException, IllegalTipRateException {
		TipCalculator t = new TipCalculator();
		t.setBillAmount(100);
		t.setTipRate(15);
		t.calculate();
		assertTrue(t.getTotal() == 115);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() throws IllegalBillAmountException, IllegalTipRateException {
		TipCalculator t = new TipCalculator(0, 15);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() throws IllegalBillAmountException, IllegalTipRateException {
		TipCalculator t = new TipCalculator(100, 0);		
	}

}
