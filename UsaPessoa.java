package br.com.fiap.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;
import br.com.fiap.bean.Pessoa;

public class UsaPessoa {

	public static void main(String[] args) {
		
		Pessoa p1;
		String aux, nome, dataNasc;
		LocalDate minhaData;
		
		try {
			nome = JOptionPane.showInputDialog("Digite o seu nome: ");
			aux = JOptionPane.showInputDialog("Digite a data de nascimento: ");
			//0 1 2 3 4 5 6 7 8 9
			//0 4 / 1 1 / 2 0 2 4
			dataNasc = aux.substring(6, 10); //2024
			dataNasc += "-" + aux.substring(3, 5); //2024-11
			dataNasc += "-" + aux.substring(0, 2); //2024-11-04
			
			minhaData = LocalDate.parse(dataNasc);
			
			p1 = new Pessoa(nome, minhaData);
			
			JOptionPane.showMessageDialog(null, "Data no formato EUA"
					+ "\nData de nascimento: " + p1.getDataNascimento());
			
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = p1.getDataNascimento().format(dft);
			
			JOptionPane.showMessageDialog(null, "Dados Pessoais: "
					+ "\nNome: " + p1.getNome()
					+ "\nData de nascimento: " + dataFormatada
					+ "\nIdade: " + p1.calculaIdade() + " anos");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

}
