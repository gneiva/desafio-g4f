package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model.CreditProposal;

public interface CreditProposalRepository extends JpaRepository<CreditProposal, Long> {
}
