package br.com.bancolucas.banco.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Classe que representa a moldura de uma conta.
 * Valores que podem ser definidos:
 * Numero, Nome, Saldo, Limite, DataCadastro, DataAtualização, Tipo de conta(Conta Corrente(001) ou Conta Poupancaça(013)).
 * 
 * @author Lucas Melo Costa
 * @serial 1L
 */	
public abstract class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	private int Numero;
	private String Nome;
	protected BigDecimal Saldo = new BigDecimal("0");
	protected BigDecimal Limite = new BigDecimal("0");
	private Date DataCadastro;
	private LocalDateTime DataAtualizacao;
	private String tipoDeConta;
	@SuppressWarnings("unused")
	private static int total = 0;

	protected Conta(int tipoDeConta) {
		Conta.total++;
		if (tipoDeConta == 001) {
			String tipoDeContaString = "Conta Corrente";
			this.tipoDeConta = tipoDeContaString;
		} else {
			if (tipoDeConta == 013) {
				String tipoDeContaString2 = "Conta Poupança";
				this.tipoDeConta = tipoDeContaString2;
			} else {
				String tipoDeContaString3 = "Tipo de conta não encontrada.";
				this.tipoDeConta = tipoDeContaString3;
			}
		}
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public BigDecimal getSaldo() {
		return Saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		Saldo = saldo;
	}

	public BigDecimal getLimite() {
		return Limite;
	}

	public void setLimite(BigDecimal limite) {
		Limite = limite;
	}

	public Date getDataCadastro() {
		return DataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		DataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return DataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		DataAtualizacao = dataAtualizacao;
	}

	public String getTipoDeConta() {
		return this.tipoDeConta;
	}

	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}
/**
 * Retorna o nome e o numero da conta.
 */
	@Override
	public String toString() {
		return "\nNome: " + this.Nome + ", Numero: " + this.Numero;
	}
/**
 * Defini os dados de uma conta: Nome, Numero, Limite(Sempre maior do que o saldo!), Saldo.
 * 
 * @param nome
 * @param numero
 * @param Limite
 * @param saldo
 */
	public void inserirDados(String nome, int numero, BigDecimal Limite, BigDecimal saldo) {
		if (Limite.compareTo(saldo) == -1) {
			System.out.println("Limite excedido, conta não cadastrada.");
		} else {
			this.Nome = nome;
			this.Numero = numero;
			this.Limite = Limite;
			this.Saldo = saldo;
			System.out.println("Sucesso! O numero da sua conta é: " + this.Numero);
		}
	}
/**
 * Se o numero inserido for diferente do numero da conta ele retorna false
 * se o numero for igual ao numero da conta ele retorna true.
 * 
 * @param numero
 * @return
 */
	public boolean getNumeroBoolean(int numero) {
		if (numero != Numero) {
			return false;
		}
		return true;
	}

}
