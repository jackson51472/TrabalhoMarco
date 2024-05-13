package pacote;

public class TipoEnsino {
    private String tipo;

    public String getTipo() {
        if (this.tipo == null) {

            throw new NullPointerException("Nome do Tipo não cadastrado");

        }
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
