package Exercicio01;
import java.util.List;
import java.util.ArrayList;

public class ControleDePedidos implements InterfaceSistemaDeControle {

	private List<Pedido> pedidos;
	
	public ControleDePedidos(){
		this.pedidos = new ArrayList<Pedido>();
	}
	public int calculaQuantidadeDePedidosDoCliente(String nomeCliente){
		int cont = 0;
		for(Pedido p : this.pedidos){
			if(p.getCliente().getNome().equals(nomeCliente)){
				cont ++;
			}
		}
		return cont;
	}
	public void adicionaPedido(Pedido p){
		this.pedidos.add(p);
	}
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto){
		List<Pedido> pesquisa = new ArrayList<Pedido>();
		for(Pedido cod : this.pedidos){
			for(ItemDePedido i : cod.getItens()){
				if(i.getCodProduto().equals(codProduto)){
					pesquisa.add(cod);
				}
			}
		}
		return pesquisa;
	}
	public void removePedido(long numPedido){
		for(Pedido numero : this.pedidos){
			if(numero.getNumeroDoPedido() == numPedido){
				this.pedidos.remove(numero);
			}
		}
	}
	
}
