package com.br.tmchickendistributor.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

    @Query(
        value = "SELECT e.* FROM empresas e "
            + "WHERE  e.empcnpj=?1 and e.empdtf>=?2 ",
        nativeQuery = true)
    public Empresa verificarStatusDaEmpresa(String cnpj, Date dataAtual);
}
