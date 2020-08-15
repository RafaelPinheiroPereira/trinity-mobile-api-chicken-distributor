package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.ClienteGrupo;

@Repository
public interface ClienteGrupoRepository extends JpaRepository<ClienteGrupo, Double> {

}
