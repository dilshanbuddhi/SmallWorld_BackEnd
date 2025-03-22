package org.example.smallworld_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Guid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long guidID;
    @OneToOne
    private User user;
    private String profile_image;
    private String name;
    private String email;
    @ElementCollection
    @CollectionTable(name = "languages", joinColumns = @JoinColumn(name = "guid_id"))
    @Column(name = "guid_languages")
    private List<String> languages;
    private int experience_of_years;
    @ElementCollection
    @CollectionTable(name = "certifications", joinColumns = @JoinColumn(name = "guid_id"))
    @Column(name = "guid_certifications")
    private List<String> certifications;
    private String availability;

    public Guid(User user, String profile_image, String name, String email, List<String> languages, int experience_of_years, List<String> certifications, String availability) {
        this.user = user;
        this.profile_image = profile_image;
        this.name = name;
        this.email = email;
        this.languages = languages;
        this.experience_of_years = experience_of_years;
        this.certifications = certifications;
        this.availability = availability;
    }
}
