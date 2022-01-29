package com.example.demo.service

import com.example.demo.model.Diet
import com.example.demo.repository.DietRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


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

    fun update(diet:Diet):Diet{
        try {
            dietRepository.findById(diet.id)
                    ?: throw Exception("fffff")

            //Validar que no vengan vacios
            diet.description?.takeIf { it.trim().isNotEmpty() }
                    ?: throw java.lang.Exception()

            return dietRepository.save(diet)
        }catch (ex:Exception){
            throw Exception()
        }

    }

    fun updateDescription (diet:Diet):Diet {
        try {

            diet.description?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Descripcion no debe ser vacio")

            val response = dietRepository.findById(diet.id)
                    ?: throw Exception("El id ${diet.id} en dieta no existe")
            response.apply {
                this.description = diet.description
            }
            return dietRepository.save(diet)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        dietRepository.deleteById(id)
        return true
    }

    fun calcularAlgo(number: Long?): Int{
        return 0;
    }

    fun verifyWord(description: String?):Boolean{
        if (description?.length!!<3){
            return false
        }
        return true
    }

}