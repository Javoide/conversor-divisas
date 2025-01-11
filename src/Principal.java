import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();

        while (true) {
            System.out.println("***********************************************************************");
            System.out.println("Bienvenido al conversor de divisas. Seleccione la divisa que desea convertir:");
            System.out.println("1.- DÓLAR ESTADOUNIDENSE (USD)");
            System.out.println("2.- EURO (EUR)");
            System.out.println("3.- PESO CHILENO (CLP)");
            System.out.println("4.- PESO ARGENTINO (ARS)");
            System.out.println("5.- REAL BRASILEÑO (BRL)");
            System.out.println("6.- DÓLAR CANADIENSE (CAD)");
            System.out.println("7.- YEN JAPONÉS (JPY)");
            System.out.println("8.- SALIR");
            System.out.println("***********************************************************************");
            System.out.print("Ingrese su elección: ");

            String opcionBase = lectura.nextLine().trim();

            if (opcionBase.equals("8")) {
                System.out.println("Gracias por usar el conversor de divisas. ¡Hasta luego!");
                break;
            }

            String nombreDivisaBase = obtenerDivisa(opcionBase);
            if (nombreDivisaBase == null) {
                System.out.println("Opción inválida. Por favor, intente de nuevo.");
                continue;
            }

            try {
                Divisas divisas = consulta.consultaDivisa(nombreDivisaBase);
                System.out.println("Base seleccionada: " + divisas.base_code());

                while (true) {
                    System.out.println("Seleccione una divisa para convertir:");
                    System.out.println("1.- DÓLAR ESTADOUNIDENSE (USD)");
                    System.out.println("2.- EURO (EUR)");
                    System.out.println("3.- PESO CHILENO (CLP)");
                    System.out.println("4.- PESO ARGENTINO (ARS)");
                    System.out.println("5.- REAL BRASILEÑO (BRL)");
                    System.out.println("6.- DÓLAR CANADIENSE (CAD)");
                    System.out.println("7.- YEN JAPONÉS (JPY)");
                    System.out.println("8.- Volver al menú principal");
                    System.out.print("Ingrese su elección: ");

                    String opcionDestino = lectura.nextLine().trim();

                    if (opcionDestino.equals("8")) {
                        System.out.println("Regresando al menú principal...");
                        break;
                    }

                    String nombreDivisaDestino = obtenerDivisa(opcionDestino);
                    if (nombreDivisaDestino == null) {
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                        continue;
                    }

                    Double tasaConversion = divisas.conversion_rates().get(nombreDivisaDestino);
                    if (tasaConversion != null) {
                        System.out.print("Ingrese la cantidad de " + nombreDivisaBase + " que desea convertir: ");
                        try {
                            double cantidad = Double.parseDouble(lectura.nextLine().trim());
                            double resultado = cantidad * tasaConversion;
                            System.out.printf("La conversión de %.2f %s a %s es: %.2f%n", cantidad, nombreDivisaBase, nombreDivisaDestino, resultado);
                        } catch (NumberFormatException e) {
                            System.out.println("Cantidad inválida. Por favor, ingrese un número válido.");
                        }
                    } else {
                        System.out.println("La divisa seleccionada no está disponible para conversión.");
                    }
                }

            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        lectura.close();
    }

    private static String obtenerDivisa(String opcion) {
        return switch (opcion) {
            case "1" -> "USD";
            case "2" -> "EUR";
            case "3" -> "CLP";
            case "4" -> "ARS";
            case "5" -> "BRL";
            case "6" -> "CAD";
            case "7" -> "JPY";
            default -> null;
        };
    }
}
