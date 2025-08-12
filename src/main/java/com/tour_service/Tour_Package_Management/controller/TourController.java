package com.tour_service.Tour_Package_Management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tour_service.Tour_Package_Management.service.TourService;
import com.tour_service.Tour_Package_Management.service.dto.request.CreateTourServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.response.CreateTourServiceResponseDto;
import com.tour_service.Tour_Package_Management.service.dto.response.TourServiceResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Tour Management", description = "Tour Management APIs")
public class TourController {

    private final TourService tourService;

    @Operation(summary = "Create Tour Package", description = "Create a new tour package")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create-tour-package")
    public ResponseEntity<CreateTourServiceResponseDto> createTourPackage(
            @RequestBody CreateTourServiceRequestDto requestDto) {

        CreateTourServiceResponseDto tourPackage = this.tourService.createTourPackage(requestDto);
        return new ResponseEntity<>(tourPackage, HttpStatus.CREATED);

    }

    @Operation(summary = "Get Tour Package by ID", description = "Retrieve a tour package by its ID")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @GetMapping("/get-tour-package-by-id")
    public ResponseEntity<TourServiceResponseDto> getTourPackageById(
            @RequestParam Long id) {
        TourServiceResponseDto tourPackage = this.tourService.getTourPackageById(id);
        return new ResponseEntity<>(tourPackage, HttpStatus.OK);
    }

    @Operation(summary = "Get All Tour Packages", description = "Retrieve all tour packages")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @GetMapping("/get-all-tour-packages")
    public ResponseEntity<List<TourServiceResponseDto>> getAllTourPackages() {
        List<TourServiceResponseDto> tourPackages = this.tourService.getAllTourPackages();
        return new ResponseEntity<>(tourPackages, HttpStatus.OK);
    }

    @Operation(summary = "Get Tour Package by Location", description = "Retrieve a tour package by its location")
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @GetMapping("/get-tour-package-by-location")
    public ResponseEntity<TourServiceResponseDto> getTourPackageByLocation(
            @RequestParam String location) {
        TourServiceResponseDto tourByLocation = this.tourService.getTourByLocation(location);
        return new ResponseEntity<>(tourByLocation, HttpStatus.OK);
    }


}
