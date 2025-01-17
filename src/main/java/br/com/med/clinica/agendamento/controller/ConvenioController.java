package br.com.med.clinica.agendamento.controller;

import br.com.med.clinica.agendamento.model.Convenio;
import br.com.med.clinica.agendamento.repository.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ConvenioController {

	@Autowired
	private ConvenioRepository convenioRepository;

	@GetMapping("/convenio")
	public String listConvenio(Model model) {
		List<Convenio> convenios =  convenioRepository.findAll();
		model.addAttribute("convenios",convenios);
		return "/agendamento/convenio";
	}
	
	@GetMapping("/convenio/form")
	public String form(Model model,@Param(value = "id") Long id) {
		Convenio convenio = new Convenio();
		if(id != null) {
			Optional<Convenio> op = convenioRepository.findById(id);
			if(op.isPresent()) {
				convenio = op.get();
			}
		}
		model.addAttribute("convenio",convenio);
		
		return "/agendamento/convenioform";
	}
	
	@PostMapping("/convenio/salvar")
	public String salvar(Convenio convenio) {
		convenioRepository.save(convenio);
		return "redirect:/convenio";
	}
	

	@GetMapping("/convenio/delete")
	public String delete(Long id) {
		convenioRepository.deleteById(id);
		return "redirect:/convenio";
	}

}
