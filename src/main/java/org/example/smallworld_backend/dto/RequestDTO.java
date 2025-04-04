package org.example.smallworld_backend.dto;

import jdk.dynalink.NamedOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDTO {
    private String customerEmail;
    private String customerName;
    private String customerPhone;
    private String groupSize;
    private String guideId;
    private String message;
    private String tourDate;
    private String tourDuration;
    private String language;
    private String status;
}
