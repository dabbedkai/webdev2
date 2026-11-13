package com.webdev2.controller;

import com.webdev2.model.Pet;
import com.webdev2.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet saved = petService.registerPet(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PutMapping("/{id}")
    public Pet updatePet(@PathVariable Long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.removePet(id);
        return ResponseEntity.noContent().build();
    }

    // Task 3 query endpoints
    @GetMapping("/species")
    public List<Pet> getPetsBySpecies(@RequestParam String name) {
        return petService.getPetsBySpecies(name);
    }

    @GetMapping("/search")
    public List<Pet> searchPets(@RequestParam String keyword) {
        return petService.searchPetsByName(keyword);
    }

    @GetMapping("/species-list")
    public List<String> getAllSpecies() {
        return petService.getAllSpeciesList();
    }

    @PostMapping("/batch")
    public ResponseEntity<Void> batchRegister(@RequestBody List<Pet> pets) {
        petService.batchRegister(pets);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}