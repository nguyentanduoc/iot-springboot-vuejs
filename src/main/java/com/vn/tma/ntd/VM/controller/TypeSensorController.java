package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.dto.request.TypeOfSensorSubmit;
import com.vn.tma.ntd.VM.service.ITypeSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/save")
    public ResponseEntity saveTypeOfSensor(@RequestBody TypeOfSensorSubmit typeOfSensorSubmit) {
        iTypeSensorService.save( typeOfSensorSubmit );
        return new ResponseEntity( HttpStatus.OK );
    }
}
