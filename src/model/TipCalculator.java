package model;
import java.text.NumberFormat;

/**
 * TipCalculator class. Computes the tip and total bill amount. 
 * @author LexusDrumgold
 */
public class TipCalculator {
	private double billAmount, rate, tipAmount;
	String total;
	
	/**
	 * Creates a new TipCalculator object
	 */
	public TipCalculator() {
		//nothing to do
	}
	
	/**
	 * Creates a new TipCalculator object with the specified parameters
	 * @param billAmount
	 * @param percentage
	 * @throws IllegalBillAmountException 
	 */
	public TipCalculator(double billAmount, double rate) throws IllegalBillAmountException, IllegalTipRateException {
		try {
			this.billAmount = validateBillAmount(billAmount);
			this.rate = validateTipRate(rate);
		} catch (IllegalBillAmountException billException) {
			throw new IllegalArgumentException("Enter a bill amount greater than $0.00.");
		} catch (IllegalTipRateException tipException) {
			throw new IllegalArgumentException("Enter a tip rate greater than 5%.");
		}
	}
	
	/**
	 * Sets the bill amount to the parameter. Throws exception if the
	 * parameter is less than 0
	 * @param billAmount
	 * @throws IllegalArgumentException
	 */
	public void setBillAmount(double billAmount) throws IllegalBillAmountException {
		this.billAmount = validateBillAmount(billAmount);
	}
	
	/**
	 * Sets the tip rate to the parameter. Throws exception if the
	 * parameter is less than 5
	 * @param percentage
	 * @throws IllegalArgumentException
	 */
	public void setTipRate(double rate) throws IllegalTipRateException {
		this.rate = validateTipRate(rate);
	}
	
	/**
	 * Calculates the tip and updates total.
	 * @return double representing the new total
	 */
	public double calculate() {
		double multiplier = 0.01 * rate;
		tipAmount = billAmount * multiplier;
		total = format(billAmount + tipAmount);
		return billAmount + tipAmount;
	}
	
	/**
	 * Returns the tip amount
	 * @return double representing the tip amount
	 */
	public double getTipAmount() {
		return tipAmount;
	}
	
	/**
	 * Returns the total.
	 * @return double representing the total
	 */
	public double getTotal() {
		if (total != null) {
			return calculate();
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Tip: " + format(tipAmount) + "\nTotal: " + total;
	}
	
	/**
	 * Checks if the bill amount is greater than 0. 
	 * If not, an exception will be be thrown
	 * @param billAmount
	 * @return double representing the bill amount (if a valid amount was input)
	 * @throws IllegalBillAmountException
	 */
	private double validateBillAmount(double billAmount) throws IllegalBillAmountException {
		if (billAmount <= 0) {
			throw new IllegalBillAmountException("Please enter a bill greater than $0.00.");
		} else {
			return billAmount;
		}
	}
	
	/**
	 * Checks if the tip rate is greater than 5. 
	 * If not, an exception will be be thrown
	 * @param billAmount
	 * @return double representing the rate (if a valid rate was input)
	 * @throws IllegalTipRateException
	 */
	private double validateTipRate(double rate) throws IllegalTipRateException {
		if (rate < 5) {
			throw new IllegalTipRateException("Please enter a tip rate greater than 5%.");
		} else {
			return rate;
		}
	}
	
	/**
	 * Returns a string in a currency format. 
	 * Here solely for readability. 
	 * @param convert
	 * @return string representing double in a currency format
	 */
	public static String format(double convert) {
		return NumberFormat.getCurrencyInstance().format(convert);
	}
}
