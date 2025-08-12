package com.tour_service.Tour_Package_Management.service;

import java.util.List;

import com.tour_service.Tour_Package_Management.service.dto.request.CreateTourServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.response.CreateTourServiceResponseDto;
import com.tour_service.Tour_Package_Management.service.dto.response.TourServiceResponseDto;

public interface TourService {

    public CreateTourServiceResponseDto createTourPackage(CreateTourServiceRequestDto requestDto);

    public TourServiceResponseDto getTourPackageById(Long id);

    public List<TourServiceResponseDto> getAllTourPackages();

    public TourServiceResponseDto getTourByLocation(String location);

}
