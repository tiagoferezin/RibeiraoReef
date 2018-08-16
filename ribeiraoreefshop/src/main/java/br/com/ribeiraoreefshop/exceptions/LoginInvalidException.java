/**
 * 
 */
package br.com.ribeiraoreefshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin
 * Data: 15/08/2018
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class LoginInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2199372442442505729L;

}
