package haiver.trujillo;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Bienvenido al sistema de gesti�n de llamadas.");
            System.out.println("Por favor, ingrese el n�mero de tel�fono:");
            String numeroTelefono = scanner.nextLine();
            System.out.println("Ingrese el valor del minuto:");
            double valorMinuto = scanner.nextDouble();
            scanner.nextLine();
            Telefono telefono = new Telefono(numeroTelefono, valorMinuto);
            ControladorLlamadas controladorLlamadas = new ControladorLlamadas();

            while (true) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        agregarLlamada(telefono, controladorLlamadas);
                        break;
                    case 2:
                        controladorLlamadas.mostrarDetalleLlamadas(telefono);
                        break;
                    case 3:
                    	System.out.println("Ingrese el n�mero de tel�fono para buscar sus llamadas:");
                        String numeroBuscar = scanner.nextLine();
                        controladorLlamadas.mostrarLlamadasPorNumero(numeroBuscar);
//                       System.out.println("Costo total de llamadas: $" + controladorLlamadas.calcularCostoTotalLlamadas(telefono));
                        break;
                    case 4:
                        System.out.println("Total de minutos consumidos: " + controladorLlamadas.calcularTotalMinutos(telefono) + " minutos");
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        return;
                    default:
                        System.out.println("Opci�n inv�lida. Por favor, seleccione una opci�n v�lida.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingreso inv�lido. Por favor, ingrese un valor num�rico v�lido.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMen�:");
        System.out.println("1. Agregar llamada");
        System.out.println("2. Mostrar detalle de llamadas");
        System.out.println("3. Buscar llamadas por n�mero");
        System.out.println("4. Mostrar total de minutos consumidos");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opci�n:");
    }

    private static void agregarLlamada(Telefono telefono, ControladorLlamadas controladorLlamadas) {
        System.out.println("Ingrese el n�mero de la llamada:");
        String numeroLlamada = scanner.nextLine();
        System.out.println("Ingrese el tipo de llamada (MISMO_OPERADOR, OTRO_OPERADOR, NACIONAL, INTERNACIONAL):");
        TipoLlamada tipoLlamada = TipoLlamada.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Ingrese la duraci�n de la llamada (en minutos):");
        int duracionLlamada = scanner.nextInt();
        scanner.nextLine();

        Llamada llamada = new Llamada(numeroLlamada, tipoLlamada, duracionLlamada);
        controladorLlamadas.agregarLlamada(telefono, llamada);
        System.out.println("Llamada agregada correctamente.");
    }
}


