package com.vn.tma.ntd.VM.controller;

import com.vn.tma.ntd.VM.dto.request.SensorCreateSubmit;
import com.vn.tma.ntd.VM.service.ISensorService;
import com.vn.tma.ntd.VM.service.ITypeSensorService;
import com.vn.tma.ntd.VM.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class SensorController
 *
 * @author ntduoc
 * @since 6/20/2019
 */
@RestController
@RequestMapping(path = "/api/sensor")
public class SensorController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ITypeSensorService iTypeSensorService;

    @Autowired
    private ISensorService iSensorService;

    @GetMapping(path = "/init-create")
    public ResponseEntity initCreate() {
        Map<String, Object> response = new HashMap<>();
        response.put( "accounts", iUserService.getAllForSelection() );
        response.put( "typeSensors", iTypeSensorService.findAll() );
        return ResponseEntity.ok().body( response );
    }

    @PostMapping(path = "/save")
    public ResponseEntity saveSensor(@RequestBody SensorCreateSubmit sensorCreateSubmit) {
        iSensorService.saveSensor( sensorCreateSubmit );
        return new ResponseEntity( HttpStatus.OK );
    }

    @GetMapping(path = "/sensor-of-user")
    public ResponseEntity getSensorOfUser(
            @PageableDefault(size = 5)
            @SortDefault.SortDefaults({
                    @SortDefault(sort = "id", direction = Sort.Direction.ASC)
            }) Pageable pageable,
            @RequestParam("userId") Long userId) {
        return ResponseEntity.ok().body( iSensorService.findSensorByUserModel_Id( userId, pageable ) );
    }
}
