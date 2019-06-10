package com.vn.ntd.RabbitmqSimple.repository;

import com.vn.ntd.RabbitmqSimple.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsernameOrEmail(String username, String email);
}
