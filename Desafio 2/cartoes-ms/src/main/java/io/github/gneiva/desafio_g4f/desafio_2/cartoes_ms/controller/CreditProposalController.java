package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.controller.DTO.CreditProposalRequestDTO;
import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model.Client;
import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model.CreditProposal;
import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.service.CreditProposalService;

@RestController
@RequestMapping("/api/proposals")
public class CreditProposalController {

    @Autowired
    private CreditProposalService proposalService;

    @PostMapping
    public CreditProposal createProposal(@RequestBody CreditProposalRequestDTO creditProposalRequest) {
        Client client = new Client();
        client.setName(creditProposalRequest.getClientName());
        client.setEmail(creditProposalRequest.getClientEmail());

        return proposalService.createProposal(client, creditProposalRequest.getLimit());
    }
}
