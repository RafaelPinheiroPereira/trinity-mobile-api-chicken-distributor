package com.br.tmchickendistributor.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Empresa;
import com.br.tmchickendistributor.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRespository;

    public Empresa verificarStatusDaEmpresa(String cnpj, Date dataAtual, String mac) {
        // TODO Auto-generated method stub
        return empresaRespository.verificarStatusDaEmpresa(cnpj, dataAtual, mac);
    }

}
