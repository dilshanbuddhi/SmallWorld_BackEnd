package org.example.smallworld_backend.repo;

import org.example.smallworld_backend.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
