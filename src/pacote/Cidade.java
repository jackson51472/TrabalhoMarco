package pacote;

public class Cidade {
    private String nomeCidade;
    private Estado estado;

    public String getNomeCidade() {

        if (this.nomeCidade == null) {
            throw new NullPointerException("Nome da Cidade esta vazia");
        }

        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Estado getEstado() {

        if (this.estado == null) {
            throw new NullPointerException("Estado não cadastrada");
        }

        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
