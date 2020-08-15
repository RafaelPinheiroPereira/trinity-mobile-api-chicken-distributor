package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.ItemPedido;
import com.br.tmchickendistributor.entity.ItemPedidoID;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoID> {

}
