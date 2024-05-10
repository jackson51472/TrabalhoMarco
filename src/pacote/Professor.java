package pacote;

public class Professor extends Pessoa{
    private Curso curso;
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String pegarEscolaridade(){
        if (getEscolaridade() == null){
            return "Escolaridade nula";
        } else {
            return getEscolaridade().getNomeEscolaridade();
        }

    }

    public String retornaTipoEnsino(){

        if (this.curso == null){
            return "Curso não cadastrado";
        }
        if (this.curso.getTipoEnsino() == null){
            return "Curso encontro, mais sem Tipo de Ensino cadastrado";
        }
        if (this.curso.getTipoEnsino().getTipo() == null){
            return "Curso encontro, mais sem o nome do Tipo de Ensino";
        }
        return curso.getTipoEnsino().getTipo();
    }

    public String retornaDiretor(){
        if (this.curso == null){return "Curso não cadastrado";}

        if (this.curso.getEscola() == null) {return  "Sem escola cadastrada";}

        if (this.curso.getEscola().getDiretor() == null) {return  "Escola do sem Diretor cadastrado";}

        if (this.curso.getEscola().getDiretor().getNome() == null) {return  "Diretor sem Nome cadastrado";}

        return this.curso.getEscola().getDiretor().getNome();
    }
    public String retornaCoodernadoCurso(){
        if (this.curso == null){return "Curso não cadastrado";}

        if (this.curso.getCoodernador() == null) { return  "Coodernado não cadastrado";}

        if (this.curso.getCoodernador().getNome() == null) {return  "Nome do Coodernado não foi cadastrado";}

        return this.curso.getCoodernador().getNome();
    }


}
