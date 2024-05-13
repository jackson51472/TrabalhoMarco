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
            throw new NullPointerException("Nome não cadastrado");
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String retornarEstado(){
        if(this.cidade == null){

            return "Cidade e Estado não encontrado";

        }
        else if(this.cidade.getEstado() == null){

            return "Estado não encontrado";

        }
        else {
            return this.cidade.getEstado().getNomeEstado();
        }
    }

    public String retornarCidade(){
        if(this.cidade == null){
            return "Cidade não encontrada";
        } else {
          return this.cidade.getNomeCidade();
        }


    }
}
