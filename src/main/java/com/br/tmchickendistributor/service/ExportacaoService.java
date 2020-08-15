package com.br.tmchickendistributor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.repository.PedidoRepository;

@Service
public class ExportacaoService {

    @Autowired
    PedidoService PedidoService;
    @Autowired
    ItemPedidoService itemPedidoService;

    @Autowired
    PedidoRepository pedidoRepository;

}
