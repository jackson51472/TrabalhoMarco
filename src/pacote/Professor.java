package pacote;

public class Professor extends Pessoa {
    private Curso curso;

    public Curso getCurso() {
        if (this.curso == null) {
            throw new NullPointerException("Curso não cadastrado");
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String pegarEscolaridade() {
        if (getEscolaridade() == null) {
            return "Escolaridade nula";
        } else {
            return getEscolaridade().getNomeEscolaridade();
        }

    }

    public String retornaTipoEnsino() {

        if (this.curso == null) {
            return "Curso não cadastrado";
        }
        if (this.curso.getTipoEnsino() == null) {
            return "Curso encontro, mais sem Tipo de Ensino cadastrado";
        }
        if (this.curso.getTipoEnsino().getTipo() == null) {
            return "Curso encontro, mais sem o nome do Tipo de Ensino";
        }
        return curso.getTipoEnsino().getTipo();
    }

}
