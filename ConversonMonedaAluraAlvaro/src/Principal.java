import java.util.Scanner;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.sound.midi.Soundbank;

public class Principal {


    public static void main(String[] args) {
        String operacion ="";
        Scanner teclado = new Scanner(System.in);
        Tasa tasa = new Tasa();

        String monedaIn="",monedaOut="";
        double montoIn ,montoOut;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();


        System.out.println("Bienvenido al Conversor de monedas");

        while(true){
            System.out.println("""
                    ***************************************
                                    Menú
                    ***************************************
                    
                    1- Dolar a Peso Colombiano
                    2- Peso Colobiano a Dolar
                    3- Dolar a Peso Argentino
                    4- Peso Argentino a Dolar
                    5- Dolar a Peso Chileno
                    6- Peso Chileno a Dolar
                    7- Salir
                    
                    Seleccione la Operacion a Realizar: 
                    
                    
                    """);
            int opcion = teclado.nextInt();
            if(opcion==7){
                break;
            }
            switch (opcion){
                case 1:
                    tasa.setOperacionTasa("USD/COP");
                    monedaOut ="COP";
                    monedaIn="USD";
                    tasa.tasaConsulta();
                    break;
                case 2:
                    tasa.setOperacionTasa("COP/USD");
                    monedaIn = "COP";
                    monedaOut = "USD";
                    tasa.tasaConsulta();
                    break;
                case 3:
                    tasa.setOperacionTasa("USD/ARS");
                    monedaIn ="USD";
                    monedaOut = "ARS";
                    tasa.tasaConsulta();
                    break;
                case 4:
                    tasa.setOperacionTasa("ARS/USD");
                    monedaIn = "ARS";
                    monedaOut = "USD";
                    tasa.tasaConsulta();
                    break;
                case 5:
                    tasa.setOperacionTasa("USD/CLP");
                    monedaIn="USD";
                    monedaOut="CLP";
                    tasa.tasaConsulta();
                    break;
                case 6:
                    tasa.setOperacionTasa("CLP/USD");
                    monedaIn="CLP";
                    monedaOut="USD";
                    tasa.tasaConsulta();
                    break;
                default:
                    System.out.println("opcion incorrecta");
                    tasa.tasaConsulta();

                    break;
            }
            //System.out.println("Fin de programa con operacion: "+ tasa.getOperacionTasa());
            String json =tasa.getJson();
            //System.out.println(json);
            Tasa mitasa = gson.fromJson(json,Tasa.class);
            System.out.println("\nLa tasa de cambio es: " + mitasa.getValorTasa() +" "+ monedaOut);
            System.out.println("\ningrese el monto es "+monedaIn);
            montoIn = teclado.nextDouble();
            montoOut = montoIn * mitasa.getValorTasa();
            System.out.println("la conversion es: " + montoOut + " "+ monedaOut);
            System.out.println("""
                    Realizara otra operacion
                    
                    1- Si.
                    2- No
                    """);
            int opcion2 = teclado.nextInt();

            if (opcion2 == 2){
                System.out.println("Programa Finalizado, hasta luego.");
                break;
            }




        }

    }
}
