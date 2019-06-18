package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.service.IRoleService;
import com.vn.tma.ntd.VM.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class RoleController
 *
 * @author ntduoc
 * @since 6/18/2019
 */
@RestController
@RequestMapping(path = "/api/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @GetMapping(path = "/get")
    public ResponseEntity getRoles() {
        return ResponseEntity.ok().body( iRoleService.findAll() );
    }
}
