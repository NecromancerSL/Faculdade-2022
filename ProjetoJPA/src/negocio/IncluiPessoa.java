package negocio;

import entity.*;
import javax.persistence.*;
import java.util.*;

public class IncluiPessoa {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Breno");
        GregorianCalendar data =
                new GregorianCalendar(2008, Calendar.FEBRUARY, 25);
        p.setDataNasc(data.getTime());
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p); //insere o objeto no banco de dados
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("id da pessoa persistida: " + p.getId());
    }
}
