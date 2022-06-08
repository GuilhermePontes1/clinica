package br.com.med.clinica.atendimento.repository;

import br.com.med.clinica.atendimento.model.Droga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrogaRepository extends CrudRepository<Droga, Long> {

	List<Droga> findAll();

}
