package com.br.tmchickendistributor.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tmchickendistributor.entity.Funcionario;
import com.br.tmchickendistributor.model.Importacao;
import com.br.tmchickendistributor.service.ClienteGrupoService;
import com.br.tmchickendistributor.service.ClienteVendedorService;
import com.br.tmchickendistributor.service.ContaService;
import com.br.tmchickendistributor.service.FuncionarioService;
import com.br.tmchickendistributor.service.PrecoService;
import com.br.tmchickendistributor.service.ProdutoService;
import com.br.tmchickendistributor.service.RotaService;
import com.br.tmchickendistributor.service.TipoRecebimentoService;
import com.br.tmchickendistributor.service.UnidadeService;
import com.br.tmchickendistributor.service.VendaService;

@RestController
@RequestMapping(path = "api/importacoes")
public class ImportacaoController {

	@Autowired
	PrecoService precoService;
	@Autowired
	FuncionarioService funcionarioService;
	@Autowired
	UnidadeService unidadeService;
	@Autowired
	ProdutoService produtoService;
	@Autowired
	ContaService contaService;
	@Autowired
	TipoRecebimentoService tipoRecebimentoService;
	@Autowired
	VendaService vendaService;
	@Autowired
	ClienteGrupoService clienteGrupoService;
	@Autowired
	RotaService rotaService;

	@Autowired
	ClienteVendedorService clienteVendedorService;

	@GetMapping("/funcionarios")
	@ResponseBody
	public ResponseEntity<Importacao> realizarImportacao(@RequestParam(value = "id") long id,
			@RequestParam(value = "idEmpresa") long idEmpresa, @RequestParam(value = "idNucleo") long idNucleo) {

		Importacao importacao = new Importacao();
		Funcionario funcionarioPesquisado = funcionarioService.pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(id,
				idEmpresa);

		long maximoCodigoDeRecebimento = funcionarioService
				.pesquisarCodigoMaximoDeReciboDoFuncionario(funcionarioPesquisado);
		LocalDateTime dataUltimaSincronizacao = vendaService.pesquisarDataMaximaUltimaSincronizacao(id, idEmpresa);

		funcionarioPesquisado.setMaxIdRecibo(maximoCodigoDeRecebimento);
		funcionarioService.atualizarDataUltimaSincronizacao(id, dataUltimaSincronizacao);
		funcionarioPesquisado.setDataUltimaSincronizacao(dataUltimaSincronizacao);

		importacao.setClientes(funcionarioService.consultarClientes(idEmpresa));
		importacao.setPrecos(precoService.consultarPrecos(idEmpresa, idNucleo));
		importacao.setProdutos(produtoService.consultarProdutos(idEmpresa, idNucleo));
		importacao.setRecebimentosDTO(funcionarioService.consultarRecebimentos(idNucleo, idEmpresa));
		importacao.setRotas(rotaService.obterRotasDoVendedor(funcionarioPesquisado));

		importacao.setUnidades(unidadeService.consultarUnidadePorProdutoEPreco(idEmpresa, idNucleo));
		importacao.setContas(contaService.getContas(idEmpresa, idNucleo));
		importacao.setClientesGrupos(clienteGrupoService.getClientesGrupos(idEmpresa));
		importacao.setClientesVendedores(clienteVendedorService.pesquisarClienteVendedorPorIdEmpresa(idEmpresa));
		importacao.setFuncionarios(funcionarioService.pesquisarFuncionariosDaEmpresa(idEmpresa));
		importacao.setFuncionario(funcionarioPesquisado);

		return ResponseEntity.status(HttpStatus.OK).body(importacao);

	}

}
