package br.ufpb.sistemapedidos;
import java.util.List;
import java.util.ArrayList;

/**
 * Classe que serve para controlar os pedidos de um restaurante, implementa a interfaceSistemaDeControle.
 * @author BERG
 *
 */
public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List<Pedido> pedidos;
	/**
	 * Construtor default que inicializa o ArrayList.
	 */
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	/**
	 * @param nomeCliente recebe um nome e calculamos a quantidade de pedidos desse cliente.
	 * @return retorna a quantidade de pedidos de um cliente.
	 */
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int cont = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				cont ++;
			}
		}
		return cont;
	}
	/**
	 * Este m�todo recebe um objeto do tipo Pedido e o adiciona a lista pedidos. 
	 * @param p Recebe um objeto do tipo Pedido.
	 */
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	/**
	 * Este m�todo pesquisa pedidos utilizando o c�digo do produto 
	 * @param recebe como par�metro o c�digo do produto.
	 * @return Retorna uma lista do tipo Pedido contendo os pedidos encontrados.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto){
		List<Pedido> pesquisa = new ArrayList<Pedido>();
		for(Pedido p : this.pedidos){
			for(ItemDePedido i : p.getItens()){
				if(i.getCodProduto().equals(codProduto)){
					pesquisa.add(p);
				}
			}
		}
		return pesquisa;
	}
	/**
	 * Este m�todo remove um pedido, que recebe como par�metro o n�mero do pedido que deseja remover.
	 * @param numPedido recebe um pedido do tipo long.
	 */
	
	public void removePedido(long numPedido){
		for(Pedido p : this.pedidos){
			if(p.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(p);
				break;
			}
		}
	}
	
}
