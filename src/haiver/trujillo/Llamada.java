package haiver.trujillo;

public class Llamada {
    private String numeroLlamada;
    private TipoLlamada tipoLlamada;
    private int duracionLlamada;

    public Llamada(String numeroLlamada, TipoLlamada tipoLlamada, int duracionLlamada) {
        this.numeroLlamada = numeroLlamada;
        this.tipoLlamada = tipoLlamada;
        this.duracionLlamada = duracionLlamada;
    }

    public String getNumeroLlamada() {
        return numeroLlamada;
    }

    public TipoLlamada getTipoLlamada() {
        return tipoLlamada;
    }

    public int getDuracionLlamada() {
        return duracionLlamada;
    }
}
