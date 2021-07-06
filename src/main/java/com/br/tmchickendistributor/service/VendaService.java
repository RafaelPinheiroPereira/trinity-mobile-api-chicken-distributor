package com.br.tmchickendistributor.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Venda;
import com.br.tmchickendistributor.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;

	public List<Venda> pesquisarRecebimentosDoFuncionario(long idNucleo, long idEmpresa) {

		return vendaRepository.pesquisarRecebimentosPorEmpresaENucleo(idNucleo, idEmpresa);

	}

	public List<Venda> pesquisarRecebimentosDoCliente(long idFuncionario, long idNucleo, long idEmpresa,
			long idCliente) {

		return vendaRepository.pesquisarTodosRecebimentosDoCliente(idNucleo, idEmpresa, idCliente, idFuncionario);

	}

	public LocalDateTime pesquisarDataMaximaUltimaSincronizacao(double id, long idEmpresa) {

		return vendaRepository.pesquisarDataDaUltimaSincronizacao(id, idEmpresa);
	}

}
