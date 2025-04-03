package org.example.smallworld_backend.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.smallworld_backend.EmailSender.EmailSender;
import org.example.smallworld_backend.dto.GuidDTO;
import org.example.smallworld_backend.dto.RequestDTO;
import org.example.smallworld_backend.dto.ResponseDTO;
import org.example.smallworld_backend.service.GuidService;
import org.example.smallworld_backend.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/tourRequest")
@CrossOrigin
public class GuidRequestController {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    private GuidService guidService;

    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority('user', 'admin')")
    public ResponseEntity<ResponseDTO> createGuidRequest(@RequestBody RequestDTO requestDTO , HttpServletRequest request) {
        try {
            System.out.println(requestDTO.getGuideId());
            System.out.println(requestDTO.getMessage());
            System.out.println(requestDTO.getCustomerName());
            System.out.println(requestDTO.getTourDuration());
            System.out.println(requestDTO.getCustomerEmail());

       /* String guidemail = (String) request.getAttribute("email");
        System.out.println(guidemail);*/

            String reqMessage = String.format(
                    "Dear Guide,\n\n" +
                            "I hope this email finds you well. I am reaching out to request a tour with the following details:\n\n" +
                            "- Customer Name: %s\n" +
                            "- Customer Email: %s\n" +
                            "- Customer Phone: %s\n" +
                            "- Group Size: %s\n" +
                            "- Preferred Tour Date: %s\n" +
                            "- Duration of the Tour: %s\n" +
                            "- Additional Message from Customer: %s\n\n" +
                            "Please let us know your availability and any further details regarding the tour. We look forward to your response.\n\n" +
                            "Best regards,\n" +
                            "SmallWorld Team",
                    requestDTO.getCustomerName(),
                    requestDTO.getCustomerEmail(),
                    requestDTO.getCustomerPhone(),
                    requestDTO.getGroupSize(),
                    requestDTO.getTourDate(),
                    requestDTO.getTourDuration(),
                    requestDTO.getMessage()
            );

            String email = guidService.getEmailbyId(requestDTO.getGuideId());
            System.out.println(email + "    Email    lihiniiiiiiiiiiiiiiii");
            emailSender.sendEmail(email, reqMessage);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(VarList.OK, "Success", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(new ResponseDTO(VarList.Bad_Gateway, "Error", e.getMessage()));
        }
    }
}
