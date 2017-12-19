import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class where you can run the tip calculator program. 
 * @author LexusDrumgold
 */
public class TipCalculatorDriver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TipCalculator tipCalculator;
		double billAmount = 0, percentage = 0;
		
		System.out.println("Welcome to the tip calculator.");
		System.out.println("What is the bill amount?");
		try {
			billAmount = input.nextDouble();
			if (billAmount < 0) {
				System.out.println("Enter a number greater than or equal to 0.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid number.");
		}
		System.out.println("What is the tip rate?");
		try {
			percentage = input.nextDouble();
			if (percentage < 0) {
				System.out.println("Enter a number greater than or equal to 0.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid number.");
		}
		input.close();
		
		System.out.println("Calculating tip...");
		tipCalculator = new TipCalculator(billAmount, percentage);
		tipCalculator.calculate();
		System.out.println(tipCalculator.toString());
	}

}
