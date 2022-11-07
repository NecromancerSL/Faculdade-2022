package negocio;

import entity.*;
import javax.persistence.*;
import java.util.*;

public class AlteraPessoa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 1); //Retorna um objeto MANAGED
        if (p != null) {
            p.setNome("Novo Nome");
            p.setDataNasc(new Date());
            System.out.println("id da pessoa alterada: " + p.getId());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

