package com.tour_service.Tour_Package_Management.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.tour_service.Tour_Package_Management.entity.Tour;
import com.tour_service.Tour_Package_Management.repo.TourRepository;
import com.tour_service.Tour_Package_Management.service.TourService;
import com.tour_service.Tour_Package_Management.service.dto.request.CreateTourServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.request.TourPackageByIdServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.request.TourPackageByLocationServiceRequestDto;
import com.tour_service.Tour_Package_Management.service.dto.response.CreateTourServiceResponseDto;
import com.tour_service.Tour_Package_Management.service.dto.response.TourServiceResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    @Override
    public CreateTourServiceResponseDto createTourPackage(CreateTourServiceRequestDto requestDto) {
        try {
            Tour saveTour = this.convertRequestToResponseDto(requestDto);
            this.tourRepository.save(saveTour);
            CreateTourServiceResponseDto responseDto = new CreateTourServiceResponseDto();
            responseDto.setMessage("Tour package created successfully");
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating tour package: " + e.getMessage());
        }
    }

    @Override
    public TourServiceResponseDto getTourPackageById(Long id) {
        try {
            Tour tour = this.tourRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Tour package not found"));

            if (ObjectUtils.isEmpty(tour)) {
                throw new RuntimeException("Tour package not found with id: " + id);
            }
            return this.convertTourToResponseDto(tour);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<TourServiceResponseDto> getAllTourPackages() {
        try {
            List<Tour> tours = this.tourRepository.findAll();
            if (ObjectUtils.isEmpty(tours)) {
                return Collections.emptyList();
            }
            return tours.stream()
                    .map(this::convertTourToResponseDto)
                    .toList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TourServiceResponseDto getTourByLocation(String location) {
        try {
            Tour tour = this.tourRepository.findByLocation(location)
                    .orElseThrow(() -> new RuntimeException("Tour package not found for location: " + location));
            if (ObjectUtils.isEmpty(tour)) {
                throw new RuntimeException("Tour package not found for location: " + location);
            }
            return this.convertTourToResponseDto(tour);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    private Tour convertRequestToResponseDto(CreateTourServiceRequestDto requestDto) {
        Tour responseDto = new Tour();
        responseDto.setTitle(requestDto.getTitle());
        responseDto.setDescription(requestDto.getDescription());
        responseDto.setDuration(requestDto.getDuration());
        responseDto.setLocation(requestDto.getLocation());
        responseDto.setImage(requestDto.getImage());
        responseDto.setDiscountInPercentage(requestDto.getDiscountInPercentage());
        responseDto.setActualPrice(requestDto.getActualPrice());
        responseDto.setDiscountedPrice(requestDto.getDiscountedPrice());
        return responseDto;
    }

    private TourServiceResponseDto convertTourToResponseDto(Tour tour) {
        TourServiceResponseDto responseDto = new TourServiceResponseDto();
        responseDto.setId(tour.getId());
        responseDto.setTitle(tour.getTitle());
        responseDto.setDescription(tour.getDescription());
        responseDto.setDuration(tour.getDuration());
        responseDto.setLocation(tour.getLocation());
        responseDto.setImage(tour.getImage());
        responseDto.setDiscountInPercentage(tour.getDiscountInPercentage());
        responseDto.setActualPrice(tour.getActualPrice());
        responseDto.setDiscountedPrice(tour.getDiscountedPrice());
        return responseDto;
    }

}
