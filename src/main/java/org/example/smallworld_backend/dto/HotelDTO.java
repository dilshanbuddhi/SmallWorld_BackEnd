package org.example.smallworld_backend.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {
    private Long id;
    private String placeID;
    private String name;
    private String description;
    private String location;
    private String latitude;
    private String longitude;
    private List<String> image;

    public HotelDTO(Long id, String placeID, String name, String description, String location, String latitude, String longitude) {
        this.id = id;
        this.placeID = placeID;
        this.name = name;
        this.description = description;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
