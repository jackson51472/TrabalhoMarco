package pacote;

public class Aluno extends Pessoa {
    private String nome;
    private Curso curso;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        if (this.curso == null) {
            throw new NullPointerException("Curso não cadastrado");
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCidadeEscola(){
        if (this.curso == null){
            return "Aluno sem curso";
        }
        return this.curso.getNomeCidade();
    }

    public String getNomeCoordenado(){
        if (this.curso == null){
            throw new NullPointerException("Aluno sem curso");
        }
        return curso.getNomeCoodernador();
    }

}
