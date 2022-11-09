package negocio;

import javax.persistence.*;
import entity.Cliente;

public class IncluiCliente {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Cliente c = new Cliente();
		c.setNome("Breno");
		c.setEmail("breno@gmail.com");
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("id do cliente persistido: " + c.getId());
	}
}
