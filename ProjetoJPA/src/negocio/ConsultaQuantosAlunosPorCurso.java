package negocio;
import java.util.List;
import javax.persistence.*;
import entity.CursoQtd;

public class ConsultaQuantosAlunosPorCurso {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT NEW entity.CursoQtd(a.turma, COUNT(a)) " +
                "from Aluno a GROUP BY a.turma ";
        TypedQuery<CursoQtd> consulta = em.createQuery(jpql, CursoQtd.class);
        List<CursoQtd> cursos = consulta.getResultList();
        for(CursoQtd curso : cursos) {
            System.out.println(curso.getCurso() + " : " + curso.getQuantidade());
        }
        em.close();
        emf.close();
    }
}
