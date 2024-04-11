package br.com.fiap.bean;

import java.time.*;

import javax.swing.JOptionPane;

public class Pessoa {
	
	//Atributos
	private String nome;
	private LocalDate dataNascimento;

	//Construtores
	public Pessoa() {}

	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		setDataNascimento(dataNascimento);
	}

	//métodos getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now();
		try {
			if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(fim)) {
				this.dataNascimento = dataNascimento;
			} else {
				throw new Exception("Data fora da faixa permitida");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0); //encerra o programa após o erro
		}
	}
	
	//métodos da classe
	public int calculaIdade() {
		LocalDate dataAtual = LocalDate.now();	
		Period idade = Period.between(dataNascimento, dataAtual);
		return idade.getYears();
	}
	
}
