package model;

public class ContaPoupanca extends Conta {

	

	
public ContaPoupanca(int agencia) {
		super(agencia);
		
		// TODO Auto-generated constructor stub
	}

public void exibirSaldo() {
		
		System.out.println("Saldo diponível na Conta Poupança é: ");
		System.out.println("Saldo : " + getSaldo());
		
		
	}


	
	
	
	
}
