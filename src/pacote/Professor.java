package pacote;

public class Professor extends Pessoa {
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNomeTipoEnsino(){
        if(this.curso == null){
            return "Curso não cadastrado";
        }
        return this.curso.getNomeTipoEnsino();
    }

    public String getNomeDiretor(){

        if (this.curso == null) {
            throw new NullPointerException("Professor sem curso");
        }
        return curso.getNomeDiretor();
    }

    public String getNomeCoordenadorCurso(){
        if (this.curso == null) {
            throw new NullPointerException("Professor sem curso");
        }
        return curso.getNomeCoodernador();
    }
}
