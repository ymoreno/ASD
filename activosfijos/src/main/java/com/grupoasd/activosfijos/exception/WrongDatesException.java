package com.grupoasd.activosfijos.exception;

public class WrongDatesException extends RuntimeException {
	      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		// Parameterless Constructor
	      public WrongDatesException() {}

	      // Constructor that accepts a message
	      public WrongDatesException(String message)
	      {
	         super(message);
	      }
}
