package org.example.smallworld_backend.service.impl;


import org.example.smallworld_backend.dto.PlaceCategoryDTO;
import org.example.smallworld_backend.repo.PlaceCategoryRepository;
import org.example.smallworld_backend.service.PlaceCategory;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlaceCategoryIServiceMPL implements PlaceCategory {
    @Autowired
    private PlaceCategoryRepository placeCategoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public int savePlaceCategory(PlaceCategoryDTO placeCt) {
        if (placeCategoryRepository.existsPlaceCategoriesByName(placeCt.getName())) {
            return VarList.Not_Acceptable;
        }else {
            placeCategoryRepository.save(modelMapper.map(placeCt, org.example.smallworld_backend.entity.PlaceCategory.class));
            return VarList.Created;
        }
    }

    @Override
    public int deletePlaceCategory(String name) {
       if (placeCategoryRepository.existsPlaceCategoriesByName(name)) {
           placeCategoryRepository.deleteByName(name);
           return VarList.OK;
       }else {
           return VarList.Bad_Gateway;
       }
    }

    @Override
    public int updatePlaceCategory(PlaceCategoryDTO placeCt) {
        if (placeCategoryRepository.existsPlaceCategoriesByName(placeCt.getName())) {
            placeCategoryRepository.save(modelMapper.map(placeCt, org.example.smallworld_backend.entity.PlaceCategory.class));
            return VarList.OK;
        }else {
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public Object getAllPlaceCategory() {
        try {
            return placeCategoryRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
