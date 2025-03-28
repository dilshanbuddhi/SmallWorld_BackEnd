package org.example.smallworld_backend.service;

import org.example.smallworld_backend.dto.GuidDTO;

public interface GuidService {
    int saveGuid(GuidDTO guidDTO);

    int updateGuid(GuidDTO guidDTO);

    int deleteGuid(String email);
}
