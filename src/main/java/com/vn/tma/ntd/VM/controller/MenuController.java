package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.dto.MenuDTO;
import com.vn.tma.ntd.VM.service.impl.MenuService;
import com.vn.tma.ntd.VM.transfer.MenuTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * The Class MenuController
 *
 * @author ntduoc
 * @since 6/17/2019
 */
@RestController
@RequestMapping(path = "/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuTransfer menuTransfer;

    @GetMapping(path = "/get-all")
    public ResponseEntity getAll() {
//        Set<MenuDTO> menuDTOs = menuTransfer.listModelToDto( menuService.findAll() );
//        return ResponseEntity.ok().body( menuDTOs );
        return null;
    }
}
