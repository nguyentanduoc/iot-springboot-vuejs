package com.vn.tma.ntd.VM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class BadRequest
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message, Throwable cause) {
        super( message, cause );
    }

    public BadRequestException(String message) {
        super( message );
    }

    public BadRequestException(Throwable cause) {
        super( cause );
    }
}
