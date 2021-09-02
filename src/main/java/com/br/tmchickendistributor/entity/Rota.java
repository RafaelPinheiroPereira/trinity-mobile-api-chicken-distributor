package com.br.tmchickendistributor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "rotas")
@NoArgsConstructor
@Data
public class Rota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "rotcod", nullable = false)
	private long id;

	@Column(name = "empcod")
	private double idEmpresa;

	@Column(name = "rotnom", nullable = false)
	private String descricao;

	public Rota(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

}
