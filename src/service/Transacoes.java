package service;

import java.time.LocalDateTime;
import java.util.Objects;

public class Transacoes {

	private LocalDateTime data;
	private String tipo;
	private Double valor;
	
	
	
	
	public Transacoes( String tipo, Double valor) {
		super();
		this.data = LocalDateTime.now();
		this.tipo = tipo;
		this.valor = valor;
	}




	public LocalDateTime getData() {
		return data;
	}




	public String getTipo() {
		return tipo;
	}




	public Double getValor() {
		return valor;
	}




	@Override
	public String toString() {
		return "Transacoes [data=" + data + ", tipo=" + tipo + ", valor=" + valor + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(data, tipo, valor);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacoes other = (Transacoes) obj;
		return Objects.equals(data, other.data) && Objects.equals(tipo, other.tipo)
				&& Objects.equals(valor, other.valor);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
