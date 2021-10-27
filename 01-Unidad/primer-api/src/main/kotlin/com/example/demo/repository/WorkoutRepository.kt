package com.example.demo.repository

import com.example.demo.model.Workout
import org.springframework.data.jpa.repository.JpaRepository

interface WorkoutRepository:JpaRepository<Workout, Long> {

}