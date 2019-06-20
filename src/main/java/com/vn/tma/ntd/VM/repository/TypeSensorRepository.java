package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.model.TypeSensorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Class TypeSensorRepository
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@Repository
public interface TypeSensorRepository extends JpaRepository<TypeSensorModel, Long> {
}
