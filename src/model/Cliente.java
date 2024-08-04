package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	private String nome;
	private String cpf;
	private List<Conta> contasList = new ArrayList<Conta>();
	
	
	public Cliente(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public List<Conta> getContasList() {
		return contasList;
	}
	
	
	public void adicionaConta(Conta c) {
		
		contasList.add(c);
		
	}

	
	public void removerConta(Conta c) {
		
		if(!contasList.isEmpty()) {
			List<Conta> contaPararmover = new ArrayList<Conta>();
			
			for (Conta conta : contasList) {
				
				if(c.getNumero() == conta.getNumero()) {
					
					contaPararmover.add(conta);
					break;
				}
			}
			
		contasList.removeAll(contaPararmover);	
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(contasList, cpf, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(contasList, other.contasList) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", contasList=" + contasList + "]";
	}
	
	
	
	
	
	
	
}
