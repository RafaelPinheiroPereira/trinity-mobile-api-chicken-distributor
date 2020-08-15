package com.br.tmchickendistributor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.ClienteGrupo;
import com.br.tmchickendistributor.repository.ClienteGrupoRepository;

@Service
public class ClienteGrupoService {

    @Autowired
    ClienteGrupoRepository clienteGrupoRepository;

    public List<ClienteGrupo> getClientesGrupos(long idEmpresa) {

        return clienteGrupoRepository.pesquisarClienteGrupo(idEmpresa);
    }

}
