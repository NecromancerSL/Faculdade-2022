package entity;

public class CursoQtd {
    private String curso;
    private Long quantidade;

    public CursoQtd(String curso, Long quantidade) {
        super();
        this.curso = curso;
        this.quantidade = quantidade;
    }

    public String getCurso() {
        return curso;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
