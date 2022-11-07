package entity;

import javax.persistence.*;

@NamedQueries ( {
        @NamedQuery (name = "buscaPorRA",
                query = "Select a from Aluno a where a.ra = :ra"),
        @NamedQuery (name = "consultaPorTurma",
                query = "Select a from Aluno a where a.turma = :turma") } )

@Entity
public class Aluno extends Pessoa {
    private int ra;
    private String turma;


    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
}

