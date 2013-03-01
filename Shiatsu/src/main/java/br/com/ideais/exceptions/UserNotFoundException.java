package br.com.ideais.exceptions;

public class UserNotFoundException extends Exception {	
	private final static long serialVersionUID = 1;
	
	public UserNotFoundException(){
	}

	public UserNotFoundException(String msg){	
		super(msg);
	}
	
}	