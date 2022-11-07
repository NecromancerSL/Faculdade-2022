package negocio;

import javax.persistence.*;

public class TransfereTurma {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query alteracao = em.createQuery(
                "Update Aluno set turma = :novaTurma");
        alteracao.setParameter("novaTurma", "Sistemas");
        int qtdAlunos = alteracao.executeUpdate();

        System.out.println(qtdAlunos + " Aluno(s) transferidos de turma");

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

