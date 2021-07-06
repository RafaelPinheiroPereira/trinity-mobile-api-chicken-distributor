package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.TipoRecebimento;
import com.br.tmchickendistributor.repository.TipoRecebimentoRepository;

@Service
public class TipoRecebimentoService {

	@Autowired
	TipoRecebimentoRepository tipoRecebimentoRepository;

	public List<TipoRecebimento> consultarTiposRecebimento() {
		return tipoRecebimentoRepository.findAll();
	}

}
