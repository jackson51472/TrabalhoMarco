package pacote;

public class Escola {
    private String nome;
    private Professor diretor;
    private  Cidade cidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getDiretor() {

        if (this.diretor == null) {
            throw new NullPointerException("Diretor não cadastrado");
        }

        return diretor;
    }

    public void setDiretor(Professor diretor) {
        this.diretor = diretor;
    }

    public Cidade getCidade() {

        if (this.cidade == null) {
            throw new NullPointerException("Cidade não cadastrada");
        }

        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
