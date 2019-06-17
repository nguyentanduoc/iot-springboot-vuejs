package com.vn.tma.ntd.VM.service.impl;

import com.vn.tma.ntd.VM.model.MenuModel;
import com.vn.tma.ntd.VM.repository.MenuRepository;
import com.vn.tma.ntd.VM.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * The Class MenuService
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuModel> findAll() {
        return menuRepository.findAll();
    }
}
