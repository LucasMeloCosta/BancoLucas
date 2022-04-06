package br.com.bancolucas.banco.aplicacao;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.bancolucas.banco.dao.ContaDAO;
import br.com.bancolucas.banco.modelo.ContaCorrente;
import br.com.bancolucas.banco.modelo.ContaPoupanca;

public class Programa {

	public static void main(String[] args) throws Exception {

		String nome =" ", saldo, limite, valor;
		int numero, numeroDestinatario, menu, menu2;

		ContaCorrente minhaContaCorrente = new ContaCorrente();
		ContaPoupanca minhaContaPoupanca = new ContaPoupanca();
		Scanner leitura = new Scanner(System.in);
		Scanner leitura2 = new Scanner(System.in);
		do {
			System.out.println("----- * Menu * > Conta Bancaria-----");
			System.out.println("1- Cadastrar conta");
			System.out.println("2- Mostrar dados");
			System.out.println("3- Depositar valor");
			System.out.println("4- Sacar valor");
			System.out.println("5- Transferência bancária");
			System.out.println("6- Mostrar saldo");
			System.out.println("0 - Sair ---------------------------");
			menu = leitura.nextInt();

			switch (menu) {
			case 1:
				ContaDAO contaDao = new ContaDAO();
				System.out.println("\nQue tipo de conta deseja cadastrar?");
				System.out.println("1- Conta Corrente");
				System.out.println("2- Conta Poupança");
				System.out.println("3- Não sei qual escolher");
				System.out.println("0- Retornar para o Menu");
				menu2 = leitura2.nextInt();

				switch (menu2) {
				case 1:
					System.out.println("{Conta Corrente}");
					System.out.println("Entre com o nome: ");
					leitura.nextLine();
					nome = leitura.nextLine();
					
					numero = contaDao.geraNumero();

					System.out.println("\nEntre com o limite: ");
					limite = leitura.next();
					BigDecimal lim2 = new BigDecimal(limite);

					System.out.println("\nEntre com o saldo: ");
					saldo = leitura.next();
					BigDecimal saldo2 = new BigDecimal(saldo);

					if (lim2.compareTo(saldo2) == -1) {
						System.out.println("\nLimite excedido, conta não cadastrada.");
						break;
					} else {
						minhaContaCorrente.inserirDados(nome, numero, lim2, saldo2);
					}
					contaDao.saveContaCorrente(minhaContaCorrente);
					break;
				case 2:
					System.out.println("\n{Conta Poupança}");
					System.out.println("Entre com o nome: ");
					leitura.nextLine();
					nome = leitura.nextLine();
					System.out.println();
					numero = contaDao.geraNumero();

					System.out.println("\nEntre com o limite: ");
					limite = leitura.next();
					BigDecimal lim3 = new BigDecimal(limite);

					System.out.println("\nEntre com o saldo: ");
					saldo = leitura.next();
					BigDecimal saldo3 = new BigDecimal(saldo);

					if (lim3.compareTo(saldo3) == -1) {
						System.out.println("\nLimite excedido, conta não cadastrada.");
						break;
					} else {
						minhaContaPoupanca.inserirDados(nome, numero, lim3, saldo3);
					}
					contaDao.saveContaPoupanca(minhaContaPoupanca);
					break;
				case 3:
					System.out.println(
							"\nConta Corrente as taxas de saque e transferências são significativamente baixas.");
					System.out.println(
							"Conta Poupança seu dinheiro rende por minuto 0,5% mas as taxas de saque e transferências são significativamente altas");
					break;
				}
				menu2 = 0;
				while (menu2 != 0)
					;
				break;

			case 2:
				ContaDAO contaDao2 = new ContaDAO();
				System.out.println("\nEntre com o número da conta: ");
				numero = leitura.nextInt();
				if (contaDao2.getTipoDeConta(numero) == 001) {
					minhaContaCorrente.mostrarDados(numero);
				} else {
					if (contaDao2.getTipoDeConta(numero) == 013) {
						minhaContaPoupanca.mostrarDados(numero);
					} else {
						System.out.println("Conta não cadastrada!");
					}
				}
				break;
			case 3:
				ContaDAO contaDao3 = new ContaDAO();
				System.out.println("\nEntre com o número da conta: ");
				numero = leitura.nextInt();
				if (contaDao3.getTipoDeConta(numero).equals(001)) {
					minhaContaCorrente.mostrarSaldo(numero);
					System.out.println("\nEntre com o valor a ser depositado: ");
					valor = leitura.next();
					minhaContaCorrente.deposita(numero, new BigDecimal(valor));
				} else {
					if (contaDao3.getTipoDeConta(numero).equals(013)) {
						minhaContaPoupanca.mostrarSaldo(numero);
						System.out.println("\nEntre com o valor a ser depositado: ");
						valor = leitura.next();
						minhaContaPoupanca.deposita(numero, new BigDecimal(valor));
					} else {
						System.out.println("Conta não cadastrada!");
					}
				}
				break;
			case 4:
				ContaDAO contaDao4 = new ContaDAO();
				System.out.println("\nInsira o número da conta: ");
				numero = leitura.nextInt();
				if (contaDao4.getTipoDeConta(numero) == 001) {
					minhaContaCorrente.mostrarSaldo(numero);
					System.out.println("{Taxa de Saque: 2,50}");
					System.out.println("\nEntre com o valor a ser sacado: ");
					valor = leitura.next();
					minhaContaCorrente.saca(numero, new BigDecimal(valor));					
				} else {
					if (contaDao4.getTipoDeConta(numero) == 013) {
						minhaContaPoupanca.mostrarSaldo(numero);
						System.out.println("{Taxa de Saque: 50,50}");
						System.out.println("\nEntre com o valor a ser sacado: ");
						valor = leitura.next();
						minhaContaPoupanca.saca(numero, new BigDecimal(valor));	
					} else {
						System.out.println("Conta não cadastrada!");
					}
				}
				break;
			case 5:
				ContaDAO contaDao5 = new ContaDAO();
				System.out.println("\nInsira o número da conta de saque: ");
				numero = leitura.nextInt();
				if (contaDao5.getTipoDeConta(numero) == 001) {
					minhaContaCorrente.mostrarDados(numero);
					System.out.println("\nInsira o número da conta do destinatário: ");
					numeroDestinatario = leitura.nextInt();
					minhaContaCorrente.mostrarDadosDestinatario(numeroDestinatario);
					System.out.println("{Taxa de Transferência: 1,20}");
					System.out.println("\nEntre com o valor a ser transferido: ");
					valor = leitura.next();
					minhaContaCorrente.transfere(numero, numeroDestinatario, new BigDecimal(valor));					
				} else {
					if (contaDao5.getTipoDeConta(numero) == 013) {
						minhaContaPoupanca.mostrarDados(numero);
						System.out.println("\nInsira o número da conta do destinatário: ");
						numeroDestinatario = leitura.nextInt();
						minhaContaPoupanca.mostrarDadosDestinatario(numeroDestinatario);
						System.out.println("{Taxa de Transferência: 40,20}");
						System.out.println("\nEntre com o valor a ser transferido: ");
						valor = leitura.next();
						minhaContaPoupanca.transfere(numero, numeroDestinatario, new BigDecimal(valor));						
					} else {
						System.out.println("Conta não cadastrada!");
					}
				}
				break;
			case 6:
				ContaDAO contaDao6 = new ContaDAO();
				System.out.println("\nEntre com o Numero: ");
				numero = leitura.nextInt();
				if (contaDao6.getTipoDeConta(numero) == 001) {
					minhaContaCorrente.mostrarSaldo(numero);
				} else {
					if (contaDao6.getTipoDeConta(numero) == 013) {
						minhaContaPoupanca.mostrarSaldo(numero);
					} else {
						System.out.println("Conta não cadastrada!");
					}
				}
				break;
			}
		} while (menu != 0);
		leitura.close();
		leitura2.close();
	}

}
