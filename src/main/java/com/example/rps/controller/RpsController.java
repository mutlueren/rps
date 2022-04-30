package com.example.rps.controller;

import com.example.rps.service.RpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class RpsController {

    @Autowired
    RpsService rpsService;

    @RequestMapping("/rps")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity rpsRequest(@RequestParam("choise") String choise) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(rpsService.rpsBrain(choise));
    }
}
