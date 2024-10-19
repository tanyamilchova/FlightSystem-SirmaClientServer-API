package com.example.demo.controller;

import com.example.demo.model.entities.Seat;
import com.example.demo.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {
    @Autowired
    SeatService seatService;

    @GetMapping("/seats")
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }

}
