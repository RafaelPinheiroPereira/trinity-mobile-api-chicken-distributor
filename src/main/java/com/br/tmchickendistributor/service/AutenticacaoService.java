package com.br.tmchickendistributor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tmchickendistributor.entity.Funcionario;

@Service
public class AutenticacaoService {

    @Autowired
    FuncionarioService funcionarioService;

    public boolean isSenhaValida(Funcionario funcionario, String senha) {

        String senhaDoFuncionarioPesquisado = funcionarioService.obterSenha(funcionario);

        return senhaDoFuncionarioPesquisado.equals(senha) ? true : false;

    }

}
