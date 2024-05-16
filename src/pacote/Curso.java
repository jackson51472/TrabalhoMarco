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
        return coodernador;
    }

    public void setCoodernador(Professor coodernador) {
        this.coodernador = coodernador;
    }

    public Escola getEscola() {
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

    public String getNomeEscolaridadeCoodernador(){
        if(this.coodernador == null){
            throw new NullPointerException("Coodernado não cadastrado");
        }
        return this.coodernador.getNomeEscolaridade();
    }

    public String getNomeCoodernador(){
        if(this.coodernador == null){
            throw new NullPointerException("Curso sem coodernador");
        }
        return this.coodernador.getNome();
    }

    public String getNomeCidade(){
        if(this.escola == null){
            return "Sem escola cadastrada";
        }
        return this.escola.getNomeCidade();
    }

    public String getNomeTipoEnsino(){
        if(this.tipoEnsino == null){
            return "Tipo ensino não cadastrado";
        }
        return tipoEnsino.getTipo();
    }

    public String getNomeDiretor(){
        if(this.escola == null){
            throw  new NullPointerException("Curso sem escola cadastrada");
        }
        return escola.getNomeDiretor();
    }
}
