
package org.example.smallworld_backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RoomDTO {
    private Long id;
    @NotNull(message = "Hotel ID is required")
    private long hotel_id;
    @NotNull(message = "Room Type ID is required")
    private long room_type_Id;
    @NotNull(message = "Price is required")
    @DecimalMin(value = "100.0", message = "Price must be more than 100")
    private String price;
    @NotNull(message = "Total Rooms is required")
    private String totalRooms;
    @NotNull(message = "Available Rooms is required")
    private String availableRooms;
    @NotNull(message = "Available Rooms is required")
    private List<String> images;

    public RoomDTO(long hotel_id, long room_type_Id, String price, String totalRooms, String availableRooms) {
        this.hotel_id = hotel_id;
        this.room_type_Id = room_type_Id;
        this.price = price;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }
}
