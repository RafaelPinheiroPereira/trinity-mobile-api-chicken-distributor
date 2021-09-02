package com.br.tmchickendistributor.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClienteVendedorID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "empcod")
	private long idEmpresa;
	@Column(name = "clicod")
	private long idCliente;
	@Column(name = "funcod")
	private long idFuncionario;
	@Column(name = "tprcod")
	private long idTipoRecebimento;

}
