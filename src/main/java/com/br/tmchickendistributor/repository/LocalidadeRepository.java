package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Double> {

}
