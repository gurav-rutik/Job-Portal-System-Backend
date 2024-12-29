package com.rutik.springbootrest.controller;

import com.rutik.springbootrest.model.JobPost;
import com.rutik.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
//    @ResponseBody
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }


//    @GetMapping(path = "jobPosts", produces = {"application/json"})
//    public List<JobPost> getAllJobs(){
//        return service.getAllJobs();
//    }

    @GetMapping("/jobPosts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping("jobPosts")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

//    @PostMapping(path="jobPosts", consumes = {"application/xml"})
//    public JobPost addJob(@RequestBody JobPost jobPost){
//        service.addJobPost(jobPost);
//        return service.getJob(jobPost.getPostId());
//    }

    @PutMapping("jobPosts")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPosts/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted!!";
    }

    @GetMapping("load")
    public String loadData(){

        service.load();

        return "success!!";
    }
}
