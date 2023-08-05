package com.quyvx.ecobike.api.controller;

import com.quyvx.ecobike.api.dto.dock.CreateDockReqDto;
import com.quyvx.ecobike.api.dto.dock.CreateDockResDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/docks")
@RestController
public class DockController {

    @PostMapping
    public CreateDockResDto createDock(CreateDockReqDto request){
        return  null;
    }
}
