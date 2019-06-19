package com.vn.tma.ntd.VM.dto.request;

import com.vn.tma.ntd.VM.dto.RoleDTO;
import com.vn.tma.ntd.VM.model.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * The Class AccountEditSubmit
 *
 * @author ntduoc
 * @since 6/19/2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEditSubmit {

    private Long id;
    private String email;
    private String username;
    private String name;
    private Iterable<Long> roleIds;
}
