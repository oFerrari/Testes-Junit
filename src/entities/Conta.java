package entities;

public class Conta {
	public static double TAXA_DE_SERVICO = 0.02;
	private Long id;
	private Double saldo;
	
	public Conta(){
		
	}

	public Conta(Long id, Double saldo) {
		this.id = id;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	
	public void deposito(double valor) {
		if(valor > 0) {
			this.saldo -= valor * TAXA_DE_SERVICO;
			this.saldo += valor;			
		}
	}
	
	public void sacar(double valor) {
		if(valor > saldo) {
			throw new IllegalArgumentException();
		}
		this.saldo -= valor;
	}
	
	public double saqueValorTotal(double valor) {
		double valorTotal = this.saldo;
		this.saldo = 0.0;
		return valorTotal;
	}
	
}
