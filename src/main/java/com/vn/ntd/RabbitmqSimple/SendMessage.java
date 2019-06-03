package com.vn.ntd.RabbitmqSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class SendMessage
 *
 * @author ntduoc
 * @since 6/3/2019
 */
@RestController
public class SendMessage {

    @Autowired
    private RabbitmqSimpleApplication.MyGateway myGateway;

    @PostMapping(path = "/send")
    public ResponseEntity sendMessage(@RequestBody String message) {
        myGateway.sendToMqtt( message );
        return new ResponseEntity( HttpStatus.OK );
    }
}
