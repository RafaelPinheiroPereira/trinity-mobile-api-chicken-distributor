package com.br.tmchickendistributor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.tmchickendistributor.entity.Preco;
import com.br.tmchickendistributor.entity.PrecoID;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, PrecoID> {

    @Query(value = "SELECT p.* FROM precos p  where  p.empcod=?1 and p.nuccod=?2 "

        + "ORDER BY prcdat DESC ",
        nativeQuery = true)
    public List<Preco> pesquisarPrecos(long idEmpresa, long idNucleo);
}
