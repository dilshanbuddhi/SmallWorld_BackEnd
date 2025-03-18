package org.example.smallworld_backend.service;

import org.example.smallworld_backend.dto.PlaceCategoryDTO;

public interface PlaceCategory {
    int savePlaceCategory(PlaceCategoryDTO placeCt);

    int deletePlaceCategory(String name);

    int updatePlaceCategory(PlaceCategoryDTO placeCt);

    Object getAllPlaceCategory();
}
