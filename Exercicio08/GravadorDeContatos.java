package Exercicio08;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravadorDeContatos {
	
	@SuppressWarnings("unchecked")
	public List<Contato> leContatos() throws IOException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatos.txt"));
			return (List<Contato>) in.readObject();	
		
		}catch (FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatos.txt" , e);
		}catch (IOException e){
			throw e;
		}catch (ClassNotFoundException e){
			throw new IOException("Classe dos objetos gravados no arquivo " + "contatos.txt não existe", e);
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	
	public void gravaContatos(List<Contato> contatos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatos.txt"));
			out.writeObject(contatos);
		}catch(FileNotFoundException e){			
			throw new IOException("Não foi encontrado o arquivo contatos.txt", e);
		}catch(IOException e){			
			throw e;
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public Map<String,Contato> leContatosMap() throws IOException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatosMap.txt"));
			Map<String,Contato> aux = new HashMap<String, Contato>();
			aux = (Map<String,Contato>) in.readObject();
			return aux;
		
		}catch (FileNotFoundException e){
			throw new IOException("Não foi encontrado o arquivo contatosMap.txt" , e);
		}catch (IOException e){
			throw e;
		}catch (ClassNotFoundException e){
			throw new IOException("Classe dos objetos gravados no arquivo " + "contatos.txt não existe", e);
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaContatosMap(Map<String,Contato> contatosMap) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatosMap.txt"));
			out.writeObject(contatosMap);
		}catch(FileNotFoundException e){			
			throw new IOException("Não foi encontrado o arquivo contatosMap.txt", e);
		}catch(IOException e){			
			throw e;
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
}
