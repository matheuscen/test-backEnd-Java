package br.com.uol.exception;

public class PlayerNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6905901700876842099L;

	public PlayerNotFoundException(String message) {
		super(message);
	}

}
