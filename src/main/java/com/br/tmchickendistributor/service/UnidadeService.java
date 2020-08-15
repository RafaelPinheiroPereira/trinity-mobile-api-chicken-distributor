package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Unidade;
import com.br.tmchickendistributor.repository.UnidadeRepository;

@Service
public class UnidadeService {

    @Autowired
    UnidadeRepository unidadeRepository;

    public List<Unidade> consultarUnidadePorProdutoEPreco(long idEmpresa, long idNucleo) {

        List<Unidade> unidades = unidadeRepository.consultarUnidadePorProdutoEPreco(idEmpresa, idNucleo);
        return unidades;
    }
}
