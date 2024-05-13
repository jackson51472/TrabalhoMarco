package pacote;

public class Estado {
    public String getNomeEstado() {

        if (this.nomeEstado == null) {
            throw new NullPointerException("Nome do Estado não cadastrado");
        }

        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    private String nomeEstado;
}
