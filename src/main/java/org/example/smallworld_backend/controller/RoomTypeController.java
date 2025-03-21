package org.example.smallworld_backend.controller;

import org.example.smallworld_backend.dto.ResponseDTO;
import org.example.smallworld_backend.dto.RoomTypeDTO;
import org.example.smallworld_backend.service.RoomTypeService;
import org.example.smallworld_backend.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roomType")
@CrossOrigin
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveRoomType(@RequestBody RoomTypeDTO roomTypeDTO) {
        try {
            int res = roomTypeService.saveRoomType(roomTypeDTO);

            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Place Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
