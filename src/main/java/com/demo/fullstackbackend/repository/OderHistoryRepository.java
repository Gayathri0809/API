package com.demo.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.fullstackbackend.model.OrderHistory;

public interface OderHistoryRepository extends JpaRepository<OrderHistory,Long> {

}
