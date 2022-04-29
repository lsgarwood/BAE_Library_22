package com.qa.library.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book with that Id was not found in the Library")
public class BookNotFoundWithIdException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7067533613313445160L;

}
