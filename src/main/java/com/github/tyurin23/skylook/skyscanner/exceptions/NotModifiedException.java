package com.github.tyurin23.skylook.skyscanner.exceptions;

/**
 * Created by Y. Tyurin <tyurin23@gmail.com> on 01.03.17.
 */
public class NotModifiedException extends RuntimeException {

	public NotModifiedException() {
		this(null);
	}

	public NotModifiedException(String message) {
		super(message, null, true, false);
	}
}
