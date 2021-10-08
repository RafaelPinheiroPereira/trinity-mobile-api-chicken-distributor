package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.ClienteVendedor;
import com.br.tmchickendistributor.repository.ClienteVendedorRepository;

@Service
public class ClienteVendedorService {
	@Autowired
	ClienteVendedorRepository clienteVendedorRepository;

	public List<ClienteVendedor> pesquisarClienteVendedorPorIdEmpresa(long idEmpresa) {
		return clienteVendedorRepository.pesquisaClienteVendedorPorIdEmpresa(idEmpresa);
	}
}
