package com.example.demo.service

import com.example.demo.model.Workout
import com.example.demo.repository.WorkoutRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WorkoutService {
    @Autowired
    lateinit var workoutRepository: WorkoutRepository

    fun list(): List<Workout> {

        return workoutRepository.findAll()
    }
}