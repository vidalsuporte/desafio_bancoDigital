package model;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int agencia) {
		super(agencia);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimeDadosConta() {
		System.out.println("Dados da Conta Poupança");
		super.imprimeDadosConta();
		System.out.println("__________________");
		System.out.println("");

	}

	public void extrato() {
		System.out.println("Extrato Conta Poupança");

		super.extrato();

	}

}
