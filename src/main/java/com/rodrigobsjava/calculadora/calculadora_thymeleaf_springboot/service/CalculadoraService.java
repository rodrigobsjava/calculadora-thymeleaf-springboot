package com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.service;

import org.springframework.stereotype.Service;

import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoRequest;
import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoResponse;

@Service
public class CalculadoraService {
	
	public OperacaoResponse somar(OperacaoRequest request) {
		double resultado = request.a() + request.b();
		return new OperacaoResponse(resultado);
	}
	
	public OperacaoResponse subtrair(OperacaoRequest request) {
		double resultado = request.a() - request.b();
		return new OperacaoResponse(resultado);
	}
	
	public OperacaoResponse multiplicar(OperacaoRequest request) {
		double resultado = request.a() * request.b();
		return new OperacaoResponse(resultado);
	}
	
	public OperacaoResponse dividie(OperacaoRequest request) {
		if (request.b() == 0) {
			throw new ArithmeticException("Divisão por zero não é permitida!");
		}
		
		double resultado = request.a() / request.b();
		return new OperacaoResponse(resultado);
	}
}
