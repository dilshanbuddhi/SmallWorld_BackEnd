package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.dto.GuidDTO;
import org.example.smallworld_backend.entity.Guid;
import org.example.smallworld_backend.repo.GuidRepository;
import org.example.smallworld_backend.repo.UserRepository;
import org.example.smallworld_backend.service.GuidService;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuidServiceIMPL implements GuidService {
    @Autowired
    private GuidRepository guidRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public int saveGuid(GuidDTO guidDTO) {
        guidRepository.fin
        System.out.println("mekata awaaa");

        try {
            System.out.println("into try");
            if(userRepository.existsByEmail(guidDTO.getEmail())) {
                System.out.println("into if");
                return VarList.Not_Acceptable;
            }
            else {
                Guid guid = modelMapper.map(guidDTO, Guid.class);
                guid.setUser(userRepository.findByEmail("dilshan@gmail.com"));
                guid.setCertifications(guidDTO.getCertificates());
                guidRepository.save(guid);
                return VarList.OK;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateGuid(GuidDTO guidDTO) {
        try {
            Guid guid = modelMapper.map(guidDTO, Guid.class);
            guid.setUser(userRepository.findByEmail("dilshan@gmail.com"));
            guid.setCertifications(guidDTO.getCertificates());
            guidRepository.save(guid);
            return VarList.OK;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int deleteGuid(String email) {
        try {
           // Guid guid = guidRepository.findByEmail(email);
            guidRepository.deleteByEmail(email);
            return VarList.OK;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
