package com.br.tmchickendistributor.model;

import java.util.List;

import com.br.tmchickendistributor.entity.ListaPedido;
import com.br.tmchickendistributor.entity.Recebimento;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Exportacao {

    ListaPedido listaPedido;
    List<Recebimento> recebimentos;

}
