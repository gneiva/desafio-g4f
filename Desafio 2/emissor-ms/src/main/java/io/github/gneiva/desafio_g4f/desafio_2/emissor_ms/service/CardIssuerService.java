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
        // Cria o cartão de crédito com um número gerado
        CreditCard card = new CreditCard();
        card.setCardNumber(generateCardNumber());

        // Envia o e-mail de notificação com todos os dados do cartão
        notificationService.sendCardNotification(clientEmail, clientName, card.getCardNumber(), creditLimit, proposalId);

        return card;
    }

    private String generateCardNumber() {
        return "4000-1234-5678-9010"; // Exemplo, substituir por lógica real
    }
}

