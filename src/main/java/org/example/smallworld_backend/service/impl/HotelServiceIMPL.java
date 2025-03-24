package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.dto.HotelDTO;
import org.example.smallworld_backend.entity.Hotel;
import org.example.smallworld_backend.repo.HotelRepository;
import org.example.smallworld_backend.repo.PlaceRepository;
import org.example.smallworld_backend.service.HotelService;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceIMPL implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlaceRepository placeRepository;

    @Override
    public int saveHotel(HotelDTO hotelDTO) {
        try {
            Hotel hotel = new Hotel(
                    placeRepository.findById(Long.valueOf(hotelDTO.getPlaceID())).get(),
                    hotelDTO.getName(),
                    hotelDTO.getDescription(),
                    hotelDTO.getLocation(),
                    hotelDTO.getLatitude(),
                    hotelDTO.getLongitude(),
                    hotelDTO.getImage()
            );
            hotelRepository.save(hotel);
            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public int updateHotel(HotelDTO hotel) {
        try {
            hotelRepository.save(modelMapper.map(hotel, Hotel.class));
            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public Object getAllHotel() {
        try {
            return hotelRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteHotel(Long hotelID) {
        try {
            hotelRepository.deleteById(Long.valueOf(hotelID));

            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

}
