package com.vn.tma.ntd.VM.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * The Class ApiError
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiError extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;
}
