package com.webdev2.service;

import com.webdev2.model.Pet;
import com.webdev2.repository.PetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet registerPet(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found with ID: " + id));
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        Pet existing = getPetById(id);
        existing.setMicrochipNumber(updatedPet.getMicrochipNumber());
        existing.setName(updatedPet.getName());
        existing.setSpecies(updatedPet.getSpecies());
        existing.setBreed(updatedPet.getBreed());
        return petRepository.save(existing);
    }

    public void removePet(Long id) {
        Pet existing = getPetById(id);
        petRepository.delete(existing);
    }

    // Task 3 query delegations
    public List<Pet> getPetsBySpecies(String species) {
        return petRepository.findBySpeciesIgnoreCase(species);
    }

    public List<Pet> searchPetsByName(String keyword) {
        return petRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<String> getAllSpeciesList() {
        return petRepository.findAllSpecies();
    }

    @Transactional
    public void batchRegister(List<Pet> pets) {
        for (Pet p : pets) {
            petRepository.save(p);
        }
    }
}