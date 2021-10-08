package com.br.tmchickendistributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.tmchickendistributor.entity.ClienteVendedor;
import com.br.tmchickendistributor.entity.ClienteVendedorID;

public interface ClienteVendedorRepository extends JpaRepository<ClienteVendedor, ClienteVendedorID> {
	@Query(value = "SELECT cv.* FROM clientevendedores cv  where  cv.empcod=?1 ", nativeQuery = true)
	public List<ClienteVendedor> pesquisaClienteVendedorPorIdEmpresa(long idEmpresa);
}
