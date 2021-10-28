package com.example.demo.service

import com.example.demo.model.Diet
import com.example.demo.repository.DietRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DietService {
    @Autowired
    lateinit var dietRepository: DietRepository

    fun list(): List<Diet> {

        return dietRepository.findAll()
    }

    fun save(diet:Diet):Diet{
        return dietRepository.save(diet)
    }
}