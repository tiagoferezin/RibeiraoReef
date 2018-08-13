/**
 * 
 */
package br.com.ribeiraoreefshop.controleHorario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin Data: 10/08/2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class HorarioInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5735123051930089616L;

}
