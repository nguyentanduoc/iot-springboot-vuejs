package com.vn.ntd.RabbitmqSimple.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * The Class ApiError
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
}
