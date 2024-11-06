package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model.Client;
import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.model.CreditProposal;
import io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms.repository.CreditProposalRepository;

@Service
public class CreditProposalService {

	@Value("${emissor.ms.url}")
    private String emissorMsUrl;
	
    @Autowired
    private CreditProposalRepository proposalRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    public CreditProposal createProposal(Client client, BigDecimal creditLimit) {
        CreditProposal proposal = new CreditProposal();
        proposal.setClient(client);
        proposal.setCreditLimit(creditLimit);
        CreditProposal savedProposal = proposalRepository.save(proposal);
        issueCard(savedProposal);
        return savedProposal;
    }
    
    private void issueCard(CreditProposal proposal) {
        // Monta o payload da requisição para o emissor-ms
        Map<String, Object> request = new HashMap<>();
        request.put("clientName", proposal.getClient().getName());
        request.put("clientEmail", proposal.getClient().getEmail());
        request.put("creditLimit", proposal.getCreditLimit());
        request.put("proposalId", proposal.getId());

        restTemplate.postForObject(emissorMsUrl, request, String.class);
    }
}
