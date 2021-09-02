package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Funcionario;
import com.br.tmchickendistributor.entity.Rota;
import com.br.tmchickendistributor.repository.RotaRepository;

@Service
public class RotaService {
	@Autowired
	RotaRepository rotaRepository;

	public List<Rota> obterRotasDoVendedor(Funcionario funcionario) {
		return rotaRepository.consultarRotasPorVendendor(funcionario.getId(), funcionario.getIdEmpresa());
	}
}
