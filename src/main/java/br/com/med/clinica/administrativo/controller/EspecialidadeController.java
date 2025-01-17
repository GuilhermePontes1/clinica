package br.com.med.clinica.administrativo.controller;

import br.com.med.clinica.administrativo.model.Especialidade;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller()
public class EspecialidadeController {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("/especialidade")
	public String listEspecialidade(Model model) {

//FIX: 		
//  	List<Especialidade> especialidades = new ArrayList<Especialidade>();
//
//		especialidades.add(especialidadeRepository.findById(1l).get());
//		especialidades.add(especialidadeRepository.findById(2l).get());
//		especialidades.add(especialidadeRepository.findById(3l).get());
		
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		model.addAttribute("especialidades", especialidades);

		return "/administrativo/especialidade";
	}

	//Cadastro de Especialidade
	@GetMapping("/especialidade/form")
	public String form(Model model, @Param(value = "id") Long id) {
		Especialidade especialidade = new Especialidade();
		if (id != null) {
			Optional<Especialidade> op = especialidadeRepository.findById(id);
			if (op.isPresent()) {
				especialidade = op.get();
			}
		}
		model.addAttribute("especialidade", especialidade);

		return "/administrativo/especialidadeform";
	}

}