package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Object> findAllByCity(String city);

    @Modifying
    @Query(value = "DELETE FROM hotel_images WHERE hotel_id = ?1", nativeQuery = true)
    void deleteHotelImages(Long hotelID);

    @Modifying
    @Query(value = "DELETE FROM hotel_amenities WHERE hotel_id = ?1", nativeQuery = true)
    void deleteAmenies(Long hotelID);
}
