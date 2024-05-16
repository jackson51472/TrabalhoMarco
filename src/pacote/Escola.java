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

        return diretor;
    }

    public void setDiretor(Professor diretor) {
        this.diretor = diretor;
    }

    public Cidade getCidade() {

        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNomeEscolaridadeDiretor(){
        if(diretor == null){
            throw new NullPointerException("Diretor não cadastrado");

        }
        return diretor.getNomeEscolaridade();
    }

    public String getNomeCidade(){
        if(cidade == null){
            return "Escola sem cidade";
        }
        return cidade.getNome();
    }

    public String getNomeDiretor(){
        if (this.diretor == null) {
            throw  new NullPointerException("Escola sem diretor");
        }
        return diretor.getNome();
    }

}
