package com.rutik.springbootrest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rutik.springbootrest.service.JobService;

@SpringBootApplication
public class SpringBootRestApplication implements CommandLineRunner {

    @Autowired
    private JobService jobService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Call the load method to insert data on startup
        jobService.load();
    }
}
