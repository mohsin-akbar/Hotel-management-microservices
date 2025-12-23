package com.hospitalService.controller;

import com.hospitalService.entity.Hotel;
import com.hospitalService.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    //create hotel
    @PostMapping("/")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel){
        String s = UUID.randomUUID().toString();
        hotel.setHotelId(s);
        return ResponseEntity.ok(hotelRepository.save(hotel));
    }

    //getOneHotel
@GetMapping("/{hotelId}")
    public ResponseEntity<?> getOneHotel(@PathVariable("hotelId") String hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new RuntimeException("resource not found Exception"));
        return ResponseEntity.ok(hotel);
    }


    //getAllHotel
@GetMapping("/")
    public ResponseEntity<?> getAllHotel(){
        List<Hotel> all = hotelRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }



}
