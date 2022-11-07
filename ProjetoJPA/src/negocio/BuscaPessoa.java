package negocio;

import entity.*;
import javax.persistence.*;

public class BuscaPessoa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eduvale_pu");
        EntityManager em = emf.createEntityManager();
        Pessoa p = em.find(Pessoa.class, 3); // Retorna um objeto MANAGED
        if (p != null) {
            System.out.println("ID: " + p.getId());
            System.out.println("Nome: " + p.getNome());
            //Objeto está MANAGED, porém, qualquer alteração NÃO será
            //refletida no banco de dados, pois não há Transação.
            p.setNome("Novo Nome");
        } else {
            System.out.println("Pessoa não encontrada!");
        }
    }
}

