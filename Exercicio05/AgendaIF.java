package Exercicio05;

public interface AgendaIF {

	public void adicionaContato(String nome, String tel);
	public void removerContato(String nome) throws ContatoInexistenteException;
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException;
	
}
