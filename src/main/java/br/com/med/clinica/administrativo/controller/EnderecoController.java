package br.com.med.clinica.administrativo.controller;

import br.com.med.clinica.administrativo.model.Endereco;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller()
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping("/endereco")
	public String listEndereco(Model model) {
		List<Endereco> enderecos = enderecoRepository.findAll();
		model.addAttribute("enderecos", enderecos);
		return "/administrativo/endereco";
	}

	@GetMapping("/endereco/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Endereco endereco = new Endereco();
		if (id != null) {
			Optional<Endereco> op = enderecoRepository.findById(id);
			if (op.isPresent()) {
				endereco = op.get();
			}
		}
		model.addAttribute("endereco", endereco);

		return "/administrativo/enderecoform";
	}

	@GetMapping("/endereco/delete")
	public String delete(Long id) {
		enderecoRepository.deleteById(id);
		return "redirect:/endereco";
	}

}
