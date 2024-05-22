package haiver.trujillo;

public class Telefono {
    private String numeroTelefono;
    private double valorMinuto;

    public Telefono(String numeroTelefono, double valorMinuto) {
        this.numeroTelefono = numeroTelefono;
        this.valorMinuto = valorMinuto;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public double getValorMinuto() {
        return valorMinuto;
    }
}


