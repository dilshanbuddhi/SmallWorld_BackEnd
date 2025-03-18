package org.example.smallworld_backend.service;

import org.example.smallworld_backend.dto.PlaceDTO;

public interface PlaceService {
    int savePlace(PlaceDTO place);

    int deletePlace(String placeID);
}
