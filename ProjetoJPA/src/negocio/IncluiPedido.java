package negocio;

import java.util.Date;
import java.math.*;
import javax.persistence.*;
import entity.*;

public class IncluiPedido {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pedido ped = new Pedido();
		Cliente c = em.find(Cliente.class, 1);
		ped.setCliente(c);
		ped.setEmissao(new Date());
		Produto prod1 = em.find(Produto.class, 1);
		Item i1 = new Item();
		i1.setProduto(prod1);
		i1.setQuantidade(11);
		BigDecimal desconto = new BigDecimal(0.9);
		i1.setPrecoVenda(prod1.getPreco().multiply(desconto));
		Produto prod2 = em.find(Produto.class, 2);
		Item i2 = new Item();
		i2.setProduto(prod2);
		i2.setQuantidade(22);
		i2.setPrecoVenda(prod2.getPreco());
		ped.getItens().add(i1);		
		ped.getItens().add(i2);
		em.persist(ped);
		em.getTransaction().commit();
		em.close();	emf.close();
		System.out.println("id do Pedido: " + ped.getId());
		System.out.println("Emissão: " + ped.getEmissao());
		System.out.println("Cliente: " + ped.getCliente().getNome());
		System.out.println("Itens:");
		for (Item item : ped.getItens()) {
			String texto = "Produto: " + item.getProduto().getDescricao();
			texto += ": " + item.getQuantidade();
			texto += " x " + item.getPrecoVenda();
			texto += " = " + item.getQuantidade() * item.getPrecoVenda().doubleValue();
			System.out.println(texto);
		}
	}
}


