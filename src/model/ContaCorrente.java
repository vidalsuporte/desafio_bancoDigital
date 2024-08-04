package model;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta {
	
	
	public ContaCorrente(int agencia) {
		super(agencia);
		// TODO Auto-generated constructor stub
	}

	private Double limiteChequeEspecial = 0.0;
	private Double saldoChequeEpecial = 0.0;
	
	
	


	public Double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(Double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
		this.saldoChequeEpecial = limiteChequeEspecial;
		transancoesMap.put(LocalDateTime.now(), new Transacoes("Definido Limite do cheque especial", limiteChequeEspecial));
		
		
	}

	public Double getSaldoChequeEpecial() {
		return saldoChequeEpecial;
	}

	public void usarChequeEspecial(Double valor) {
		saldoChequeEpecial -= valor;
	}

	@Override
	public void depositar(Double valor) {

		if (saldoChequeEpecial < limiteChequeEspecial) {
			Double diferenca = limiteChequeEspecial - saldoChequeEpecial;

			if (valor > diferenca) {
				Double depSaldo = valor - diferenca;
				saldo += depSaldo;
				saldoChequeEpecial += valor - depSaldo;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Deposito cheque especial ", valor - depSaldo));
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Deposito", valor));

			} else {
				saldoChequeEpecial += valor;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Deposito cheque especial ", valor));
			}

		} else {
			saldo += valor;
			transancoesMap.put(LocalDateTime.now(), new Transacoes("Deposito", valor));
		}

	}

	@Override
	public void sacar(Double valor) {
		Double valorDisponivel = saldo + saldoChequeEpecial;

		if (valorDisponivel >= valor) {

			if (saldo >= valor) {
				saldo -= valor;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Saque Saldo", valor));
			} else {
				Double diferenca = valor - saldo;
				
				saldoChequeEpecial -= diferenca;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Saque Saldo ", saldo));
				
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			transancoesMap.put(LocalDateTime.now(), new Transacoes("Saque Saldo Cheque Epecial ", diferenca));
				saldo = 0.0;
			}

		} else {
			System.out.println("saldo insufucuente!");

		}

	}

	@Override
	public void transferir(Conta c, Double valor) {
		Double valorDisponivel = saldo + saldoChequeEpecial;

		if (valorDisponivel >= valor) {

			if (saldo >= valor) {
				saldo -= valor;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Tranferencia Saldo", valor));
			} else {
				Double diferenca = valor - saldo;
				
				saldoChequeEpecial -= diferenca;
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Tranferencia Saldo ", saldo));
				transancoesMap.put(LocalDateTime.now(), new Transacoes("Tranferencia Saldo Cheque Epecial ", diferenca));
				saldo = 0.0;
			}

		} else {
			System.out.println("saldo insufucuente!");

		}
		c.depositar(valor);
	}
	
	public void exibirSaldo() {
		
		System.out.println("Saldo diponível na conta corrente é: ");
		System.out.println("Saldo : " + getSaldo());
		System.out.println("Saldo Cheque Especial: " + getSaldoChequeEpecial());
		
	}

	@Override
	public String toString() {
		return "ContaCorrente [limiteChequeEspecial=" + limiteChequeEspecial + ", saldoChequeEpecial="
				+ saldoChequeEpecial + ", numero=" + numero + ", agencia=" + agencia + ", saldo=" + saldo
				+ ", transancoesMap=" + transancoesMap + "]";
	}
@Override
	public void imprimeDadosConta() {
		System.out.println("Dados da Conta Corrente");
		super.imprimeDadosConta();
		System.out.println(String.format("Limite Cheque special: R$ %.2f", this.getLimiteChequeEspecial()));
		System.out.println(String.format("Saldo Cheque special: R$ %.2f", this.getSaldoChequeEpecial()));
		System.out.println("__________________");
		System.out.println("");
		
	}
	
public void extrato() {
	System.out.println("Extrato Conta Corrente");
	
	super.extrato();
	
	System.out.println(String.format("Saldo Cheque special: R$ %.2f", this.getSaldoChequeEpecial()));
	
	System.out.println("");
	
}	





	
	
}
