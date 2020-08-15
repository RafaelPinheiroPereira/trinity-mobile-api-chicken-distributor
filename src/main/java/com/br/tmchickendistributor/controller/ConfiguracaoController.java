package com.br.tmchickendistributor.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tmchickendistributor.entity.Dispositivo;
import com.br.tmchickendistributor.entity.Empresa;
import com.br.tmchickendistributor.entity.Nucleo;
import com.br.tmchickendistributor.model.Configuracao;
import com.br.tmchickendistributor.service.ConfiguracaoService;
import com.br.tmchickendistributor.util.DataUtil;

@RestController
@RequestMapping(path = "api/configuracoes")
public class ConfiguracaoController {

    @Autowired
    ConfiguracaoService configuracaoService;

    @GetMapping(value = "/ativada")
    @ResponseBody
    public ResponseEntity<?> verificarAtivacao(@RequestParam(value = "cnpj") String cnpj, @RequestParam(value = "mac") String mac)
        throws ParseException {
        Date dataAtual = DataUtil.formatarDateParaddMMyyyyhhmm(new Date(System.currentTimeMillis()));

        Optional<Empresa> optionalEmpresa = Optional.ofNullable(configuracaoService.verificarAtivacaoDaEmpresa(cnpj, dataAtual));

        if (optionalEmpresa.isPresent()) {
            // acesso autorizado

            Empresa empresa = optionalEmpresa.get();

            Optional<List<Nucleo>> optionalNucleos = Optional.ofNullable(configuracaoService.pesquisarNucleosAtivos(cnpj, dataAtual));
            Optional<List<Dispositivo>> optionalDispositivos = Optional.ofNullable(configuracaoService.pesquisarDispositivosAtivos(mac, dataAtual));

            if (optionalNucleos.isPresent() && optionalDispositivos.get().size() > 0) {
                empresa.setNucleos(optionalNucleos.get());

            } else {
                empresa.setNucleos(new ArrayList<Nucleo>());
            }

            if (optionalDispositivos.isPresent() && optionalDispositivos.get().size() > 0) {

                optionalDispositivos.get().forEach(dispositivo -> {
                    dispositivo.setAtivo("true");
                });
                empresa.setDispositivos(optionalDispositivos.get());
                empresa.setAtivo("true");
                return new ResponseEntity<>(new Configuracao(empresa), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        } else {
            // acesso nao autorizado
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

}
