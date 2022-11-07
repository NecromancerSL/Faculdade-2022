package negocio;

import entity.*;
import javax.persistence.*;
import java.util.List;

public class ConsultaNomeada {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> consulta =
                em.createNamedQuery("consultaPorTurma", Aluno.class);
        consulta.setParameter("turma", "Análise");
        List <Aluno>alunos = consulta.getResultList();
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
