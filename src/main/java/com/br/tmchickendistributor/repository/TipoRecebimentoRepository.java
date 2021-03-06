
package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.TipoRecebimento;

/**
 * Desenvolvido por Rafael Pinheiro em 19 de out de 2018
 * 
 */

@Repository
public interface TipoRecebimentoRepository extends JpaRepository<TipoRecebimento, Double> {

}
