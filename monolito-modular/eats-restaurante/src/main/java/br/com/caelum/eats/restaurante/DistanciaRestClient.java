package br.com.caelum.eats.restaurante;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by afonsoaoc on 09/07/19.
 */

@Slf4j
@Service
public class DistanciaRestClient {

    private RestTemplate restTemplate;
    private String url;

    public DistanciaRestClient(RestTemplate restTemplate, @Value("${configuracao.distancia.service.url}") String url){
        this.restTemplate = restTemplate;
        this.url = url;

    }

    public void novoRestauranteAprovado(Restaurante restaurante){
        RestauranteParaServicoDeDistancia reDistancia = new RestauranteParaServicoDeDistancia(restaurante);
        ResponseEntity<RestauranteParaServicoDeDistancia> responseEntity = restTemplate.postForEntity(url +"/restaurante", reDistancia, RestauranteParaServicoDeDistancia.class);
        HttpStatus statusCode = responseEntity.getStatusCode();

        if(!HttpStatus.CREATED.equals(statusCode)){
            throw new RuntimeException("Status diferente do esperado: "+ statusCode);
        }
    }


    public void restauranteAtualizado(Restaurante restaurante){
        log.info("monolito tentando chamar distancia-service");
        RestauranteParaServicoDeDistancia reDistancia = new RestauranteParaServicoDeDistancia(restaurante);
        restTemplate.put(url + "/restaurante/" + restaurante.getId(), reDistancia, RestauranteParaServicoDeDistancia.class);
    }

}
