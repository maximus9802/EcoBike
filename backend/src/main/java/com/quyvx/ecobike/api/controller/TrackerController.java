package com.quyvx.ecobike.api.controller;

import com.quyvx.ecobike.api.application.models.tracker.RentInfo;
import com.quyvx.ecobike.api.application.services.TrackerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tracker")
@CrossOrigin(origins = "http://localhost:5173")
public class TrackerController {
    private final TrackerService trackerService;

    @GetMapping("{id}")
    public RentInfo getRentInfo(@PathVariable("id") Long bikeId){
        if (trackerService.viewRentInfoToNow(bikeId).getCast() < 0)
            return trackerService.viewRentInfoToNow(bikeId);
        return null;
    }
}
