package br.com.med.clinica.agendamento.repository;

import br.com.med.clinica.agendamento.model.Convenio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvenioRepository extends CrudRepository<Convenio, Long>{

	
	List<Convenio> findAll();

}
