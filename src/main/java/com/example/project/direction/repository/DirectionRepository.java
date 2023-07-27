package com.example.project.direction.repository;

import com.example.project.direction.entity.Direction;
import com.example.project.pharmacy.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
}
