package com.tour_service.Tour_Package_Management.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String apiPath;
    private HttpStatus statusCode;
    private Exception errorMessage;
    private LocalDateTime errorTime;

}
