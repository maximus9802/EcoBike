package com.quyvx.ecobike.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/typebikes")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class TypeBikeController {
    @PostMapping()
    public void createNewTypeBike(){}
}
