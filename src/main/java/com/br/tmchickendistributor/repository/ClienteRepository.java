package com.br.tmchickendistributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Double> {

	@Query(value = "SELECT c.* FROM clientes c,clientegrupos cg "
			+ "WHERE c.gpccod=cg.gpccod and c.empcod=cg.empcod and cg.empcod=?1 ", nativeQuery = true)
	public List<Cliente> pesquisarClientesPorRede(long idEmpresa);

	@Query(value = "SELECT c.* FROM clientes c," + "rotas r," + "localidades l " + "WHERE c.empcod=l.empcod"
			+ " and c.loccod=l.loccod" + " and r.rotcod=1" + " and c.empcod = ?1 group by c.clicod", nativeQuery = true)
	public List<Cliente> pesquisarClientesPorRota(long idEmpresa);

}
