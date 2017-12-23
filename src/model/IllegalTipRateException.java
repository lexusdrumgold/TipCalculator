package model;

public class IllegalTipRateException extends Exception {
	String errorText;
	public IllegalTipRateException(String errorText) {
		this.errorText = errorText;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3087145057419302413L;
}
