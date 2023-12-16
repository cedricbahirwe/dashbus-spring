package com.example.aucaregistration.service;


import com.example.aucaregistration.domain.StopLocation;
import com.example.aucaregistration.domain.Ticket;
import com.example.aucaregistration.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public StopLocation saveLocation(StopLocation location) throws Exception {
        if (location != null) {
            return locationRepository.save(location);
        } else {
            throw new Exception("Unable to save Location");
        }
    }

    public List<StopLocation> getAllLocations() {
        return locationRepository.findAll();
    }

    public StopLocation findLocationByName(String location) {
        return locationRepository.findByNameIgnoreCase(location)
                .orElse(null);
    }
}
