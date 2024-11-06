package io.github.gneiva.desafio_g4f.desafio_2.emissor_ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendCardNotification(String to, String clientName, String cardNumber, BigDecimal creditLimit, Long proposalId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Seu Cartão de Crédito foi Emitido");

        // Corpo do e-mail com todas as informações
        message.setText(
                "Olá " + clientName + ",\n\n" +
                "Estamos felizes em informar que seu cartão de crédito foi emitido com sucesso!\n" +
                "Aqui estão os detalhes do seu cartão:\n\n" +
                "Número do Cartão: " + cardNumber + "\n" +
                "Limite de Crédito: R$ " + creditLimit + "\n" +
                "ID da Proposta: " + proposalId + "\n\n" +
                "Agradecemos por escolher nosso banco.\n" +
                "Atenciosamente,\n" +
                "Equipe de Emissão de Cartões"
        );

        mailSender.send(message);
    }
}
