package com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoRequest;
import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoResponse;
import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.service.CalculadoraService;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
	@Autowired
	private CalculadoraService calculadoraService;

	@PostMapping("/somar")
	public OperacaoResponse somar(@RequestBody OperacaoRequest request) {
		return calculadoraService.somar(request);
	}

	@PostMapping("/subtrair")
	public OperacaoResponse subtrair(@RequestBody OperacaoRequest request) {
		return calculadoraService.subtrair(request);
	}

	@PostMapping("/multiplicar")
	public OperacaoResponse multiplicar(@RequestBody OperacaoRequest request) {
		return calculadoraService.multiplicar(request);
	}

	@PostMapping("/dividir")
	public OperacaoResponse dividir(@RequestBody OperacaoRequest request) {
		return calculadoraService.dividir(request);
	}
}
