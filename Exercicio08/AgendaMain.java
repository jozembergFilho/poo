package Exercicio08;

import java.io.IOException;
import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class AgendaMain {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		String nome, tel;
		int converter;


		while (true) {
			converter = Integer.parseInt( JOptionPane
					.showInputDialog(null,
							"1-Adicionar contato \n 2-Remover contato \n 3-Pesquisar contato \n 4-Sair"));
			
			switch (converter) {
			case 1:
				nome = JOptionPane.showInputDialog(null,
						"Por favor, informe o nome do contato: ");
				tel = JOptionPane.showInputDialog(null,
						"Por favor, informe o telefone do contato: ");

				agenda.adicionaContato(nome, tel);
				break;
			case 2:
				nome = JOptionPane
						.showInputDialog(null,
								"Por favor, informe o nome do contato à ser removido: ");

				try {
					agenda.removerContato(nome);
				} catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 3:
				nome = JOptionPane
						.showInputDialog(null,
								"Por favor, informe o nome do contato à ser pesquisado: ");
				Contato c = new Contato();
				try {
					c = agenda.pesquisaContato(nome);
					JOptionPane.showMessageDialog(null, "Nome: " + c.getNome()
							+ "\n" + "Telefone: " + c.getTelefone());
				} catch (ContatoInexistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				break;
			case 4:

				System.exit(0);

			}
		}
	}
}