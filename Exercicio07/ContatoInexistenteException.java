package Exercicio07;

public class ContatoInexistenteException extends Exception {

	public ContatoInexistenteException(String m){
		super(m);
	}
	public ContatoInexistenteException(){
		this("Contato Inexistente");
	}
}
