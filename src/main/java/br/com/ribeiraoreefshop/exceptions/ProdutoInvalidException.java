/**
 * 
 */
package br.com.ribeiraoreefshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tiago Ferezin
 * Data: 18/08/2018
 */
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class ProdutoInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -291565291226355453L;

}
