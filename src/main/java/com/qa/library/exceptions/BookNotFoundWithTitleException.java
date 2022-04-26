package com.qa.library.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book with that Title was not found in the Library")
public class BookNotFoundWithTitleException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3307781245671785738L;

}
