package negocio;

import java.util.List;
import entity.*;
import javax.persistence.*;

public class ConsultaPorTurma {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Aluno> consulta = em.createQuery("Select a from Aluno a where a.turma like :turma", Aluno.class);
        consulta.setParameter("turma", "%Direito%");
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
