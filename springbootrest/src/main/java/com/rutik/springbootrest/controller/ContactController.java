package com.rutik.springbootrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000")  // Allow requests from React frontend
public class ContactController {

    @PostMapping
    public ResponseEntity<String> handleContactForm(@RequestBody ContactMessage message) {
        // Handle the message (e.g., save to database or send email)
        System.out.println("Received message: " + message);
        return ResponseEntity.ok("Message sent successfully");
    }
}
