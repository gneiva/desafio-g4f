package io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.model.CreditCard;

@Service
public class CardIssuerService {

    private final EmailNotificationService notificationService;

    @Autowired
    public CardIssuerService(EmailNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public CreditCard issueCard(String clientName, String clientEmail, BigDecimal creditLimit, Long proposalId) {
        //TODO Implementar todas as regras para criação do cartão de crédito, aqui vamos apenas criar um cartão com um numero aleatório simulando a criação
        CreditCard card = new CreditCard();
        card.setCardNumber(generateCardNumber());

        notificationService.sendCardNotification(clientEmail, clientName, card.getCardNumber(), creditLimit, proposalId);
        return card;
    }

    private String generateCardNumber() {
    	//TODO implementar regra para gerar um número de cartão válido, para fins de simulação vamos retornar um número fixo    	
        return "4000-1234-5678-9010";
    }
}

