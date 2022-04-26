package com.qa.library.exceptions;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Your Book update was not successful")
public class BookUpdateNotSuccessfulException extends EntityExistsException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8564979765356740874L;

}
