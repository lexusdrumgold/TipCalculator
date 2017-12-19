import java.text.NumberFormat;

/**
 * TipCalculator class. Computes the tip and total bill amount. 
 * @author LexusDrumgold
 */
public class TipCalculator {
	private double billAmount, percentage;
	String tipAmount, total;
	
	/**
	 * Initializes a new TipCalculator object
	 * @param billAmount
	 * @param percentage
	 */
	public TipCalculator(double billAmount, double percentage) {
		this.billAmount = billAmount;
		this.percentage = percentage;
	}
	
	/**
	 * Calculates the tip and total bill. 
	 */
	public void calculate() {
		double tipMultiplier = 0.01 * percentage;
		tipAmount = format(billAmount * tipMultiplier);
		total = format(billAmount + (billAmount * tipMultiplier));
	}
	
	@Override
	public String toString() {
		return "Tip: " + tipAmount + "\nTotal: " + total;
	}
	
	/**
	 * Returns a string in a currency format. 
	 * Here soley for readability. 
	 * @param convert
	 * @return string representing double in a currency format
	 */
	private String format(double convert) {
		return NumberFormat.getCurrencyInstance().format(convert);
	}
}
