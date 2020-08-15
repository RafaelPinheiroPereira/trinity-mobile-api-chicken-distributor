package com.br.tmchickendistributor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.ItemPedido;
import com.br.tmchickendistributor.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public void salvar(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);

    }

}
