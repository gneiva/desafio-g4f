package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model;


import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CreditProposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name ="credit_limit")
    private BigDecimal creditLimit;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
}
