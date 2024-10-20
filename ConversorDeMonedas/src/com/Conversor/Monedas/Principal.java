package com.Conversor.Monedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Comvertir consulta = new Comvertir();
        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;
        double valorFinal;

        while (eleccion != 7) {
            System.out.println("**********************************************");
            System.out.println("Bienvenido al conversor de monedas :) \n");
            System.out.println("""
                1. chile(Peso) => USA (Dolar)
                2. USA (Dolar) => chile(Peso)
                3. Argentina(Peso) => USA (Dolar)
                4. USA (Dolar) => Argentina(Peso) 
                5. Colombia(Peso) => USA (Dolar)  
                6. USA(dolar) => Colombia(Peso)  
                7. Salir""");
            System.out.println("************************************************");
            System.out.println("Elija una opcion valida: ");
            eleccion = teclado.nextInt();
            if (eleccion == 7) {
                break;
            }

            System.out.println("Ingresa el valor que desea convertir: ");
            int cant = teclado.nextInt();

            String baseCode = "", targetCode = "";
            switch (eleccion) {
                case 1 -> {
                    baseCode = "CLP";
                    targetCode = "USD";
                }
                case 2 -> {
                    baseCode = "USD";
                    targetCode = "CLP";
                }
                case 3 -> {
                    baseCode = "ARS";
                    targetCode = "USD";
                }
                case 4 -> {
                    baseCode = "USD";
                    targetCode = "ARS";
                }
                case 5 -> {
                    baseCode = "COP";
                    targetCode = "USD";
                }
                case 6 -> {
                    baseCode = "USD";
                    targetCode = "COP";
                }
                default -> System.out.println("La opcion ingresada no es válida, por favor seleccione una opción de 1 a 7");
            }

            if (!baseCode.isEmpty()) {
                Double tasaConversion = consulta.busquedaMoneda(baseCode, targetCode);
                valorFinal = cant * tasaConversion;  // Multiplicamos los valores como double
                System.out.printf("El valor de %d [%s] corresponde al valor final de %.2f [%s]%n", cant, baseCode, valorFinal, targetCode);
            }
        }

        System.out.println("***************************************************");
        System.out.println("¡Cerrando Programa !");
    }
}



