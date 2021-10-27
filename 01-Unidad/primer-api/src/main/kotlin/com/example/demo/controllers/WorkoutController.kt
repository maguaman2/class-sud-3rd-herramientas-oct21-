package com.example.demo.controllers

import com.example.demo.model.Workout
import com.example.demo.service.WorkoutService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workouts")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class WorkoutController {

    @Autowired
    lateinit var workoutService: WorkoutService

    @GetMapping
    fun list(): List<Workout>{
        return workoutService.list()
    }


}