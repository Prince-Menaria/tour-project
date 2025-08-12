package com.tour_service.Tour_Package_Management.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour_service.Tour_Package_Management.entity.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {

    public Optional<Tour> findByLocation(String location);

}
