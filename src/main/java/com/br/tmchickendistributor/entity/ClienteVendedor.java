package com.br.tmchickendistributor.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "clientesvendedores")
@NoArgsConstructor
@Data
public class ClienteVendedor {

	@EmbeddedId
	ClienteVendedorID chavesClienteVendedorID;

	@Column(name = "cliprz", nullable = false)
	private long cliprz;

}
