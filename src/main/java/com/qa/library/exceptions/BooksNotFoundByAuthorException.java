package com.qa.library.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Books by that Author were not found in the Library")
public class BooksNotFoundByAuthorException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3347535430189434914L;

}
