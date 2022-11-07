package negocio;

import entity.*;
import javax.persistence.*;

public class BuscaPorRA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Aluno> consulta = em.createQuery("Select a from Aluno a where a.ra = :ra", Aluno.class);
            consulta.setParameter("ra", 123);
            Aluno a = consulta.getSingleResult();
            System.out.println("RA: " + a.getRa());
            System.out.println("Nome: " + a.getNome());
        } catch(NoResultException ex) {
            System.out.println("Aluno não encontrado");
        } catch(NonUniqueResultException ex) {
            System.out.println("Mais que um resultado encontrado");
        }
        em.close();
        emf.close();
    }
}
