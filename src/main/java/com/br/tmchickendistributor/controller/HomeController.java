package com.br.tmchickendistributor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tmchickendistributor.model.Importacao;
import com.br.tmchickendistributor.repository.RecebimentoRepository;
import com.br.tmchickendistributor.service.FuncionarioService;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    @Autowired
    RecebimentoRepository recebimentoRepository;
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping()
    public String verificarStatusAplicacao() {

        return " Trinity Mobile Chicken Distributor";
    }

    @GetMapping("/recebimentos")
    @ResponseBody
    public ResponseEntity<Importacao> realizarImportacao(@RequestParam(value = "id") long id, @RequestParam(value = "idEmpresa") long idEmpresa,
        @RequestParam(value = "idNucleo") long idNucleo, @RequestParam(value = "idCliente") long idCliente) {

        Importacao importacao = new Importacao();
        importacao.setRecebimentosDTO(funcionarioService.consultarRecebimentos(id, idNucleo, idEmpresa, idCliente));
        return ResponseEntity.status(HttpStatus.OK).body(importacao);

    }

}
