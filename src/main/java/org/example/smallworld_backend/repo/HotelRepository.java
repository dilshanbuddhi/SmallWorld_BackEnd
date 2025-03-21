package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
