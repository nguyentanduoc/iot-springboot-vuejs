package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The Class UserRepository
 *
 * @author ntduoc
 * @since 6/11/2019
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
    Optional<UserModel> findByUsernameOrEmail(String username, String email);

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    @Query("SELECT COUNT(u) FROM UserModel u")
    Long countAll();
//    List<UserModel> findAllWithPageAble(Pageable pageable);
}
