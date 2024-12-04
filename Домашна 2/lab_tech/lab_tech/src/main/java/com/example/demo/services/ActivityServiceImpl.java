package com.example.demo.services;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activities = activityRepository.findAll();
        if (activities.isEmpty()) {
            System.out.println("No activities found!");
        }
        return activities;
    }

    @Override
    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void deleteById(Long id) {
        activityRepository.deleteById(id);
    }
}