package com.vn.ntd.RabbitmqSimple.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class AppServiceErrorAdvice
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@ControllerAdvice
@Slf4j
public class AppServiceErrorAdvice {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiError> handleRunTimeException(RuntimeException e) {
        ApiError apiError = new ApiError();
        apiError.setHttpStatus( HttpStatus.INTERNAL_SERVER_ERROR );
        apiError.setMessage( e.getMessage() );
        return new ResponseEntity<>( apiError, apiError.getHttpStatus() );
    }

    @ExceptionHandler({ApiError.class})
    public ResponseEntity<ApiError> handleApiError() {
        ApiError apiError = new ApiError();
        return new ResponseEntity<>( apiError, apiError.getHttpStatus() );
    }
}
