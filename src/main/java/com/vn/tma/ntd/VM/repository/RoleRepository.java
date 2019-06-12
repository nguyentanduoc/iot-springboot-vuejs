package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.constant.ERoleName;
import com.vn.tma.ntd.VM.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The Class RoleRepository
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(ERoleName roleName);
}
