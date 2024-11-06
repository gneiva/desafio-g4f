package io.github.gneiva.desafio_g4f.desafio_2.cartoes_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CartoesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartoesMsApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
