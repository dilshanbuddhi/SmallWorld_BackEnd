package org.example.smallworld_backend.service;

import org.example.smallworld_backend.dto.HotelDTO;

public interface HotelService {
    int saveHotel(HotelDTO hotelDTO);

    int updateHotel(HotelDTO hotel);

    Object getAllHotel();

    int deleteHotel(Long hotelID);
}
