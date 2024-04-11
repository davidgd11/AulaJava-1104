package br.com.fiap.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Gestante;

public class UsaGestante {

	public static void main(String[] args) {
	
		Gestante g1;
		String aux, nome, dataGest;
		LocalDate minhaData;
		
		try {
			nome = JOptionPane.showInputDialog("Digite o seu nome: ");
			aux = JOptionPane.showInputDialog("Digite data de início da gestação: ");
			//0 1 2 3 4 5 6 7 8 9
			//0 4 / 1 1 / 2 0 2 4
			dataGest = aux.substring(6,10);
			dataGest += "-" + aux.substring(3,5);
			dataGest += "-" + aux.substring(0,2);
			
			minhaData = LocalDate.parse(dataGest);
			
			g1 = new Gestante(nome, minhaData);
			
			JOptionPane.showMessageDialog(null, "Data no formato EUA"
					+ "\nData do início da gestação: " + g1.getDataDaGestacao());
			
			DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = g1.getDataDaGestacao().format(dft);
			
			JOptionPane.showMessageDialog(null, "Dados: "
					+ "\nNome da mãe: " + g1.getNome()
					+ "\nData de início da gestação: " + dataFormatada
					+ "\nTempo de gestação: " + g1.tempoDeGestacao() + " mês ");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

}
