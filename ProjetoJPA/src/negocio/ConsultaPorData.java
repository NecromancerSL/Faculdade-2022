package negocio;

import java.util.*;
import entity.*;
import javax.persistence.*;

public class ConsultaPorData {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Aluno> consulta = em.createQuery("Select a from Aluno a where a.dataNasc = :data", Aluno.class);
        GregorianCalendar data = new GregorianCalendar(2002, Calendar.JUNE, 10);
        consulta.setParameter("data", data.getTime(), TemporalType.DATE);

        List<Aluno> alunos = consulta.getResultList();
        if (!alunos.isEmpty()) {
            for (Aluno a : alunos) {
                System.out.println("Nome: " + a.getNome());
            }
        } else {
            System.out.println("Alunos não encontrados");
        }
        em.close();
        emf.close();
    }
}
