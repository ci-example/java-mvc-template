package com.flow.pooling.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * To receive heartbeat
 *
 * Created by gy@fir.im on 24/04/2017.
 */

@RestController
@RequestMapping("/")
public class HeartbeatController {

    @RequestMapping("/heartbeat")
    public String heartbeat() {
        return "ok";
    }
}
