package com.quyvx.ecobike.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "card_code")
    private String cardCode;

    @Column(name = "owner")
    private String owner;

    @Column(name = "dateExpired")
    private String dateExpired;

    @Column(name = "cvv_code")
    private String cvvCode;

    @Column(name = "command")
    private String command;
    @Column(name = "content")
    private String transactionContent;

    @Column(name = "amount")
    private long amount;

    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "error_code")
    private int errorCode;
}
