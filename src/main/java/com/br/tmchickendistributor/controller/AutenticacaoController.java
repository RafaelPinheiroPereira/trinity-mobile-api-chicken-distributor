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
import com.br.tmchickendistributor.service.AutenticacaoService;
import com.br.tmchickendistributor.service.FuncionarioService;
import com.br.tmchickendistributor.service.VendaService;

@RestController
@RequestMapping(path = "api/autenticacoes")
public class AutenticacaoController {

	@Autowired
	AutenticacaoService autenticacaoService;

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	VendaService vendaService;

	@GetMapping(value = "/funcionarios")
	@ResponseBody
	public ResponseEntity<Funcionario> autenticar(@RequestParam(value = "id") double id,
			@RequestParam(value = "senha") String senha, @RequestParam(value = "idEmpresa") long idEmpresa) {

		Funcionario funcionarioPesquisado = funcionarioService.pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(id,
				idEmpresa);

		if (autenticacaoService.isSenhaValida(funcionarioPesquisado, senha)) {
			long maximoCodigoDeVenda = funcionarioService
					.pesquisarCodigoMaximoDeVendaDoFuncionario(funcionarioPesquisado);
			long maximoCodigoDeRecebimento = funcionarioService
					.pesquisarCodigoMaximoDeReciboDoFuncionario(funcionarioPesquisado);
			LocalDateTime dataUltimaSincronizacao = vendaService.pesquisarDataMaximaUltimaSincronizacao(id, idEmpresa);
			funcionarioPesquisado.setMaxIdVenda(maximoCodigoDeVenda);
			funcionarioPesquisado.setMaxIdRecibo(maximoCodigoDeRecebimento);
			funcionarioService.atualizarDataUltimaSincronizacao(id, dataUltimaSincronizacao);
			funcionarioPesquisado.setDataUltimaSincronizacao(dataUltimaSincronizacao);
			return new ResponseEntity<>(funcionarioPesquisado, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

}
