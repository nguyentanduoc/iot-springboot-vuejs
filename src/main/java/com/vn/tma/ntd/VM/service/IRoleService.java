package com.vn.tma.ntd.VM.service;

import com.vn.tma.ntd.VM.dto.RoleDTO;
import com.vn.tma.ntd.VM.model.RoleModel;

import java.util.List;
import java.util.Set;

/**
 * The Class IRoleService
 *
 * @author ntduoc
 * @since 6/11/2019
 */
public interface IRoleService {
    RoleModel getRoleUser();

    Set<RoleDTO> findAll();

    List<RoleModel> findByIds(Iterable<Long> ids);
}
