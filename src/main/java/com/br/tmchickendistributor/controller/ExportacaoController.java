package com.br.tmchickendistributor.controller;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tmchickendistributor.entity.Pedido;
import com.br.tmchickendistributor.entity.Recebimento;
import com.br.tmchickendistributor.model.Exportacao;
import com.br.tmchickendistributor.service.ExportacaoService;
import com.br.tmchickendistributor.service.PedidoService;
import com.br.tmchickendistributor.service.RecebimentoService;

@RestController
@RequestMapping(path = "api/exportacoes")

public class ExportacaoController {

	private static final Logger LOGGER = Logger.getLogger(ExportacaoController.class.getName());

	@Autowired
	ExportacaoService exportacaoService;

	@Autowired
	PedidoService pedidoService;

	@Autowired
	RecebimentoService recebimentoService;

	@PostMapping(value = "/pedidos")
	public boolean exportarPedido(@RequestBody Exportacao exportacao) {

		try {

			exportacao.getListaPedido().getPedidos().forEach(pedido -> {

				Optional<Pedido> optionalPedidoToSave = Optional
						.ofNullable(pedidoService.consultarPedidoPorCodigoVendaCodigoFuncionario(pedido));

				if (optionalPedidoToSave.isPresent()) {

					/** Realizar update */
					pedido.setId(optionalPedidoToSave.get().getId());

					Optional<Integer> optionalCodigoMigrado = Optional
							.ofNullable(optionalPedidoToSave.get().getMigrado());

					if (optionalCodigoMigrado.isPresent() && optionalCodigoMigrado.get().intValue() == 0) {
						pedidoService.salvar(pedido);

					}

				}
				/** Realizar insert */
				else
					pedidoService.salvar(pedido);

			});

			exportacao.getRecebimentos().forEach(recebimento -> {

				Optional<Recebimento> optionalRecebimentoToSave = Optional.ofNullable(
						recebimentoService.consultarRecebimentoPorCodigoVendaCodigoFuncionario(recebimento));
				if (optionalRecebimentoToSave.isPresent()) {

					/** Realizar update */
					recebimento.setId(optionalRecebimentoToSave.get().getId());

					Optional<Integer> optionalCodigoMigrado = Optional
							.ofNullable(optionalRecebimentoToSave.get().getMigrado());

					if (optionalCodigoMigrado.isPresent() && optionalCodigoMigrado.get().intValue() == 0) {
						recebimento.setMigrado(0);
						recebimentoService.salvar(recebimento);

					}

				} else {
					recebimento.setMigrado(0);
					recebimentoService.salvar(recebimento);
				}
			});

			return true;
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		return false;
	}

}
