package com.ug.cpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.cpm.entity.CustomerBookingHistory;

public interface BookingHistoryRepository extends JpaRepository<CustomerBookingHistory, Integer>{

}
