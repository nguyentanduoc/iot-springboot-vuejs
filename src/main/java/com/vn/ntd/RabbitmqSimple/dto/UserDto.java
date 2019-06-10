package com.vn.ntd.RabbitmqSimple.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * The Class UserDto
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String username;
    private Set<RoleDto> roles;
}
