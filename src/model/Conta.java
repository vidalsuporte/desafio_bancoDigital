package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

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


public void imprimeDadosConta() {
	
	System.out.println("Numero agência: " + this.getAgencia());
	System.out.println("Numero conta: " + this.getNumero());
	System.out.println(String.format("Saldo: R$ %.2f", this.getSaldo()));
	
	
}
	

public void extrato() {
	

	for (Entry<LocalDateTime, Transacoes> t : transancoesMap.entrySet()) {
		
		System.out.println("Data: " + t.getValue().getData());
		System.out.println("Tipo: " + t.getValue().getTipo());
		System.out.println("Valor: " + t.getValue().getValor());
		System.out.println("----------------------------------");
		System.out.println("");

}

System.out.println(String.format("Saldo: R$ %.2f", this.getSaldo()));

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
