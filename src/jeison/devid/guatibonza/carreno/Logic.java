package jeison.devid.guatibonza.carreno;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    Map<String, Telefono> teléfonos = new HashMap<>();

    public String agregarTeléfono(String numTeléfono){
        String mensaje;
        if (teléfonos.containsKey(numTeléfono)) {
            mensaje = "Ese número de teléfono ya existe";
        }else{
            Telefono teléfono = new Telefono(numTeléfono);
            teléfonos.put(numTeléfono, teléfono);
            mensaje = "Número guardado correctamente";
        }
        

        return mensaje;
    }

    public String agregarLlamada(String numTeléfono, String numLlamada, String tipoLlamada, Double valorMinuto,Integer duraciónLlamada){
        String mensaje;
        if (teléfonos.containsKey(numTeléfono)) {
            Llamada llamada = new Llamada(numLlamada, tipoLlamada, valorMinuto, duraciónLlamada);
            teléfonos.get(numTeléfono).getLlamadas().put(numLlamada, llamada);
            mensaje = "Llamada agregada correctamente";
        }else{
            mensaje = "Ese número de teléfono no existe";
        }

        return mensaje;
    }

    public String verificarNúmero(String numTeléfono){
        String mensaje;
        if (teléfonos.containsKey(numTeléfono)) {
            mensaje = "Número correcto";
        }else{
            mensaje = "Ese número de teléfono no existe";
        }

        return mensaje;
    }

    public String calcValorLlamada(String numTeléfono, String numLlamada, double valorMinuto){
        String mensaje;
        int cantidadMinutos;
        double totalLlamada;

        cantidadMinutos  = teléfonos.get(numTeléfono).getLlamadas().get(numLlamada).getDuraciónLlamada();
        totalLlamada = cantidadMinutos *valorMinuto;

        teléfonos.get(numTeléfono).getLlamadas().get(numLlamada).setValorTotalLlamada(totalLlamada);

        mensaje = teléfonos.get(numTeléfono).getLlamadas().get(numLlamada).toString();

        return mensaje;
    }
    
    public String consultarLlamadas(String numTeléfono){
        String mensaje = "Llamadas del número " + numTeléfono ;
        for (String key  : teléfonos.get(numTeléfono).getLlamadas().keySet()) {
            mensaje += teléfonos.get(numTeléfono).getLlamadas().toString();
        }
        
        return mensaje;
    }

    public double valorTotal(String numTeléfono){
        double total = 0;
        for (String key  : teléfonos.get(numTeléfono).getLlamadas().keySet()) {
            total += teléfonos.get(numTeléfono).getLlamadas().get(key).getValorTotalLlamada();
        }

        return total;
    }

    public int totalMinutos(String numTeléfono){
        int total = 0;
        for (String key  : teléfonos.get(numTeléfono).getLlamadas().keySet()) {
            total += teléfonos.get(numTeléfono).getLlamadas().get(key).getDuraciónLlamada();
        }

        return total;
    }
}
