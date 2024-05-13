package pacote;
public class Curso {

    private String nome;
    private Professor coodernador;
    private Escola escola;
    private TipoEnsino tipoEnsino;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getCoodernador() {
        if (this.coodernador == null) {
            throw new NullPointerException("Coodernado não cadastrado");
        }
        return coodernador;
    }

    public void setCoodernador(Professor coodernador) {
        this.coodernador = coodernador;
    }

    public Escola getEscola() {
        if (this.escola == null) {
            throw new NullPointerException("Escola não cadastrada");
        }

        return escola;
    }



    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public TipoEnsino getTipoEnsino() {
        return this.tipoEnsino;
    }

    public void setTipoEnsino(TipoEnsino tipoEnsino) {
        this.tipoEnsino = tipoEnsino;
    }
}
