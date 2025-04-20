package org.example.smallworld_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class RoomTypeDTO {
   // @NotNull(message = "Room Type id cannot be null")
    private Long id;

    @NotBlank(message = "Room Type cannot be blank")
    private String room_type;

    @NotBlank(message = "Room Type description cannot be blank")
    private String description;

    @NotNull(message = "Room Type amenities cannot be null")
    @NotEmpty(message = "Room Type amenities cannot be empty")
    private List<String> amenities;

    public RoomTypeDTO(String room_type, String description, List<String> amenities) {
        this.room_type = room_type;
        this.description = description;
        this.amenities = amenities;
    }

}
