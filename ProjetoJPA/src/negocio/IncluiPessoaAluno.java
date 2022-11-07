package negocio;

import entity.*;
import javax.persistence.*;
import java.util.*;
import java.math.*;

public class IncluiPessoaAluno {
    public static void main(String[] args) {
        //Pessoa p = new Pessoa();
        //p.setNome("Breno");
        //GregorianCalendar dataP = new GregorianCalendar(2008, Calendar. FEBRUARY, 10);
        //p.setDataNasc(dataP.getTime());

        Aluno a = new Aluno();
        a.setNome("Augusto");
        GregorianCalendar dataA = new GregorianCalendar(2002, Calendar.JANUARY, 24);
        a.setDataNasc(dataA.getTime());
        a.setRa(133);
        a.setTurma("Direito");
        //a.setMensalidade(new BigDecimal(123.45));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //em.persist(p);
        em.persist(a);

        em.getTransaction().commit();
        em.close();
        emf.close();

        //System.out.println("Pessoa gravada: " + p.getId() + " - " + p.getNome());
        System.out.println("Aluno gravado: " + a.getId() + " - " + a.getNome());
    }
}

