package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.ClienteFuncionario;
import com.br.tmchickendistributor.entity.ClienteFuncionarioID;

@Repository
public interface ClienteFuncionarioRepository extends JpaRepository<ClienteFuncionario, ClienteFuncionarioID> {

}
