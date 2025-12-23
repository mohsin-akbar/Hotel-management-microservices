package com.hospitalService.repository;

import com.hospitalService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel ,String> {
}
