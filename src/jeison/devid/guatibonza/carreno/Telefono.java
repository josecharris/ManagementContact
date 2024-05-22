package jeison.devid.guatibonza.carreno;

import java.util.HashMap;
import java.util.Map;

public class Telefono {
    private String numTeléfono;
    //private ArrayList<Llamada> llamadas = new ArrayList<>();
    private Map<String, Llamada> llamadas = new HashMap<>();

    public Telefono(String numTeléfono) {
        this.numTeléfono = numTeléfono;
    }

    public String getNumTeléfono() {
        return numTeléfono;
    }

    public void setNumTeléfono(String numTeléfono) {
        this.numTeléfono = numTeléfono;
    }

    public Map<String, Llamada> getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(Map<String, Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    

    
        
    


}
