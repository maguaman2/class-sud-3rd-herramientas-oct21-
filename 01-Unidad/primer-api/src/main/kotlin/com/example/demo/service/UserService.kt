package com.example.demo.service

import com.example.demo.model.Diet
import com.example.demo.model.User
import com.example.demo.repository.DietRepository
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.lang.Exception


@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun list(): List<User> {

        return userRepository.findAll()
    }

    fun getUser(username:String?):User?{
        try {
            val response = userRepository.findByUsername(username)
                    ?: throw Exception("No existe usuario")
            return response
        }catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(user:User):User{
        return userRepository.save(user)
    }


}