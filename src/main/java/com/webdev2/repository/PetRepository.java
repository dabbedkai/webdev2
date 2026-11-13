package com.webdev2.repository;

import com.webdev2.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // Task 3: Derived query methods
    List<Pet> findBySpeciesIgnoreCase(String species);
    List<Pet> findByNameContainingIgnoreCase(String keyword);

    // Task 3: Custom JPQL method
    @Query("SELECT DISTINCT p.species FROM Pet p")
    List<String> findAllSpecies();
}