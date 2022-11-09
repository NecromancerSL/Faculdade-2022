package negocio;

import java.util.List;
import javax.persistence.*;
import entity.*;

public class ExibeClientes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Cliente> consulta = em.createQuery("Select c from Cliente c " + 
						"where c.nome like :nome order by c.nome", Cliente.class);
		consulta.setParameter("nome", "%");
		List<Cliente> lista = consulta.getResultList();
		em.close();
		emf.close();
		for (Cliente c : lista) {
			System.out.println(c.getNome() + " = " + c.getEmail());
		}
	}
}