package model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private int agencia;
	private List<Cliente> clientesList = new ArrayList<Cliente>();

	
	
	public Banco(String nome, int agencia) {
		super();
		this.nome = nome;
		this.agencia = agencia;
	}

	public String getNome() {
		return nome;
	}

	public int getAgencia() {
		return agencia;
	}

	public List<Cliente> getClientesList() {
		return clientesList;
	}

	public void adicionaCliente(Cliente c) {

		clientesList.add(c);
	}
	
	public Cliente pesquisarPorCPF(String cpf) {
		

		if (!clientesList.isEmpty()) {
			for (Cliente cliente : clientesList) {

				if (cliente.getCpf().equalsIgnoreCase(cpf)) {
					return cliente;
				
				}

			}

		}

		return null;
		
	}
	
	public void removerCliente(Cliente c) {

		if (!clientesList.isEmpty()) {
			List<Cliente> clienteParaRemover = new ArrayList<Cliente>();

			for (Cliente cliente : clientesList) {

				if (cliente.getCpf().equalsIgnoreCase(c.getCpf())) {

					clienteParaRemover.add(cliente);
					break;
				}

			}

			clientesList.removeAll(clienteParaRemover);
			
			
			
		}

	}

	@Override
	public String toString() {
		return "Banco [nome=" + nome + ", agencia=" + agencia + ", clientesList=" + clientesList + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
