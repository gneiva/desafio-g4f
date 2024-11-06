package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.controller.DTO;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditProposalRequestDTO {

	private String clientName;
	private String clientEmail;
	private BigDecimal limit;
	
}
