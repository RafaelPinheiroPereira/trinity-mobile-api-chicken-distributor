package com.br.tmchickendistributor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Cliente;
import com.br.tmchickendistributor.entity.Funcionario;
import com.br.tmchickendistributor.entity.RecebimentoDTO;
import com.br.tmchickendistributor.entity.Venda;
import com.br.tmchickendistributor.error.MyResourceNotFoundException;
import com.br.tmchickendistributor.repository.ClienteRepository;
import com.br.tmchickendistributor.repository.FuncionarioRepository;
import com.br.tmchickendistributor.repository.PedidoRepository;
import com.br.tmchickendistributor.repository.RecebimentoRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRespository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	RecebimentoRepository recebimentoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	VendaService vendaService;

	public List<Cliente> consultarClientes(long idEmpresa) {

		return clienteRepository.pesquisarClientesPorRede(idEmpresa);

	}

	public long pesquisarCodigoMaximoDeVendaDoFuncionario(Funcionario funcionario) {
		return funcionarioRespository.pequisarMaximoIdVenda(funcionario.getId(), funcionario.getIdEmpresa());
	}

	public List<RecebimentoDTO> consultarRecebimentos(long idNucleo, long idEmpresa) {

		List<Venda> vendas = vendaService.pesquisarRecebimentosDoFuncionario(idNucleo, idEmpresa);
		List<RecebimentoDTO> recebimentoDTOs = new ArrayList<>();
		for (Venda venda : vendas) {
			recebimentoDTOs.add(RecebimentoDTO.transformaEmRecebimentoDTO(venda));
		}
		return recebimentoDTOs;
	}

	public List<RecebimentoDTO> consultarRecebimentos(long id, long idNucleo, long idEmpresa, long idCliente) {

		List<Venda> vendas = vendaService.pesquisarRecebimentosDoCliente(id, idNucleo, idEmpresa, idCliente);
		List<RecebimentoDTO> recebimentoDTOs = new ArrayList<>();
		for (Venda venda : vendas) {
			recebimentoDTOs.add(RecebimentoDTO.transformaEmRecebimentoDTO(venda));
		}
		return recebimentoDTOs;
	}

	public Funcionario pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(double id, long idEmpresa) {

		return Optional
				.ofNullable(funcionarioRespository.pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(id, idEmpresa))
				.orElseThrow(() -> new MyResourceNotFoundException("Funcionario nao encontrado"));

	}

	public String obterSenha(Funcionario funcionario) {
		return Optional.ofNullable(funcionario.getSenha())
				.orElseThrow(() -> new MyResourceNotFoundException("Funcionario sem senha"));
	}

	public long pesquisarCodigoMaximoDeReciboDoFuncionario(Funcionario funcionarioPesquisado) {

		return funcionarioRespository.pesquisarMaximoIdRecibo(funcionarioPesquisado.getId(),
				funcionarioPesquisado.getIdEmpresa());
	}

	public void atualizarDataUltimaSincronizacao(double id, LocalDateTime dataUltimaSincronizacao) {
		funcionarioRespository.atualizarDataUltimaSincronizacao(id, dataUltimaSincronizacao);

	}

}
