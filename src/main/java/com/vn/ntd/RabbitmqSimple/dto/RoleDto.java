package com.vn.ntd.RabbitmqSimple.dto;

import com.vn.ntd.RabbitmqSimple.model.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class RoleDto
 *
 * @author ntduoc
 * @since 6/10/2019
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {

    private Long id;
    private RoleName name;
}
