package com.quyvx.ecobike.api.controller;

import com.quyvx.ecobike.api.application.queries.typebike.ITypeBikeQueriesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/typebikes")
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TypeBikeController {
    private final ITypeBikeQueriesService typeBikeQueriesService;

    @GetMapping("")
    public List<String> getAllTypeBike(){
        return typeBikeQueriesService.findAllType();
    }
}
