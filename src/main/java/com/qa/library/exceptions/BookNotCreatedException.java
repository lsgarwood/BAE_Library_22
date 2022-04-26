package com.qa.library.exceptions;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book was not added to the Library")
public class BookNotCreatedException extends EntityExistsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303564533493903909L;

}
