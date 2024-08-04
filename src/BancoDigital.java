import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class BancoDigital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

 Banco bancoDigital = new Banco("Banco Dede", 2478);		
 
 bancoDigital.adicionaCliente(new Cliente("Andre", "1234"));
 bancoDigital.adicionaCliente(new Cliente("Analice", "12345"));
 bancoDigital.adicionaCliente(new Cliente("José", "123456"));
 bancoDigital.adicionaCliente(new Cliente("Bruno", "12"));
 bancoDigital.adicionaCliente(new Cliente("João", "1234567"));

 
System.out.println(bancoDigital.getNome()); 
bancoDigital.getClientesList().stream().forEach(System.out::println);
System.out.println("--------"); 
 
 
 ContaCorrente contacorrente = new ContaCorrente(bancoDigital.getAgencia());
 Conta contaPupanca = new ContaPoupanca(bancoDigital.getAgencia());
 Conta cc1 = new ContaCorrente(bancoDigital.getAgencia());
 Conta cp1 = new ContaPoupanca(bancoDigital.getAgencia());
 Conta cc2 = new ContaCorrente(bancoDigital.getAgencia());
 Conta cp2 = new ContaPoupanca(bancoDigital.getAgencia());
 Conta cc3 = new ContaCorrente(bancoDigital.getAgencia());
 Conta cp3 = new ContaPoupanca(bancoDigital.getAgencia());
 Conta cc4 = new ContaCorrente(bancoDigital.getAgencia());
 Conta cp4 = new ContaPoupanca(bancoDigital.getAgencia());
	
		
bancoDigital.pesquisarPorCPF("1234").adicionaConta(contacorrente);		
bancoDigital.pesquisarPorCPF("1234").adicionaConta(contaPupanca);
bancoDigital.pesquisarPorCPF("12345").adicionaConta(cc1);		
bancoDigital.pesquisarPorCPF("12345").adicionaConta(cp2);
bancoDigital.pesquisarPorCPF("123456").adicionaConta(cp1);		
bancoDigital.pesquisarPorCPF("123456").adicionaConta(cc4);
bancoDigital.pesquisarPorCPF("12").adicionaConta(cc2);		
bancoDigital.pesquisarPorCPF("12").adicionaConta(cp3);
bancoDigital.pesquisarPorCPF("1234567").adicionaConta(cc3);		
bancoDigital.pesquisarPorCPF("1234567").adicionaConta(cp4);




System.out.println("-------------------------");


contacorrente.setLimiteChequeEspecial(700.0);
contacorrente.depositar(1000.00);

System.out.println(contacorrente);

System.out.println("-------------------------");

contacorrente.sacar(800.0);

System.out.println(contacorrente);	

		
		
	}

}
