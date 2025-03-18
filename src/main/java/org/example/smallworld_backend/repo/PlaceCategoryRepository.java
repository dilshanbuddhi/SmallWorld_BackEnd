package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.PlaceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceCategoryRepository extends JpaRepository<PlaceCategory, String> {
    boolean existsPlaceCategoriesByName(String name);

    void deleteByName(String name);
}
