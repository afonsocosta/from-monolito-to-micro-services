package br.com.devaoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Document(collection = "restaurantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

	@Id
	private Long id;

	private String cep;
	
	private Boolean aprovado;

	private Long tipoDeCozinhaId;

}
