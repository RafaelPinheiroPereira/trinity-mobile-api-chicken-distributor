package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Conta;
import com.br.tmchickendistributor.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> getContas(long idEmpresa, long idNucleo) {

        return contaRepository.pesquisarContas(idEmpresa, idNucleo);
    }

}
