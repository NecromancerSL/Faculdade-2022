package negocio;

import java.text.DateFormat;
import java.util.*;
import javax.persistence.*;
import entity.*;

public class ExibePedidosPorData {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();

		TypedQuery<Pedido> consulta = em.createQuery("Select p from Pedido p "
				+ "where p.emissao between :data1 and :data2", Pedido.class);
		GregorianCalendar data = new GregorianCalendar(
				2022, Calendar. NOVEMBER, 1);
		consulta.setParameter("data1", data.getTime());
		data.set(2022, Calendar. NOVEMBER, 31);
		consulta.setParameter("data2", data.getTime());
		List<Pedido> lista = consulta.getResultList();
		em.close();
		emf.close();		DateFormat df = DateFormat.getDateInstance();
		for (Pedido p : lista) {
			String d = df.format(p.getEmissao());
			System.out.println(p.getId() + " - " + p.getCliente().getNome() + " - " + d);
			for (Item item : p.getItens()) {
				System.out.println("\tProduto: " + item.getProduto().getDescricao()
						+ " = " + item.getQuantidade() + " x "
						+ item.getPrecoVenda());
			}
		}
	}
}
