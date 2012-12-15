package Exercicio06;
import java.util.List;
/**
 * A interface cria sistemas de controle de pedido.
 * @author BERG
 *
 */
public interface InterfaceSistemaDeControle {
	/**
	 * Assinatura de um m�todo que adiciona um pedido.
	 * @param p recebe um objeto do tipo Pedido.
	 */
	public void adicionaPedido(Pedido p);
	/**
	 * Assinatura de um m�todo que pesquisa pedidos utilizando o c�digo do produto
	 * @param codProduto recebe um c�digo do produto do tipo String
	 * @return o m�todo tem como retorno uma lista do tipo Pedido, contendo os produtos que tem o c�digo
	 * que foi passado como par�metro.
	 */
	public List<Pedido> pesquisaPedidosIncluindoProduto(String codProduto);
	/**
	 * Este m�todo remove um pedido
	 * @param numPedido recebe o n�mero do pedido do tipo long � ser removido.
	 */
	public void removePedido(long numPedido);
}
