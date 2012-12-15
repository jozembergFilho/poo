package Exercicio09;

import java.io.IOException;
import java.util.*;

public class Agenda implements AgendaIF {

	private List<Contato> contato ;
	private GravadorDeContatos gravador;

	public Agenda() {
		this.gravador = new GravadorDeContatos();
		try {
			this.contato = this.gravador.leContatos();
		} catch (IOException e) {
			contato = new ArrayList<Contato>();
		}
	}

	public void adicionaContato(String nome, String tel) {
		for(Contato contNomeIgual : this.contato){
			if(contNomeIgual.getNome().equals(nome)){
				contNomeIgual.setTelefone(tel);
				salvarContatos();
				return;
			}
		}
		this.contato.add(new Contato(nome, tel));
		salvarContatos();
	}

	public void removerContato(String nome) throws ContatoInexistenteException{
		
		for(Contato c : this.contato){
			if(c.getNome().equals(nome)){
				this.contato.remove(c);
				salvarContatos();
				return;
				
			}
		}
		
			throw new ContatoInexistenteException("Contato Inexistente: " + nome);
		
	}

	public Contato pesquisaContato(String nome)	throws ContatoInexistenteException {
		
		for (Contato c : this.contato) {
			if (c.getNome().equals(nome)) {
				return c;
			}
		}
		throw new ContatoInexistenteException("N�o existe o contato");
	}

	public void salvarContatos() {
		try{	
			this.gravador.gravaContatos(contato);
		}catch(IOException e){
			System.err.println("N�o conseguiu gravar." + e.getMessage());
		}
	}
	public Collection<Contato> getContato(){
		Collection<Contato> col = new ArrayList<Contato>();
		col.addAll(this.contato);
		return col;
	}
	public Iterator<Contato> getContatosOrdenados() {
		List<Contato> col = new ArrayList<Contato>();
		col.addAll(this.contato);
		Collections.sort(col);
		return col.iterator();
	}
}
