package br.com.med.clinica.agendamento.model;

import javax.persistence.*;

@Entity
@Table(name = "convenios")
public class Convenio {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	
	@Column(length = 250)
	private String nome;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	
	
	
}
