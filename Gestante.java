package br.com.fiap.bean;

import java.time.*;

import javax.swing.JOptionPane;

public class Gestante {
	
	private String nome;
	private LocalDate dataDaGestacao;
	
	public Gestante () {}

	public Gestante(String nome, LocalDate dataDaGestacao) {
		this.nome = nome;
		this.dataDaGestacao = dataDaGestacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDaGestacao() {
		return dataDaGestacao;
	}

	public void setDataDaGestacao(LocalDate dataDaGestacao) {
		try {
			LocalDate inicio = LocalDate.parse("2023-08-11");
			LocalDate fim = LocalDate.now();
			if (dataDaGestacao.isAfter(inicio) && dataDaGestacao.isBefore(fim)) {
				this.dataDaGestacao = dataDaGestacao;
			} else {
				throw new Exception("Data não permitida");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0);
		}
	}
	
	
	public int tempoDeGestacao() {
		LocalDate dataAtual = LocalDate.now();
		Period meses = Period.between(dataDaGestacao, dataAtual);
		return meses.getMonths();
	}
	
	
}
