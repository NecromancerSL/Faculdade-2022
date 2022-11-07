package entity;

import javax.persistence.*;
import java.util.* ;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)


public class Pessoa {
	@Id
	@GeneratedValue	(strategy=GenerationType.IDENTITY)
	private int id ;
	private String nome;
	@Temporal(TemporalType.DATE)
	private Date dataNasc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}


