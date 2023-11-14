package br.com.pet.schedulling.controller

import br.com.pet.schedulling.model.Pet
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetController {

    @GetMapping
    fun getAll(): List<Pet>{
        return ArrayList<Pet>();
    }
}