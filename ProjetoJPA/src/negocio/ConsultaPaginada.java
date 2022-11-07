package negocio;

import entity.*;
import javax.persistence.*;
import java.util.List;

public class ConsultaPaginada {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static List<Aluno> getAlunos(int maximo, int inicio) {
        TypedQuery<Aluno> consulta =
                em.createQuery("Select a from Aluno a", Aluno.class);
        return consulta.setMaxResults(maximo).
                setFirstResult(inicio).
                getResultList();
    }
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory ("eduvale_pu");
        em = emf.createEntityManager();
        int inicio = 0, maximo = 3;
        int pagina = 1;
        List <Aluno> alunos = null;
        do {
            alunos = getAlunos(maximo, inicio);
            if (!alunos.isEmpty()) {
                System.out.println("Pág. " + pagina);
                for (Aluno a : alunos) {
                    System.out.println("\tNome: " + a.getNome());
                }
            }
            inicio += maximo;
            pagina++;
        } while (!alunos.isEmpty());
        em.close();
        emf.close();
    }
}


