package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Conta;
import testes.factory.ContaFactory;

public class ContaTestes {
	/*
	 * Nomenclatura de um teste
	 * 
	 * <AÇÃO> deveria <EFEITO> [quando CENÁRIO]
	 */

	/*
	 * Quando o deposito ocorrer o saldo devera ser atualizado em positivo, e a taxa
	 * de serviço recolhida.
	 */

	// AÇÃO DEVERIA EFEITO

	/*
	 * =============================================================================
	 * =======
	 */
	@Test
	public void depositoDeveriaAumentarSaldoEDescontarTaxaQuandoValorForPositivo() {
		/*
		 * Padrão AAA Arrange: Instancia os objetos necessarios Act: Executa as ações
		 * necessarias Assert: declare o que deveria acontecer (resultado esperado)
		 */

		// Arrange:
		double valor = 200.00;
		double valorEsperado = 196.00;
		Conta c1 = new Conta(1L, 0.0);
		c1.deposito(valor);

		// Assert:
		Assertions.assertEquals(valorEsperado, c1.getSaldo());
	}

	/*
	 * =============================================================================
	 * =======
	 */

	@Test
	public void depositoManterSaldoQuandoValorForNegativo() {
		/*
		 * Arrange: Instancia os objetos necessarios Act: Executa as ações necessarias
		 * Assert: declare o que deveria acontecer (resultado esperado)
		 */

		// Arrange:
		double valor = -10.0;
		double SaldoInicial = 100.0;
		double valorEsperado = 100.0;
		Conta c1 = ContaFactory.criarConta(SaldoInicial);
		c1.deposito(valor);

		// Assert:
		Assertions.assertEquals(valorEsperado, c1.getSaldo());
	}

	/*
	 * =============================================================================
	 * =======
	 */

	@Test
	public void saqueCompletoDeveZerarSaldo() {

		double valorEsperado = 0.0;
		Conta c1 = ContaFactory.criarConta(750.00);
		// System.out.println(c1.getSaldo());
		double resultado = c1.saqueValorTotal();

		// Assert:
		Assertions.assertEquals(valorEsperado, c1.getSaldo());
	}

	/*
	 * =============================================================================
	 * =======
	 */

	@Test
	public void saqueDeveriaDiminuirSaldoQuandoSaldoSuficiente() {

		double valorEsperado = 300.00;
		Conta c1 = ContaFactory.criarConta(750.00);
		c1.saque(450);

		// Assert:
		Assertions.assertEquals(valorEsperado, c1.getSaldo());
	}



	/*
	 * =============================================================================
	 * =======
	 */

@Test
public void saqueDeveriaLançarUmaExceptionQuandoSaldoInsuficiente() {

	Assertions.assertThrows(IllegalArgumentException.class, ()-> {
	Conta c1 = ContaFactory.criarConta(750.00);

	c1.saque(1000);
	
	});

}

}