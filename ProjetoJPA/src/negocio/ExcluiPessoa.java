package negocio;

import entity.*;
import javax.persistence.*;

public class ExcluiPessoa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 8);
        if (p != null) {
            em.remove(p);    /*Objeto torna-se REMOVED, qualquer alteração
    							não será refletida no banco de dados.*/
            System.out.println("Pessoa excluída: " + p.getId());
            System.out.println("                 " + p.getNome());
        } else {
            System.out.println("Pessoa não encontrada!");
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
