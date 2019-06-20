package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.service.ITypeSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class TypeSensorController
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@RestController
@RequestMapping("/api/type-sensor")
public class TypeSensorController {

    @Autowired
    private ITypeSensorService iTypeSensorService;

    @GetMapping("/find-all")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body( iTypeSensorService.findAll() );
    }
}
