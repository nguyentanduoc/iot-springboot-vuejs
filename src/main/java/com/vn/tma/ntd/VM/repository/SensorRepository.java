package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.model.SensorModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface SensorRepository extends PagingAndSortingRepository<SensorModel, String> {

    List<SensorModel> findAllByUserModel_Id(Long id, Pageable pageable);

    Long countAllByUserModel_Id(Long userId);
}
