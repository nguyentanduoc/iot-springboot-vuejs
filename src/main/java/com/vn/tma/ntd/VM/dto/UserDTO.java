package com.vn.tma.ntd.VM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * The Class UserDto
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String username;
    private Set<RoleDTO> roles;
    private Set<Long> roleIds;
    private Set<MenuDTO> menuDTOS;
}
