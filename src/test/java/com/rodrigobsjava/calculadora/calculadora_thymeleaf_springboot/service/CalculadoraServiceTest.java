package com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoRequest;
import com.rodrigobsjava.calculadora.calculadora_thymeleaf_springboot.dto.OperacaoResponse;

public class CalculadoraServiceTest {

	private CalculadoraService service;

	@BeforeEach
	void setup() {
		// Unit test: instanciamos diretamente, sem Spring
		service = new CalculadoraService();
	}

	@Test
	@DisplayName("somar: deve retornar a soma correta")
	void somar_deveRetornarSomaCorreta() {
		// Arrange
		OperacaoRequest request = new OperacaoRequest(10, 5);

		// Act
		OperacaoResponse response = service.somar(request);

		// Assert
		assertEquals(15.0, response.resultado(), "10 + 5 deve ser 15");
	}

	@Test
	@DisplayName("subtrair: deve retornar a diferença correta")
	void subtrair_deveRetornarDiferencaCorreta() {
		OperacaoRequest request = new OperacaoRequest(10, 5);
		OperacaoResponse response = service.subtrair(request);
		assertEquals(5.0, response.resultado(), "10 - 5 deve ser 5");
	}

	@Test
	@DisplayName("multiplicar: deve retornar o produto correto")
	void multiplicar_deveRetoranarProdutoCorreto() {
		OperacaoRequest request = new OperacaoRequest(10, 5);
		OperacaoResponse response = service.multiplicar(request);
		assertEquals(50.0, response.resultado(), "10 * 5 deve ser 50");
	}

	@Test
	@DisplayName("dividir: deve retornar o quociente correto")
	void dividir_deveRetornarQuocienteCorreto() {
		OperacaoRequest request = new OperacaoRequest(10, 5);
		OperacaoResponse response = service.dividir(request);
		assertEquals(2.0, response.resultado(), "10 / 5 deve ser 2");
	}

	@Test
	@DisplayName("dividir: dividir por zero lança ArithmeticException")
	void dividir_porZero_deveLancarExcecao() {
		OperacaoRequest request = new OperacaoRequest(10, 0);
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> service.dividir(request));
		assertEquals("Divizão por zero não é permitida", exception.getMessage());
		
	}
}
