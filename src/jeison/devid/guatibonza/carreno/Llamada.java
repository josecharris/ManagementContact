package jeison.devid.guatibonza.carreno;

public class Llamada {
    private String numLlamada;
    private String tipoLlamada;
    private Double valorMinuto;
    private Integer duraciónLlamada;
    private Double valorTotalLlamada;
    
    public Llamada(String numLlamada, String tipoLlamada, Double valorMinuto, Integer duraciónLlamada) {
        this.numLlamada = numLlamada;
        this.tipoLlamada = tipoLlamada;
        this.valorMinuto = valorMinuto;
        this.duraciónLlamada = duraciónLlamada;
    }

    public String getNumLlamada() {
        return numLlamada;
    }

    public void setNumLlamada(String numLlamada) {
        this.numLlamada = numLlamada;
    }

    public String getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

    public Double getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(Double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public Integer getDuraciónLlamada() {
        return duraciónLlamada;
    }

    public void setDuraciónLlamada(Integer duraciónLlamada) {
        this.duraciónLlamada = duraciónLlamada;
    }

    public Double getValorTotalLlamada() {
        return valorTotalLlamada;
    }

    public void setValorTotalLlamada(Double valorTotalLlamada) {
        this.valorTotalLlamada = valorTotalLlamada;
    }

    public String toString(){
        String llamada = "";
        llamada = "número: " + numLlamada + "\n";
        llamada += "tipo de llamada: " + tipoLlamada + "\n";
        llamada += "duración de la llamada: " + duraciónLlamada + "\n";
        llamada += "valor total de la llamada: " + valorTotalLlamada + "\n";

        return llamada;
    }

    

}