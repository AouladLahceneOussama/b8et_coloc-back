package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import com.example.demo.model.Demands;

@Repository
public interface DemandsRepository extends JpaRepository<Demands, Long> {
    @Query("delete from Demands d  where d.room.room_id =?1 ")
    void deleteDemand(Long room_id);

    @Query("SELECT d FROM Demands d where d.statut = '0='")
    Collection<Demands> findDemand();
}