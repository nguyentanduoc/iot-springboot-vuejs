package com.vn.tma.ntd.VM.dto.response;

import com.vn.tma.ntd.VM.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

/**
 * The Class AuthResponse
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String jwt;
    private Authentication authentication;
}
