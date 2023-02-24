package com.ug.cpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.cpm.entity.CustomerPreference;

public interface CustomerPreferenceRepository extends JpaRepository<CustomerPreference, Integer>{

}
