package com.example.aucaregistration.controller;

import com.example.aucaregistration.domain.StopLocation;
import com.example.aucaregistration.domain.Ticket;
import com.example.aucaregistration.service.ClientService;
import com.example.aucaregistration.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(
        value = "/location",
        produces = {MediaType.APPLICATION_JSON_VALUE}
)
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createLocation(@RequestBody StopLocation location) {
        if (location != null) {
            try {
                StopLocation savedLocation = locationService.saveLocation(location);
                return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Empty data not allowed!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<StopLocation>> getAllLocations() {
        List<StopLocation> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
}
