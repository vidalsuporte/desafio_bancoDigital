package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import service.Transacoes;

public class Conta {
	
	
	protected static long SEQUENCIAL = 1;

	protected long numero = 0L;
	protected int agencia;
	protected Double saldo = 0.0;
	protected Map<LocalDateTime, Transacoes> transancoesMap = new HashMap<LocalDateTime,Transacoes>();
	
		
	
	public Conta(int agencia) {
		super();
		this.numero = SEQUENCIAL ++;
		this.agencia = agencia;
		
		
		
	}

	
	
	public Long getNumero() {
		return numero;
	}


	public int getAgencia() {
		return agencia;

	}

	public Map<LocalDateTime, Transacoes> getTrasancoesMap() {
		return transancoesMap;
	}



	public Double getSaldo() {
		return saldo;
	}

	
	
	public void depositar(Double valor) {
		
	this.saldo += valor;
transancoesMap.put(LocalDateTime.now(), new Transacoes("Deposito", valor));
	
	
	
	}
	
	public void sacar(Double valor) {
		
		this.saldo -= valor;
transancoesMap.put(LocalDateTime.now(), new Transacoes("Saque", valor));
	}
	
	public void transferir(Conta c, Double valor) {
		this.sacar(valor);
		c.depositar(valor);
transancoesMap.put(LocalDateTime.now(), new Transacoes("Tranferência para conta nº " + c.getNumero(), valor));		
		
	}



	@Override
	public int hashCode() {
		return Objects.hash(agencia, saldo, transancoesMap);
	}



	



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && Objects.equals(saldo, other.saldo)
				&& Objects.equals(transancoesMap, other.transancoesMap);
	}



	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", agencia=" + agencia + ", saldo=" + saldo + ", trasancoesMap="
				+ transancoesMap + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
