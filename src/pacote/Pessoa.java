package pacote;

public class Pessoa {

    private Cidade cidade;
    private String nome;
    private Escolaridade escolaridade;

    public Cidade getCidade() {

        if (this.cidade == null) {
            throw new NullPointerException("Cidade não cadastrada");
        }

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
            throw new NullPointerException("Nome não cadastrado");
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }




}
