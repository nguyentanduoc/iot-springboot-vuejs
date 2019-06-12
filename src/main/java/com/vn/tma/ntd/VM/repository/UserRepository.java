package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The Class UserRepository
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsernameOrEmail(String username, String email);
}
