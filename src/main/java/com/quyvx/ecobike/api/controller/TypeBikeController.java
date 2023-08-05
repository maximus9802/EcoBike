package com.quyvx.ecobike.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/typebikes")
@RestController
public class TypeBikeController {

    @PostMapping()
    public void createNewTypeBike(){}
}
