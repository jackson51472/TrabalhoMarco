package pacote;

public class Escolaridade {
    public String getNomeEscolaridade() {

        if (this.nomeEscolaridade == null) {
            throw new NullPointerException("Escolaridade não tem nome cadastrado");
        }

        return nomeEscolaridade;
    }

    public void setNomeEscolaridade(String nomeEscolaridade) {
        this.nomeEscolaridade = nomeEscolaridade;
    }

    private String nomeEscolaridade;
}