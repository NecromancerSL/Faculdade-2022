package entity;

import javax.persistence.*;
import java.io.*;
import java.util.Date;


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

    @PostPersist
    void gravaLog() {
        try {
            // Cria arquivo na pasta raiz do projeto
            FileOutputStream fos = new FileOutputStream("log.txt", true);
            String linha = "Aluno " + getNome()
                    + " gravado em " + new Date() + "\n";
            fos.write(linha.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


