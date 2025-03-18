package org.example.smallworld_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlaceDTO {
    private String id;
    private String name;
    private String categoryID;
    private String description;
    private String location;
    private String latitude;
    private String longitude;
    private List<String> image;

    public PlaceDTO(String name, String categoryID, String description, String location, String latitude, String longitude, List<String> image) {
        this.name = name;
        this.categoryID = categoryID;
        this.description = description;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }
}
