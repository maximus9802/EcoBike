package com.quyvx.ecobike.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/card")
@RestController
public class CardController {
    @PatchMapping("processTransaction")
    public void processTransaction(){

    }

    @PatchMapping("reset-balance")
    public void resetBalance(){

    }

}
