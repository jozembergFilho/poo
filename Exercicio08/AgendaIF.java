package Exercicio08;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public interface AgendaIF {

	public void adicionaContato(String nome, String tel);
	public void removerContato(String nome) throws ContatoInexistenteException, IOException;
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException;
	public Collection<Contato> getContato();
	public Iterator<Contato> getContatosOrdenados();
}
