package com.br.tmchickendistributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Double> {

	@Query(value = "SELECT  l.* FROM localidades l, rotas r, clientes c" + "  WHERE c.loccod=l.loccod "
			+ "and c.empcod = l.empcod " + "and l.rotcod=r.rotcod " + "and r.rotcod = 1 "
			+ " and c.clicod = ?1 and l.empcod = ?2", nativeQuery = true)
	public Localidade consultarLocalidadeDoCliente(double idCliente, double idEmpresa);
}
