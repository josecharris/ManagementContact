package haiver.trujillo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;

public class ControladorLlamadas {
    private Map<String, List<Llamada>> llamadasPorNumero;

    public ControladorLlamadas() {
        this.llamadasPorNumero = new HashMap<>();
    }

    public void agregarLlamada(Telefono telefono, Llamada llamada) {
        String numeroLlamada = llamada.getNumeroLlamada();
        if (llamadasPorNumero.containsKey(numeroLlamada)) {
            llamadasPorNumero.get(numeroLlamada).add(llamada);
        } else {
            List<Llamada> llamadas = new ArrayList<>();
            llamadas.add(llamada);
            llamadasPorNumero.put(numeroLlamada, llamadas);
        }
    }

    public void mostrarDetalleLlamadas(Telefono telefono) {
        System.out.println("Detalle de llamadas:");
        for (List<Llamada> listaLlamadas : llamadasPorNumero.values()) {
            for (Llamada llamada : listaLlamadas) {
                System.out.println("Numero: "+llamada.getNumeroLlamada() + "\n" + "Tipo de llamada: " + llamada.getTipoLlamada() + "\nDuracion: " +
                        llamada.getDuracionLlamada() + " min\nCosto: $" + calcularCostoLlamada(llamada, telefono.getValorMinuto()));
            }
        }
        System.out.println("Costo total de llamadas: $" + calcularCostoTotalLlamadas(telefono));
    }

    private double calcularCostoTotalLlamadas(Telefono telefono) {
        double costoTotal = 0;
        for (List<Llamada> listaLlamadas : llamadasPorNumero.values()) {
            for (Llamada llamada : listaLlamadas) {
                costoTotal += calcularCostoLlamada(llamada, telefono.getValorMinuto());
            }
        }
        return costoTotal;
    }

    private double calcularCostoLlamada(Llamada llamada, double valorMinuto) {
        double costo = valorMinuto * llamada.getDuracionLlamada();
        switch (llamada.getTipoLlamada()) {
            case MISMO_OPERADOR:
                break;
            case OTRO_OPERADOR:
                costo *= 1.05;
                break;
            case NACIONAL:
                costo *= 1.10;
                break;
            case INTERNACIONAL:
                costo *= 1.15;
                break;
        }
        return costo;
    }

    public int calcularTotalMinutos(Telefono telefono) {
        int totalMinutos = 0;
        for (List<Llamada> listaLlamadas : llamadasPorNumero.values()) {
            for (Llamada llamada : listaLlamadas) {
                totalMinutos += llamada.getDuracionLlamada();
            }
        }
        return totalMinutos;
    }
    
    public void mostrarLlamadasPorNumero(String numeroTelefono) {
        if (llamadasPorNumero.containsKey(numeroTelefono)) {
            System.out.println("Llamadas asociadas al n�mero " + numeroTelefono + ":");
            List<Llamada> llamadas = llamadasPorNumero.get(numeroTelefono);
            for (Llamada llamada : llamadas) {
                System.out.println("N�mero de llamada: " + llamada.getNumeroLlamada() +
                        ", Tipo de llamada: " + llamada.getTipoLlamada() +
                        ", Duraci�n: " + llamada.getDuracionLlamada() + " minutos");
            }
        } else {
            System.out.println("No hay llamadas asociadas al n�mero " + numeroTelefono);
        }
    }
}

