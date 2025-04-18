package org.example.smallworld_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String name;
    private String description;
    private String location;
    private String latitude;
    private String longitude;

    @ElementCollection
    @CollectionTable(name = "hotel_amenities",
            joinColumns = @JoinColumn(name = "hotel_id"))
    private List<String> amenities;

    @ElementCollection
    @CollectionTable(name = "hotel_images",
            joinColumns = @JoinColumn(name = "hotel_id"))
    private List<String> image;


    public Hotel(String city, String name, String description, String location, String latitude, String longitude, List<String> amenities, List<String> image) {
        this.city = city;
        this.name = name;
        this.description = description;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.amenities = amenities;
        this.image = image;
    }
}
