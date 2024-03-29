package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Produto;
import com.br.tmchickendistributor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> consultarProdutos(long idEmpresa, long idNucleo) {

		return produtoRepository.pesquisarProdutos(idEmpresa, idNucleo);
	}

}
