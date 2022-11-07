package negocio;
import javax.persistence.*;
public class ConsultaMediaMensalidade {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();

        String jpql = "select avg(a.mensalidade) from Aluno a";
        TypedQuery<Double> consulta = em.createQuery(jpql, Double.class);
        Double media = consulta.getSingleResult();

        System.out.println("Média da Mensalidade: " + media);
        em.close();
        emf.close();
    }
}
