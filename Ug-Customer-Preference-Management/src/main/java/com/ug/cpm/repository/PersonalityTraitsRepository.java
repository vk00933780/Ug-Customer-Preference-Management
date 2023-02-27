package com.ug.cpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.cpm.entity.CustomerPersonalityTrait;

public interface PersonalityTraitsRepository extends JpaRepository<CustomerPersonalityTrait, Integer>{

	
}
