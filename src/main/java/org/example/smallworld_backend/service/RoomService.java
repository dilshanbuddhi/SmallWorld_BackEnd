package org.example.smallworld_backend.service;

import org.example.smallworld_backend.dto.RoomDTO;

public interface RoomService {
    int saveRoom(RoomDTO roomDTO);

    int deleteRoom(Long roomID);

    int updateRoom(RoomDTO roomDTO);

    Object getAllRoom();
}
