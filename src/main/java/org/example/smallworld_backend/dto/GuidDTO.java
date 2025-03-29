package org.example.smallworld_backend.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GuidDTO {
    private long guidID;
    private long user_id;
    private String profile_image;
    private String name;
    private String email;
    private String phone_number;
    private String address;
    private String about_me;
    private List<String> languages;
    private String experience_of_years;
    private List<String> certificates;
    private String availability;

    public GuidDTO(String profile_image, String name, String email, String phone_number, String about_me, List<String> languages, String experience_of_years, List<String> certificates, String availability) {
        this.profile_image = profile_image;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.about_me = about_me;
        this.languages = languages;
        this.experience_of_years = experience_of_years;
        this.certificates = certificates;
        this.availability = availability;
    }
}
