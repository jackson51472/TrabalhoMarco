package pacote;

public class Cidade {
    private String nome;
    private Estado estado;

    public String getNome() {
        if (this.nome == null) {
            return "Cidade sem nome";
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        if (estado == null) {
            throw new NullPointerException("Estado nulo");
        }
        return estado.getNome();
    }

}
