package com.vn.tma.ntd.VM.dto.response;

import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.model.UserPrincipal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UserDTO userDTO;
}
