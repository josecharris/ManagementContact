package jeison.devid.guatibonza.carreno;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String numTeléfono = "";
        String numLlamada = "";
        String tipoLlamada = "";
        double valorMinuto = 0;
        int duraciónLlamada = 0;
        
        int menu = 0;
        int menu2 = 0;

        Logic logic = new Logic();

        valorMinuto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor por minuto de las llamadas"));

        do {
            String[] buttons = {"Agregar número de teléfono",
                            "Agregar llamada",
                            "Consultar llamadas",
                            "Consultar total de minutos consumidos",
                            "Consultar valor total de las llamadas",
                            "Salir"};
            menu = JOptionPane.showOptionDialog(null,
                    "Seleccione una opción",
                    "Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    buttons,buttons[0]);

            switch (menu) {
                case 0:
                    numTeléfono = JOptionPane.showInputDialog("Ingrese el número de teléfono a registrar");
                    JOptionPane.showMessageDialog(null, logic.agregarTeléfono(numTeléfono));
                    break;

                case 1:
                    numTeléfono = JOptionPane.showInputDialog("Ingrese el número de teléfono desde el que va a hacer la llamada");
                    JOptionPane.showMessageDialog(null, logic.verificarNúmero(numTeléfono));
                    numLlamada = JOptionPane.showInputDialog(null, "Ingrese del número de teléfono al que va a hacer la llamada");

                    String[] buttons2 ={"Mismo operador",
                                        "Otro operador",
                                        "Nacional",
                                        "Internacional"};
                    menu2 = JOptionPane.showOptionDialog(null,
                            "Seleccione el tipo de llamada",
                            "Menu",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            buttons2,buttons2[0]);

                    switch (menu2) {
                        case 0:
                            tipoLlamada = "mismoOperador";
                            break;

                        case 1:
                            tipoLlamada = "otroOperador";
                            break;

                        case 2:
                            tipoLlamada = "nacional ";
                            break;

                        case 3:
                            tipoLlamada = "internacional";
                            break;
                    
                        default:
                            break;
                    }

                    duraciónLlamada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración de la llamada en la cantidad de minutos"));

                    logic.agregarLlamada(numTeléfono, numLlamada, tipoLlamada, valorMinuto, duraciónLlamada);
                    JOptionPane.showConfirmDialog(null, logic.calcValorLlamada(numTeléfono, numLlamada, valorMinuto));
                    
                    



                    break;

                case 2:
                    numTeléfono = JOptionPane.showInputDialog("Ingrese el número a consultar");
                    JOptionPane.showMessageDialog(null, logic.consultarLlamadas(numTeléfono));
                    break;

                case 3:
                    numTeléfono = JOptionPane.showInputDialog("Ingrese el número a consultar");
                    JOptionPane.showMessageDialog(null, logic.totalMinutos(numTeléfono));
                    break;

                case 4:
                    numTeléfono = JOptionPane.showInputDialog("Ingrese el número a consultar");
                    JOptionPane.showMessageDialog(null, logic.valorTotal(numTeléfono));
                    break;

                case 5:
                
                    break;

                default:

                    break;
            }
        } while (menu != 5);

        
    }
}
