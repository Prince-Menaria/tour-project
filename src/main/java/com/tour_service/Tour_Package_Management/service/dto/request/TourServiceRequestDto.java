package com.tour_service.Tour_Package_Management.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourServiceRequestDto {

    private String title;
    private String description;

    private String duration;

    private String location;

    private String image;

    private Integer discountInPercentage; // e.g., 17

    private Double actualPrice; // e.g., 1200.00

    private Double discountedPrice; // e.g., 1000.00

}
