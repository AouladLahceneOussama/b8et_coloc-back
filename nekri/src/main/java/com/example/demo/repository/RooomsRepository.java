package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.model.Rooms;

@Repository
public interface RooomsRepository extends JpaRepository<Rooms, Long >{
    @Query("SELECT r FROM Rooms r where r.offer.offer_id = :id") 
    List<Rooms> getRoomsByOfferId(@Param("id") Long id);

    // @Query("select r from Rooms r where r.offer.offer_id =?1 ")
    // List<Rooms> getRoomsByOfferId(Long offer_id);
}

