package Exercicio05;

public class AgendaMain {

	public static void main(String[]args){
		Agenda agenda = new Agenda();
	
		agenda.adicionaContato("berg","96314222");
		try{
			agenda.removerContato("berg");
		}catch(ContatoInexistenteException e){
			System.err.println("Contato n�o EXISTENTE");
		}
		try{
			agenda.removerContato("Gilson");
		}catch(ContatoInexistenteException e){
			System.err.println("Contato n�o existente");
		}
		try{
			agenda.pesquisaContato("berg");	
		}catch(ContatoInexistenteException e){
			System.err.println("Contato n�o existente");
		}
		try{
			agenda.pesquisaContato("Gilson");
		}catch(ContatoInexistenteException e){
			System.err.println("Contato n�o existente");
		}
	
	}
}
