package com.br.tmchickendistributor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Dispositivo;
import com.br.tmchickendistributor.entity.Empresa;
import com.br.tmchickendistributor.entity.Nucleo;
import com.br.tmchickendistributor.repository.EmpresaRepository;

@Service
public class ConfiguracaoService {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	EmpresaService empresaService;
	@Autowired
	NucleoService nucleoService;

	@Autowired
	DispositivoService dispositivoService;

	public List<Nucleo> pesquisarNucleosAtivos(String cnpj, Date dataAtual) {
		return nucleoService.pesquisarNucleosAtivos(cnpj, dataAtual);
	}

	public List<Dispositivo> pesquisarDispositivosAtivos(String mac, Date dataAtual) {

		return dispositivoService.pesquisarDispositivosAtivos(mac, dataAtual);
	}

	public Empresa verificarAtivacaoDaEmpresa(String cnpj, Date dataAtual, String mac) {

		return empresaService.verificarStatusDaEmpresa(cnpj, dataAtual, mac);
	}

}
