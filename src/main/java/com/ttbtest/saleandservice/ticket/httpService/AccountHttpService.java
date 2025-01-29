package com.ttbtest.saleandservice.ticket.httpService;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AccountHttpService {

    private WebClient webClient;

    public AccountHttpService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    public String getIdAccount(Integer customerId,Integer accountId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/account/{customerId}/{accountId}") // ใส่ PathVariable
                        .build(customerId,accountId))
                .retrieve()
                .bodyToFlux(String.class)
                .blockFirst();

    }

}
