package org.example.smallworld_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalIdCache;

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
    private Hotel hotel;
    @ManyToOne
    private RoomType room_type;
    private String price;
    private String totalRooms;
    private String availableRooms;

    public Room(Hotel hotelId, RoomType room_type_Id, String price, String totalRooms, String availableRooms) {
        hotel = hotelId;
        this.room_type = room_type_Id;
        this.price = price;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }
}
