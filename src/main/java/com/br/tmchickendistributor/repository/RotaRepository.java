package com.br.tmchickendistributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {

	@Query(value = "SELECT  r.rotcod,r.rotnom,r.empcod FROM clientes c , rotas r , localidades l, clientevendedores cv"
			+ "  WHERE cv.clicod=c.clicod and c.loccod=l.loccod and l.rotcod=r.rotcod and"
			+ " cv.funcod = ?1 and r.empcod = ?2 group by r.rotcod,r.rotnom,r.empcod ", nativeQuery = true)
	public List<Rota> consultarRotasPorVendendor(double idFuncionario, double idEmpresa);

}
