package Exercicio08;

import java.io.IOException;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class AgendaMainMap {

	public static void main(String[] args) {
		AgendaMap a = new AgendaMap();
		String nome, tel;
		int converter;


		while (true) {
			String entrada = JOptionPane
					.showInputDialog(null,
							"1-Adicionar contato \n 2-Remover contato \n 3-Pesquisar contato \n 4-Sair");
			converter = Integer.parseInt(entrada);

			switch (converter) {
			case 1:
				nome = JOptionPane.showInputDialog(null,
						"Por favor, informe o nome do contato: ");
				tel = JOptionPane.showInputDialog(null,
						"Por favor, informe o telefone do contato: ");

				a.adicionaContato(nome, tel);
				break;
			case 2:
				nome = JOptionPane
						.showInputDialog(null,
								"Por favor, informe o nome do contato à ser removido: ");

				try {
					a.removerContato(nome);
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
					c = a.pesquisaContato(nome);
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