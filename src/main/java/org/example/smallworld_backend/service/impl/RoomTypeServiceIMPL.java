package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.dto.RoomTypeDTO;
import org.example.smallworld_backend.entity.RoomType;
import org.example.smallworld_backend.repo.RoomTypeRepository;
import org.example.smallworld_backend.service.RoomTypeService;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomTypeServiceIMPL implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveRoomType(RoomTypeDTO roomTypeDTO) {
        try{
            if (roomTypeRepository.existsById(roomTypeDTO.getId())) {
                return VarList.Bad_Gateway;
            }
            roomTypeRepository.save(modelMapper.map(roomTypeDTO, RoomType.class));
            return VarList.OK;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
