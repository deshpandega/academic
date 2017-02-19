/**
 * 
 */
package com.neu.gd.exception;

/**
 * @author GD
 *
 */
public class UserDefinedException extends Exception {
	public UserDefinedException(String message){
		super(message);
	}
	
	public UserDefinedException(String message, Throwable cause){
		super(message, cause);
	}
}