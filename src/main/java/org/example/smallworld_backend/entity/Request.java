package org.example.smallworld_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    private String customerEmail;
    private String customerName;
    private String customerPhone;
    private String groupSize;

    @ManyToOne
    private Guid guideId;
    private String message;
    private String tourDate;
    private String tourDuration;
    private String language;
    private String status;

    public Request(User user, String customerEmail, String customerName, String customerPhone, String groupSize, Guid guideId, String message, String tourDate, String tourDuration, String language, String status) {
        this.user = user;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.groupSize = groupSize;
        this.guideId = guideId;
        this.message = message;
        this.tourDate = tourDate;
        this.tourDuration = tourDuration;
        this.language = language;
        this.status = status;
    }
}
