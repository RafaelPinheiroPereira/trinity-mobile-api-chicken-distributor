package com.br.tmchickendistributor.model;

import java.util.List;

import com.br.tmchickendistributor.entity.Cliente;
import com.br.tmchickendistributor.entity.ClienteGrupo;
import com.br.tmchickendistributor.entity.Conta;
import com.br.tmchickendistributor.entity.Preco;
import com.br.tmchickendistributor.entity.Produto;
import com.br.tmchickendistributor.entity.RecebimentoDTO;
import com.br.tmchickendistributor.entity.Unidade;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Importacao {

    List<Cliente> clientes;

    List<Produto> produtos;
    List<Unidade> unidades;
    List<Preco> precos;
    List<RecebimentoDTO> recebimentosDTO;
    List<Conta> contas;
    List<ClienteGrupo> clientesGrupos;

}
