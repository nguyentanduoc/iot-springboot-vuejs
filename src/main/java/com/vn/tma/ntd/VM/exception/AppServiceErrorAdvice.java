package com.vn.tma.ntd.VM.exception;

import com.vn.tma.ntd.VM.security.JwtAuthenticationEntryPoint;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class AppServiceErrorAdvice
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Slf4j
@ControllerAdvice
public class AppServiceErrorAdvice {
    private static final Logger logger = LoggerFactory.getLogger( AppServiceErrorAdvice.class );

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiError> handleRunTimeException(RuntimeException e) {
        logger.error( e.getMessage() );
        ApiError apiError = new ApiError();
        apiError.setHttpStatus( HttpStatus.INTERNAL_SERVER_ERROR );
        apiError.setMessage( e.getMessage() );
        return new ResponseEntity<>( apiError, apiError.getHttpStatus() );
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BadRequestException> handleBadRequestException(BadRequestException e) {
        return new ResponseEntity<>( e, HttpStatus.BAD_REQUEST );
    }

    @ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
    public ResponseEntity<Exception> handleBadCredentialsException(Exception e) {
        return new ResponseEntity<>( e, HttpStatus.BAD_REQUEST );
    }
}
