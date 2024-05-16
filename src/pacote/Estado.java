package pacote;

public class Estado {
    private String nome;

    public String getNome() {

        if (this.nome == null) {
            throw new NullPointerException("Nome do Estado não cadastrado");
        }

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
