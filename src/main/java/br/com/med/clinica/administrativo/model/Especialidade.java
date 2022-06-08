package br.com.med.clinica.administrativo.model;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Especialidade.
 */
@Entity
@Table(name = "especialidade")
public class Especialidade {

	/** The oid. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	/** The nome. */
	@Column(length = 250)
	private String nome;

	/**
	 * Instantiates a new especialidade.
	 *
	 * @param oid the oid
	 * @param nome the nome
	 */
	public Especialidade(Long oid, String nome) {
		super();
		this.oid = oid;
		this.nome = nome;
	}

	/**
	 * Instantiates a new especialidade.
	 */
	public Especialidade() {
	}

	/**
	 * Gets the oid.
	 *
	 * @return the oid
	 */
	public Long getOid() {
		return oid;
	}

	/**
	 * Sets the oid.
	 *
	 * @param oid the new oid
	 */
	public void setOid(Long oid) {
		this.oid = oid;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ");
		builder.append(oid);
		builder.append(" | Nome: ");
		builder.append(nome);
		return builder.toString();
	}

	/**
	 * Equals.
	 *
	 * @param o the o
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Especialidade))
			return false;

		Especialidade that = (Especialidade) o;

		return getOid().equals(that.getOid());
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return getOid().hashCode();
	}
}

