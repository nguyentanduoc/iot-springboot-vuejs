package com.vn.ntd.RabbitmqSimple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class AuthenticationDto
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSubmit {

    private String username;

    private String password;
}
