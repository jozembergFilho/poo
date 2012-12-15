package Exercicio06;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravadorDePedidos{
	
	public List<Pedido> lePedidos() throws IOException {
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("contatos.txt"));
			return (List<Pedido>) in.readObject();	
		
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
	
	public void gravarPedidos(List<Pedido> pedidos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatos.txt"));
			out.writeObject(pedidos);
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
}
