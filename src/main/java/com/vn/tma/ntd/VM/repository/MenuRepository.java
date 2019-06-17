package com.vn.tma.ntd.VM.repository;

import com.vn.tma.ntd.VM.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Class MenuRepository
 *
 * @author ntduoc
 * @since 6/17/2019
 */
public interface MenuRepository extends JpaRepository<MenuModel, Long> {
}
