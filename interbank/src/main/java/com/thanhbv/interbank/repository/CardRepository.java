package com.thanhbv.interbank.repository;

import com.thanhbv.interbank.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    Card save(Card card);
    Optional<Card> findById(String cardCode);
    @Query(value = "select secret_code from card where app_code = :appCode", nativeQuery = true)
    Optional<UUID> findBySecretCode(@Param("appCode") UUID appCode);
}
