package com.tour_service.Tour_Package_Management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.tour_service.Tour_Package_Management.controller.TourController;
import com.tour_service.Tour_Package_Management.service.TourService;
import com.tour_service.Tour_Package_Management.service.dto.request.CreateTourServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.response.CreateTourServiceResponseDto;
import com.tour_service.Tour_Package_Management.service.dto.response.TourServiceResponseDto;

public class TourManagementTest {

    @Mock
    private TourService tourService;

    @InjectMocks
    private TourController tourController;

    public TourManagementTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTourPackage() {
        CreateTourServiceRequestDto requestDto = new CreateTourServiceRequestDto();
        requestDto.setTitle("Amazing Tour");
        requestDto.setLocation("Jaipur");
        requestDto.setDescription("A wonderful tour package to Jaipur");
        requestDto.setActualPrice(5000.0);
        requestDto.setDiscountedPrice(4500.0);
        requestDto.setDuration("3 days");
        requestDto.setImage("http://example.com/image.jpg");
        requestDto.setDiscountInPercentage(10);

        CreateTourServiceResponseDto responseDto = new CreateTourServiceResponseDto();
        responseDto.setMessage("Tour package created successfully");

        when(tourService.createTourPackage(requestDto)).thenReturn(responseDto);

        ResponseEntity<CreateTourServiceResponseDto> response = tourController.createTourPackage(requestDto);

        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Tour package created successfully", response.getBody().getMessage());
    }

    @Test
    void testGetTourPackageById() {
        TourServiceResponseDto responseDto = new TourServiceResponseDto();
        responseDto.setId(1L);

        when(tourService.getTourPackageById(1L)).thenReturn(responseDto);

        ResponseEntity<TourServiceResponseDto> response = tourController.getTourPackageById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    void testGetAllTourPackages() {
        TourServiceResponseDto dto = new TourServiceResponseDto();
        dto.setId(1L);

        when(tourService.getAllTourPackages()).thenReturn(List.of(dto));

        ResponseEntity<List<TourServiceResponseDto>> response = tourController.getAllTourPackages();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
        assertEquals(1L, response.getBody().get(0).getId());
    }

    @Test
    void testGetTourPackageByLocation() {
        TourServiceResponseDto responseDto = new TourServiceResponseDto();
        responseDto.setLocation("Jaipur");

        when(tourService.getTourByLocation("Jaipur")).thenReturn(responseDto);

        ResponseEntity<TourServiceResponseDto> response = tourController.getTourPackageByLocation("Jaipur");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Jaipur", response.getBody().getLocation());
    }

}
