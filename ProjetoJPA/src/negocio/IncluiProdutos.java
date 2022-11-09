package negocio;

import javax.persistence.*;
import java.math.*;
import entity.Produto;

public class IncluiProdutos {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Produto p1 = new Produto();	
		p1.setDescricao("Bolacha");	p1.setPreco(new BigDecimal(1.99));
		Produto p2 = new Produto();	  
		p2.setDescricao("Biscoito");	p2.setPreco(new BigDecimal(2.50));
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("id da Bolacha: " + p1.getId());
		System.out.println("id do Biscoito: " + p2.getId());
	}
}
