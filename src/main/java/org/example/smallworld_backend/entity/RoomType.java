package org.example.smallworld_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String room_type;
    private String description;
    @ElementCollection
    @CollectionTable(name = "room_amenities", joinColumns = @JoinColumn(name = "room_type_id"))
    @Column(name = "amenities")
    private List<String> amenities;

    public RoomType(String room_type, String description, List<String> amenities) {
        this.room_type = room_type;
        this.description = description;
        this.amenities = amenities;
    }
}
