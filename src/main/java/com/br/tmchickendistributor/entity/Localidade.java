package com.br.tmchickendistributor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "localidades")
@Data
public class Localidade {

	@Id
	@Column(name = "loccod")
	private double id;

	@Column(name = "locnom")
	private String nome;

	@Column(name = "empcod")
	private double idEmpresa;

	@Column(name = "rotcod")
	private long idRota;

}
