package com.gpscontrol.backprueba.controller;

import com.gpscontrol.backprueba.dto.VehicleDTO;
import com.gpscontrol.backprueba.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleDTO vehicleDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.createVehicle(vehicleDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable("id") Long id,
                                           @RequestBody VehicleDTO vehicleDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.updateVehicle(id,vehicleDTO));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.deleteVehicle(id));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
