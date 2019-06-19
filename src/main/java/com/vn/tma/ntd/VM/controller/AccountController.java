package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.dto.UserDTO;
import com.vn.tma.ntd.VM.dto.request.AccountEditSubmit;
import com.vn.tma.ntd.VM.dto.request.AccountSubmit;
import com.vn.tma.ntd.VM.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The Class AccountController
 *
 * @author ntduoc
 * @since 6/18/2019
 */
@RestController
@RequestMapping(path = "/api/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger( getClass() );

    @Autowired
    private IUserService iUserService;

    @PostMapping(path = "/create")
    public ResponseEntity createAccount(@RequestBody AccountSubmit accountSubmit) {
        logger.debug( String.format( "%s method createAccount", getClass().toString() ) );
        return ResponseEntity.ok().body( iUserService.createAccount( accountSubmit ) );
    }

    @GetMapping(path = "/get")
    public ResponseEntity<Page<UserDTO>> getUser(
            @PageableDefault(size = 5)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "id", direction = Sort.Direction.ASC)
            }) Pageable pageable) {
        return ResponseEntity.ok().body( iUserService.findAllUser( pageable ) );
    }

    @PostMapping(path = "/edit")
    public ResponseEntity editAccount(@RequestBody AccountEditSubmit accountEditSubmit) {
        UserDTO userDTO = iUserService.editAccount( accountEditSubmit );
        return ResponseEntity.ok().body( userDTO );
    }
}
