package Exercicio08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	public Collection getContato() {
		Collection<Contato> col = new ArrayList<Contato>();
		col.addAll(this.contatosMap.values());
		return (col);
	}
	public Iterator<Contato> getContatosOrdenados() {
		List<Contato> col = new ArrayList<Contato>();
		col.addAll(this.contatosMap.values());
		Collections.sort(col);
		return col.iterator();
	}
}
