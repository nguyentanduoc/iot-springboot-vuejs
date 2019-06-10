package com.vn.ntd.RabbitmqSimple.repository;

import com.vn.ntd.RabbitmqSimple.model.RoleModel;
import com.vn.ntd.RabbitmqSimple.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(RoleName roleName);
}
