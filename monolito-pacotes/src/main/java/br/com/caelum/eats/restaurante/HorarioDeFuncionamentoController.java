package br.com.caelum.eats.restaurante;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class HorarioDeFuncionamentoController {

	private HorarioDeFuncionamentoRepository repo;
	
	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	HorarioDeFuncionamentoDto detalha(@PathVariable("id") Long id) {
		HorarioDeFuncionamento horario = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new HorarioDeFuncionamentoDto(horario);
	}

	@GetMapping("/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	List<HorarioDeFuncionamentoDto> lista(@PathVariable("idRestaurante") Long idRestaurante) {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(idRestaurante);
		List<HorarioDeFuncionamento> horariosDoRestaurante = repo.findAllByRestaurante(restaurante);
		return horariosDoRestaurante.stream().map(h -> new HorarioDeFuncionamentoDto(h)).collect(Collectors.toList());
	}

	@PostMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento")
	HorarioDeFuncionamentoDto adiciona(@RequestBody HorarioDeFuncionamento horarioDeFuncionamento) {
		return new HorarioDeFuncionamentoDto(repo.save(horarioDeFuncionamento));
	}

	@PutMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	HorarioDeFuncionamentoDto atualiza(@RequestBody HorarioDeFuncionamento horarioDeFuncionamento) {
		return new HorarioDeFuncionamentoDto(repo.save(horarioDeFuncionamento));
	}

	@DeleteMapping("/parceiros/restaurantes/{idRestaurante}/horarios-de-funcionamento/{id}")
	void remove(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}

}
