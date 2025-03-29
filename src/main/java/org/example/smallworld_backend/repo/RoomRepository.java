package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Hotel;
import org.example.smallworld_backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {


    List<Room> findAllByHotelId(Long hotelId);
}
