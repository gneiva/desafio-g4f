package io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.controller;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.model.CreditCard;
import io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.service.CardIssuerService;

@RestController
@RequestMapping("/api/cards")
public class CardIssuerController {

    @Autowired
    private CardIssuerService issuerService;

    @PostMapping("/issue")
    public CreditCard issueCard(@RequestBody Map<String, Object> requestData) {
        String clientName = (String) requestData.get("clientName");
        String clientEmail = (String) requestData.get("clientEmail");
        BigDecimal creditLimit = new BigDecimal(requestData.get("creditLimit").toString());
        Long proposalId = Long.valueOf(requestData.get("proposalId").toString());

        return issuerService.issueCard(clientName, clientEmail, creditLimit, proposalId);
    }
}
