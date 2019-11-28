package br.com.devaoc.controller;

import br.com.devaoc.exception.ResourceNotFoundException;
import br.com.devaoc.model.Restaurante;
import br.com.devaoc.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@AllArgsConstructor
@Slf4j
public class RestauranteController {

    private RestauranteRepository restauranteRepository;

    @PostMapping("/restaurante")
    public ResponseEntity<Restaurante> adiciona(@RequestBody Restaurante restaurante, UriComponentsBuilder uriBuilder){
        log.info("Insere novo restaurante: " + restaurante);
        Restaurante newRestaurante = restauranteRepository.insert(restaurante);
        UriComponents uriComponents = uriBuilder.path("restaurantes/{id}").buildAndExpand(newRestaurante.getId());
        URI uri = uriComponents.toUri();
        return ResponseEntity.created(uri).contentType(MediaType.APPLICATION_JSON).body(newRestaurante);
    }


    @PutMapping("/restaurantes/{id}")
    public Restaurante atualiza(@PathVariable Long id, @RequestBody Restaurante restaurante){

        //throw new RuntimeException("Erro simulado");

        if(!restauranteRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }
        log.info("Atualiza restaurante:" + restaurante);
        return restauranteRepository.save(restaurante);

    }


}
