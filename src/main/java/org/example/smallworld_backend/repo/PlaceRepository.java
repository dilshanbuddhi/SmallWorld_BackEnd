package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
