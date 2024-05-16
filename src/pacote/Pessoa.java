package pacote;

public class Pessoa {

    private Cidade cidade;
    private String nome;
    private Escolaridade escolaridade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Escolaridade getEscolaridade()
    {
        if (this.escolaridade == null) {
            throw new NullPointerException("Escolaridade não cadastrada");
        }
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getNome() {
        if (this.nome == null) {
            return "Nome não cadastrado";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeEscolaridade(){
        if (this.escolaridade == null) {
            throw new NullPointerException("Escolaridade não cadastrada");
        }
        if (this.escolaridade.getNome() == null) {
            throw new NullPointerException("Escolaridade não tem nome cadastrado");
        }
        return this.escolaridade.getNome();
    }
    public String getNomeEstado(){

        if (this.cidade == null) {
            throw new NullPointerException("Cidade não cadastrada");
        }
        return cidade.getNomeEstado();
    }
    public String getCidadeEscola(){
        if (this.cidade == null) {
            throw new NullPointerException("Cidade não cadastrada");
        }
        return cidade.getNome();
    }




}
