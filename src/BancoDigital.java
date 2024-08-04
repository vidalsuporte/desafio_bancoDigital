import model.Banco;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

public class BancoDigital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

 Banco bancoDigital = new Banco("Banco Desafio DIO", 2478);		
 
 bancoDigital.adicionaCliente(new Cliente("Andre", "1234"));
 bancoDigital.adicionaCliente(new Cliente("Analice", "12345"));
 bancoDigital.adicionaCliente(new Cliente("José", "123456"));
 bancoDigital.adicionaCliente(new Cliente("Bruno", "12"));
 bancoDigital.adicionaCliente(new Cliente("João", "1234567"));

 
System.out.println(bancoDigital.getNome()); 
bancoDigital.getClientesList().stream().forEach(System.out::println);
System.out.println("--------"); 
 
 
 ContaCorrente contaCorrente = new ContaCorrente(bancoDigital.getAgencia());
 ContaPoupanca contaPupanca = new ContaPoupanca(bancoDigital.getAgencia());
 ContaCorrente cc1 = new ContaCorrente(bancoDigital.getAgencia());
 ContaPoupanca cp1 = new ContaPoupanca(bancoDigital.getAgencia());
 ContaCorrente cc2 = new ContaCorrente(bancoDigital.getAgencia());
 ContaPoupanca cp2 = new ContaPoupanca(bancoDigital.getAgencia());
 ContaCorrente cc3 = new ContaCorrente(bancoDigital.getAgencia());
 ContaPoupanca cp3 = new ContaPoupanca(bancoDigital.getAgencia());
 ContaCorrente cc4 = new ContaCorrente(bancoDigital.getAgencia());
 ContaPoupanca cp4 = new ContaPoupanca(bancoDigital.getAgencia());


bancoDigital.pesquisarPorCPF("1234").adicionaConta(contaCorrente);		
bancoDigital.pesquisarPorCPF("1234").adicionaConta(cp4);
bancoDigital.pesquisarPorCPF("12345").adicionaConta(cc1);		
bancoDigital.pesquisarPorCPF("12345").adicionaConta(cp2);
bancoDigital.pesquisarPorCPF("123456").adicionaConta(cp1);		
bancoDigital.pesquisarPorCPF("123456").adicionaConta(cc4);
bancoDigital.pesquisarPorCPF("12").adicionaConta(cc2);		
bancoDigital.pesquisarPorCPF("12").adicionaConta(cp3);
bancoDigital.pesquisarPorCPF("1234567").adicionaConta(cc3);		
bancoDigital.pesquisarPorCPF("1234567").adicionaConta(contaPupanca);

System.out.println(bancoDigital.getNome()); 
bancoDigital.getClientesList().stream().forEach(System.out::println);
System.out.println("--------"); 
 




System.out.println("-------------------------");
System.out.println("Lista de Conta do Cliente");
System.out.println(bancoDigital.pesquisarPorCPF("1234"));
bancoDigital.pesquisarPorCPF("1234").getContasList().stream().forEach(System.out::println);



System.out.println("----------------------------------");

contaCorrente.setLimiteChequeEspecial(700.0);
contaCorrente.depositar(1000.00);

contaCorrente.imprimeDadosConta();

System.out.println("-------------------------");

contaCorrente.sacar(800.0);

contaCorrente.imprimeDadosConta();


System.out.println("-------------------------");

contaCorrente.sacar(800.0);

contaCorrente.imprimeDadosConta();


System.out.println("-------------------------");

contaCorrente.depositar(6200.0);

contaCorrente.imprimeDadosConta();

cp4.imprimeDadosConta();


contaCorrente.transferir(cp4, 2000.00);


System.out.println("-------------------------");

contaCorrente.imprimeDadosConta();
cp4.imprimeDadosConta();


contaCorrente.extrato();

cp4.extrato();
		
	}

}
