package Exercicio09;
import java.io.Serializable;

public class Contato implements Serializable , Comparable<Contato> {

	private static final long serialVersionUID = 1L;   
	private String nome, telefone;
	
	public Contato(){
		this("","");
	}
	public Contato(String nome, String telefone){
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int compareTo(Contato c) {
		if(this.nome.compareTo(c.getNome()) == 0){
			return 0;
		}else if(this.nome.compareTo(c.getNome())<0){
			return -1;
		}else{
			return 1;
		}
	}
}
