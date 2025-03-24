package org.example.smallworld_backend.controller;

import org.example.smallworld_backend.dto.GuidDTO;
import org.example.smallworld_backend.dto.ResponseDTO;
import org.example.smallworld_backend.service.GuidService;
import org.example.smallworld_backend.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/guid")
@CrossOrigin
public class GuidController {
    @Autowired
    private GuidService guidService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveGuid(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone_number") String phoneNumber,
            @RequestParam("profile_photo") MultipartFile profilePhoto, // File upload
            @RequestParam("languages") List<String> languages, // List of languages
            @RequestParam("years_experience") int yearsExperience,
            @RequestParam("certifications") List<String> certifications) {

        System.out.println("saveGuid");

        try {
            // Create DTO and set the values
            GuidDTO guidDTO = new GuidDTO();
            guidDTO.setName(name);
            guidDTO.setEmail(email);
            guidDTO.setPhone_number(phoneNumber);
            guidDTO.setLanguages(languages);
            guidDTO.setExperience_of_years(String.valueOf(yearsExperience));
            guidDTO.setCertificates(certifications);
            guidDTO.setAvailability("Available");

            System.out.println(guidDTO.getCertificates());


            if (!profilePhoto.isEmpty()) {
                String filename = UUID.randomUUID().toString() + "_" + profilePhoto.getOriginalFilename();
                String uploadDir = "uploads/profile/";

                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                Path path = Paths.get(uploadDir + filename);
                Files.copy(profilePhoto.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                guidDTO.setProfile_image(filename); // Set updated list
            }

            int res = guidService.saveGuid(guidDTO);

            switch (res) {
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK, "Success", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }

        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateGuid(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone_number") String phoneNumber,
            @RequestParam("profile_photo") MultipartFile profilePhoto, // File upload
            @RequestParam("languages") List<String> languages, // List of languages
            @RequestParam("years_experience") int yearsExperience,
            @RequestParam("certifications") List<String> certifications) {

        System.out.println("saveGuid");

        try {
            // Create DTO and set the values
            GuidDTO guidDTO = new GuidDTO();
            guidDTO.setName(name);
            guidDTO.setEmail(email);
            guidDTO.setPhone_number(phoneNumber);
            guidDTO.setLanguages(languages);
            guidDTO.setExperience_of_years(String.valueOf(yearsExperience));
            guidDTO.setCertificates(certifications);
            guidDTO.setAvailability("Available");

            System.out.println(guidDTO.getCertificates());


            if (!profilePhoto.isEmpty()) {
                String filename = UUID.randomUUID().toString() + "_" + profilePhoto.getOriginalFilename();
                String uploadDir = "uploads/profile/";

                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                Path path = Paths.get(uploadDir + filename);
                Files.copy(profilePhoto.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                guidDTO.setProfile_image(filename); // Set updated list
            }

            int res = guidService.updateGuid(guidDTO);

            switch (res) {
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK, "Success", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }

        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteGuid(@RequestParam("email") String email) {
        try {
            int res = guidService.deleteGuid(email);
            switch (res) {
                case VarList.OK -> {
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(new ResponseDTO(VarList.OK, "Success", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }


}
