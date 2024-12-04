package com.example.demo.controller;

import com.example.demo.model.Activity;
import com.example.demo.services.ActivityService;
import com.example.demo.services.ActivityServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Validated
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.findAll();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/activities/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        Optional<Activity> activity = activityService.findById(id);
        return activity.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/activities")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity newActivity = activityService.save(activity);
        return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
    }

    @PutMapping("/activities/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        Optional<Activity> existingActivity = activityService.findById(id);
        if (existingActivity.isPresent()) {
            updatedActivity.setId(id);
            Activity savedActivity = activityService.save(updatedActivity);
            return new ResponseEntity<>(savedActivity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
        if (activityService.findById(id).isPresent()) {
            activityService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}