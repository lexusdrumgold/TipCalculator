package model;

public class IllegalBillAmountException extends Exception {
	String errorText;
	public IllegalBillAmountException(String errorText) {
		this.errorText = errorText;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7323713121440496631L;

}
