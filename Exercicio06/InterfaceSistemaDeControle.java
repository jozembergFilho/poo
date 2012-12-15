package Exercicio06;
import java.util.List;
/**
 * A interface cria sistemas de controle de pedido.
 * @author BERG
 *
 */
public interface InterfaceSistemaDeControle {
	/**
	 * Assinatura de um método que adiciona um pedido.
	 * @param p recebe um objeto do tipo Pedido.
	 */
	public void adicionaPedido(Pedido p);
	/**
	 * Assinatura de um método que pesquisa pedidos utilizando o código do produto
	 * @param codProduto recebe um código do produto do tipo String
	 * @return o método tem como retorno uma lista do tipo Pedido, contendo os produtos que tem o código
	 * que foi passado como parâmetro.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	/**
	 * Este método remove um pedido
	 * @param numPedido recebe o número do pedido do tipo long à ser removido.
	 */
	public void removePedido(long numPedido);
}
