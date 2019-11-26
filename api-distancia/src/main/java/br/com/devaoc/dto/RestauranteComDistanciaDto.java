package br.com.devaoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestauranteComDistanciaDto {

	private Long restauranteId;

	private BigDecimal distancia;

}
