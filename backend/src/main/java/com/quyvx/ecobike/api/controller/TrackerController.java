package com.quyvx.ecobike.api.controller;

import com.quyvx.ecobike.api.application.models.tracker.RentInfo;
import com.quyvx.ecobike.api.application.services.TrackerService;
import com.quyvx.ecobike.api.dto.tracker.AssignTrackerRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tracker")
@CrossOrigin(origins = "http://localhost:5173")
public class TrackerController {
    private final TrackerService trackerService;

    @PutMapping("{id}")
    public AssignTrackerRes assignTrackerToBike(@PathVariable("id") Long id, @RequestParam("typeTracker") String typeTracker){
        return trackerService.assignTracker(typeTracker, id);
    }
    @GetMapping("{id}")
    public RentInfo getRentInfo(@PathVariable("id") Long bikeId){
        return trackerService.viewRentInfoToNow(bikeId);
    }
}
