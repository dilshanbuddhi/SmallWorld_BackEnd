package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.repo.RequestRepository;
import org.example.smallworld_backend.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceIMPL implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ModelMapper modelMapper;
}
