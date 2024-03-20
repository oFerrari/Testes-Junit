package testes.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Conta;

public class ContaTestes {
	/*
	Nomenclatura de um teste
	
	<AÇÃO> deveria <EFEITO> [quando CENÁRIO]
	*/
	
	/*
	Quando o deposito ocorrer o saldo devera ser atualizado em positivo, e a taxa de serviço recolhida. 
	*/
	
	//AÇÃO  DEVERIA EFEITO
	@Test
	public void depositoDeveriaAumentarSaldoEDescontarTaxaQuandoValorForPositivo(){
		/*
		 Padrão AAA
		 Arrange: Instancia os objetos necessarios
		 Act: Executa as ações necessarias
		 Assert: declare o que deveria acontecer (resultado esperado)
		 */
		
		//Arrange:
		double valor = 200.00;
		double valorEsperado = 196.00;
		Conta c1 = new Conta (1L, 0.0);
		c1.deposito(valor);
		
		//Assert:
		Assertions.assertEquals(valorEsperado, c1.getSaldo());
	}
}
