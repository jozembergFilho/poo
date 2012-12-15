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
	 * Este método recebe um objeto do tipo Pedido e o adiciona a lista pedidos. 
	 * @param p Recebe um objeto do tipo Pedido.
	 */
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	/**
	 * Este método pesquisa pedidos utilizando o código do produto 
	 * @param recebe como parâmetro o código do produto.
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
	 * Este método remove um pedido, que recebe como parâmetro o número do pedido que deseja remover.
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
