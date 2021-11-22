package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.model.Offers;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Long> {

    @Query(value = "SELECT offer_id FROM Offers WHERE user_id = ?1 ORDER BY offer_id DESC LIMIT 1", nativeQuery = true)
    Long findOfferByUserId(Long userId);

    @Query("SELECT r FROM Offers r where r.user.user_id = :id") 
    List<Offers> findIdByName(@Param("id") Long id);

    @Query("SELECT o FROM Offers o WHERE o.user.user_id = ?1")
    List<Offers> findOffersByUserId(Long userId);
}
