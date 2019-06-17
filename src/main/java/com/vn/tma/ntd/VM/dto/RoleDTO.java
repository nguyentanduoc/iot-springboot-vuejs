package com.vn.tma.ntd.VM.dto;

import com.vn.tma.ntd.VM.constant.ERoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * The Class RoleDto
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RoleDTO {
    private Long id;
    private ERoleName name;
}
