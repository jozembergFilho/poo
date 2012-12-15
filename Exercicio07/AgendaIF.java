package Exercicio07;

import java.io.IOException;

public interface AgendaIF {

	public void adicionaContato(String nome, String tel);
	public void removerContato(String nome) throws ContatoInexistenteException, IOException;
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException;
	
}
