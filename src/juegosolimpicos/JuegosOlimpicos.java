package juegosolimpicos;

import java.util.Scanner;

public class JuegosOlimpicos {
    static String[] paises;
    static int[] oro, plata, bronce, puntajeTotal;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            int opcion;
            
            while (!salir) {
                System.out.println("\nJuegos Olímpicos de Tokio 2020 - Menú Principal");
                System.out.println("1. Iniciar el programa");
                System.out.println("2. Registrar información de los países");
                System.out.println("3. Calcular puntaje total de cada país");
                System.out.println("4. Imprimir tabla de puntajes");
                System.out.println("5. País con más medallas de plata");
                System.out.println("6. Promedio de medallas de bronce");
                System.out.println("7. Medallero informativo");
                System.out.println("8. Ordenar puntajes y países");
                System.out.println("9. Imprimir tabla de posiciones");
                System.out.println("10. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        iniciarPrograma(scanner);
                        break;
                    case 2:
                        registrarInformacion(scanner);
                        break;
                    case 3:
                        calcularPuntajeTotal();
                        break;
                    case 4:
                        imprimirPuntajeTotal();
                        break;
                    case 5:
                        imprimirPaisConMasPlata();
                        break;
                    case 6:
                        calcularPromedioBronce();
                        break;
                    case 7:
                        imprimirMedalleroInformativo();
                        break;
                    case 8:
                        ordenarPuntajesYPaises();
                        break;
                    case 9:
                        imprimirTablaPosiciones();
                        break;
                    case 10:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void iniciarPrograma(Scanner scanner) {
        System.out.print("Ingrese el número de países: ");
        int n = scanner.nextInt();
        paises = new String[n];
        oro = new int[n];
        plata = new int[n];
        bronce = new int[n];
        puntajeTotal = new int[n];
    }

    private static void registrarInformacion(Scanner scanner) {
        for (int i = 0; i < paises.length; i++) {
            System.out.print("Nombre del país " + (i + 1) + ": ");
            paises[i] = scanner.next();
            System.out.print("Oro para " + paises[i] + ": ");
            oro[i] = scanner.nextInt();
            System.out.print("Plata para " + paises[i] + ": ");
            plata[i] = scanner.nextInt();
            System.out.print("Bronce para " + paises[i] + ": ");
            bronce[i] = scanner.nextInt();
        }
    }

    private static void calcularPuntajeTotal() {
        for (int i = 0; i < paises.length; i++) {
            puntajeTotal[i] = oro[i] * 3 + plata[i] * 2 + bronce[i];
        }
    }

    private static void imprimirPuntajeTotal() {
        System.out.println("\nTabla de puntajes");
        for (int i = 0; i < paises.length; i++) {
            System.out.println(paises[i] + " - Puntaje total: " + puntajeTotal[i]);
        }
    }

    private static void imprimirPaisConMasPlata() {
        int maxPlata = -1;
        String paisMaxPlata = "";
        for (int i = 0; i < paises.length; i++) {
            if (plata[i] > maxPlata) {
                maxPlata = plata[i];
                paisMaxPlata = paises[i];
            }
        }
        System.out.println("País con más medallas de plata: " + paisMaxPlata);
    }

    private static void calcularPromedioBronce() {
        int totalBronce = 0;
        for (int valor : bronce) {
            totalBronce += valor;
        }
        double promedio = (double) totalBronce / paises.length;
        System.out.println("Promedio de medallas de bronce: " + promedio);
    }

    private static void imprimirMedalleroInformativo() {
        System.out.println("\nMedallero Informativo");
        for (int i = 0; i < paises.length; i++) {
            System.out.println(paises[i] + " - Oro: " + oro[i] + ", Plata: " + plata[i] + ", Bronce: " + bronce[i]);
        }
    }

    private static void ordenarPuntajesYPaises() {
        for (int i = 0; i < puntajeTotal.length - 1; i++) {
            for (int j = 0; j < puntajeTotal.length - i - 1; j++) {
                if (puntajeTotal[j] < puntajeTotal[j + 1]) {
                    int temp = puntajeTotal[j];
                    puntajeTotal[j] = puntajeTotal[j + 1];
                    puntajeTotal[j + 1] = temp;

                    String tempPais = paises[j];
                    paises[j] = paises[j + 1];
                    paises[j + 1] = tempPais;
                }
            }
        }
    }

    private static void imprimirTablaPosiciones() {
        System.out.println("\nTabla de Posiciones");
        for (int i = 0; i < paises.length; i++) {
            System.out.println((i + 1) + ". " + paises[i] + " - Puntaje total: " + puntajeTotal[i]);
        }
    }
}


