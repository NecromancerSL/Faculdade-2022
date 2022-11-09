package negocio;

import java.text.DateFormat;
import java.util.List;
import javax.persistence.*;
import entity.*;

public class ExibePedidosPorCliente {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Pedido> consulta = em.createQuery("Select p from Pedido p "
				+ "where p.cliente.id = 1", Pedido.class);
		List<Pedido> lista = consulta.getResultList();

		em.close();
		emf.close();
	
		DateFormat df = DateFormat.getDateInstance();
		for (Pedido p : lista) {
			String d = df.format(p.getEmissao());
			System.out.println(p.getId() + " - " + p.getCliente().getNome() + " - " 
					+ d);
			for (Item item : p.getItens()) {
				System.out.println("\tProduto: " + item.getProduto().getDescricao()
						+ " = " + item.getQuantidade() + " x "
						+ item.getPrecoVenda());
			}
		}
	}
}
