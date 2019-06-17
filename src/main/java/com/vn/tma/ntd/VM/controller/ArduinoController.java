package com.vn.tma.ntd.VM.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class ArduinoController
 *
 * @author ntduoc
 * @since 6/13/2019
 */
@RestController
@RequestMapping("/arduino")
public class ArduinoController {
    private Logger logger = LoggerFactory.getLogger( this.getClass() );

    @PostMapping(path = "/hello")
    public ResponseEntity hello(@RequestBody String message){
        logger.debug( message );
        return ResponseEntity.ok(  ).body( "Ok" );
    }
}
