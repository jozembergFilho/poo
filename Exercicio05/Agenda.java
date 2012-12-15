package Exercicio05;
import java.util.*;

public class Agenda implements AgendaIF {
 
	private List<Contato> contato;
	
	public Agenda(){
		this.contato = new ArrayList<Contato>();
	}
	public void adicionaContato(String nome, String tel){
		this.contato.add(new Contato(nome, tel));
	}
	public void removerContato(String nome) throws ContatoInexistenteException{
		boolean achou = false;
		for(Contato c : this.contato){
			if(c.getNome().equals(nome)){
				this.contato.remove(nome);
				achou = true;
				break;
			}
		}
		if(achou == false){
			throw new ContatoInexistenteException("Contato Inexistente: " + nome);
		}
	}
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException{
		for(Contato c : this.contato){
			if(c.getNome().equals(nome)){
				return c;
			}
		}
		throw new ContatoInexistenteException("Não existe o contato");
	}
	
}
