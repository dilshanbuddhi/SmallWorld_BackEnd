package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.dto.PlaceDTO;
import org.example.smallworld_backend.entity.Place;
import org.example.smallworld_backend.repo.PlaceCategoryRepository;
import org.example.smallworld_backend.repo.PlaceRepository;
import org.example.smallworld_backend.service.PlaceCategory;
import org.example.smallworld_backend.service.PlaceService;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PlaceCategoryRepository placeCategoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int savePlace(PlaceDTO place) {
        try {
            // Check if place already exists with the same name and location
           /* Optional<Place> existingPlace = placeRepository.findByNameAndLocation(place.getName(), place.getLocation());
            if (existingPlace.isPresent()) {
                return VarList.Not_Acceptable;
            }*/

            // Map DTO to entity
           /* Place placeEntity = modelMapper.map(place, Place.class);
            placeEntity.setCategory(placeRepository.findBy(place.getCategoryID()).get());*/
            Place placeEntity = new Place(place.getName(), placeCategoryRepository.findById(place.getCategoryID()).get(), place.getDescription(), place.getLocation(), place.getLatitude(), place.getLongitude(), place.getImage());

            // Save the place
            placeRepository.save(placeEntity);
            return VarList.Created;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public int deletePlace(String placeID) {
        try {
            placeRepository.deleteById(Long.valueOf(placeID));
            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

}