package org.example.smallworld_backend.service.impl;

import org.example.smallworld_backend.EmailSender.EmailSender;
import org.example.smallworld_backend.dto.RequestDTO;
import org.example.smallworld_backend.entity.Guid;
import org.example.smallworld_backend.entity.Request;
import org.example.smallworld_backend.entity.User;
import org.example.smallworld_backend.repo.GuidRepository;
import org.example.smallworld_backend.repo.RequestRepository;
import org.example.smallworld_backend.repo.UserRepository;
import org.example.smallworld_backend.service.RequestService;
import org.example.smallworld_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RequestServiceIMPL implements RequestService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GuidRepository guidRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public int saveRequest(RequestDTO requestDTO) {
        try {
            User user = userRepository.findByEmail(requestDTO.getUserEmail());
            Optional<Guid> guid = guidRepository.findById(Long.parseLong(requestDTO.getGuideId()));
            Request request = new Request(
                    user,
                    requestDTO.getCustomerEmail(),
                    requestDTO.getCustomerName(),
                    requestDTO.getCustomerPhone(),
                    requestDTO.getGroupSize(),
                    guid.get(),
                    requestDTO.getMessage(),
                    requestDTO.getTourDate(),
                    requestDTO.getTourDuration(),
                    requestDTO.getLanguage(),
                    requestDTO.getStatus(),
                    requestDTO.getTitle()
            );
            requestRepository.save(request);
            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

    @Override
    public Object getAllRequests(String id) {
        try {
            //Optional<Guid> guid = guidRepository.findByGuidID(Long.parseLong(id));
            return requestRepository.findAllByGuid_Id(Long.parseLong(id));
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }

    @Override
    @Transactional
    public int updateRequest(String id, String status) {
        try{
            if (status.equals("accepted")) {
                Request request = requestRepository.findById(Long.parseLong(id)).get();
                String mailMassage = "Hello " + request.getCustomerName() + "! Your request to join " + request.getGuid().getName() + " tour has been accepted. You can join the tour on " + request.getTourDate() + " . See you then!"+
                        "\n now you can contact through " + request.getGuid().getEmail() +"\n"+ request.getGuid().getPhone_number() +
                        "Happy touring!"
                        ;
                emailSender.sendEmail(request.getCustomerEmail(), mailMassage);
            }
            requestRepository.updatereq(Long.parseLong(id), status);
            return VarList.OK;
        } catch (Exception e) {
            e.printStackTrace();
            return VarList.Bad_Gateway;
        }
    }


}
