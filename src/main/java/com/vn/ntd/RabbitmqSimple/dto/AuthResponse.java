package com.vn.ntd.RabbitmqSimple.dto;

import com.vn.ntd.RabbitmqSimple.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AuthResponse
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {

    private String jwt;
    private UserDto user;
}
