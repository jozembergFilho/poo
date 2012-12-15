package Exercicio07;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AgendaMap implements AgendaIF {

	private GravadorDeContatos gravadorMap;
	private Map<String,Contato> contatosMap;
	
	public AgendaMap(){
		this.gravadorMap = new GravadorDeContatos();
		try{
			this.contatosMap = this.gravadorMap.leContatosMap();
		}catch(IOException e){
			this.contatosMap = new HashMap<String, Contato>();
		}
	}
	public void adicionaContato(String nome, String tel) {
		contatosMap.put(nome,new Contato(nome,tel));
		salvarContatosMap();
	}

	public void removerContato(String nome) throws ContatoInexistenteException{
		for(Contato c : this.contatosMap.values()){
			if(c.getNome().equals(nome)){
				contatosMap.remove(nome);
				salvarContatosMap();
				return;
			}
		}
		throw new ContatoInexistenteException("Contato Inexistente: " + nome);
		
	}
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException {
		for (Contato c : this.contatosMap.values()) {
			if (c.getNome().equals(nome)) {
				return contatosMap.get(nome);
			}
		}
		throw new ContatoInexistenteException("Contato não existente!" + nome);
	}
	
	public void salvarContatosMap(){
		
		try{
			this.gravadorMap.gravaContatosMap(contatosMap);
		}catch (IOException e){
			System.err.println("Contato não salvo " + e.getMessage());
		}
	}
}
