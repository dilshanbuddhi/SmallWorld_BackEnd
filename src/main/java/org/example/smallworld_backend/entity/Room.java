package org.example.smallworld_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    //@JsonIgnore
    private Hotel hotel;
    @ManyToOne
    private RoomType room_type;
    private String price;
    private String totalRooms;
    private String availableRooms;

    @ElementCollection
    @CollectionTable(name = "room_images", joinColumns = @JoinColumn(name = "room_id"))
    @Column(name = "image_path")
    private List<String> images;

    public Room(Hotel hotel, RoomType room_type, String price, String totalRooms, String availableRooms, List<String> images) {
        this.hotel = hotel;
        this.room_type = room_type;
        this.price = price;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
        this.images = images;
    }

    public Room( Hotel hotel, RoomType room_type, String price, String totalRooms, String availableRooms) {
        this.hotel = hotel;
        this.room_type = room_type;
        this.price = price;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }
}
