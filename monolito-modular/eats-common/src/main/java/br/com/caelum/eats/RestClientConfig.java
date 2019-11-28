package br.com.caelum.eats;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by afonsoaoc on 09/07/19.
 */
@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

}
