package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import service.Transacoes;

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
		transancoesMap.put(LocalDate.now(), new Transacoes("Definido Limite do cheque especial", limiteChequeEspecial));
		
		
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
				transancoesMap.put(LocalDate.now(), new Transacoes("Deposito cheque especial ", valor - depSaldo));
				transancoesMap.put(LocalDate.now(), new Transacoes("Deposito", valor));

			} else {
				saldoChequeEpecial += valor;
				transancoesMap.put(LocalDate.now(), new Transacoes("Deposito cheque especial ", valor));
			}

		} else {
			saldo += valor;
			transancoesMap.put(LocalDate.now(), new Transacoes("Deposito", valor));
		}

	}

	@Override
	public void sacar(Double valor) {
		Double valorDisponivel = saldo + saldoChequeEpecial;

		if (valorDisponivel >= valor) {

			if (saldo >= valor) {
				saldo -= valor;
				transancoesMap.put(LocalDate.now(), new Transacoes("Saque Saldo", valor));
			} else {
				Double diferenca = valor - saldo;
				
				saldoChequeEpecial -= diferenca;
				transancoesMap.put(LocalDate.now(), new Transacoes("Saque Saldo ", saldo));
				transancoesMap.put(LocalDate.now(), new Transacoes("Saque Saldo Cheque Epecial ", diferenca));
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
				transancoesMap.put(LocalDate.now(), new Transacoes("Tranferencia Saldo", valor));
			} else {
				Double diferenca = valor - saldo;
				
				saldoChequeEpecial -= diferenca;
				transancoesMap.put(LocalDate.now(), new Transacoes("Tranferencia Saldo ", saldo));
				transancoesMap.put(LocalDate.now(), new Transacoes("Tranferencia Saldo Cheque Epecial ", diferenca));
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

	
	
	
	
	
}
