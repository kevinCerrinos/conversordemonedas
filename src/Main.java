import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RequestApi requestApi = new RequestApi();
        Scanner teclado = new Scanner(System.in);

        int opciones;
        double currancy;
        double nextcurrancy;

        Moneda moneda;

        String menu = """
                ###################################################################
                Bienvenido al conversor de monedas, elija una opcion de conversion
                1.- Dolar --> Euro
                2.- Euro ---> Dolar
                3.- Dolar ---> Sol Peruano
                4.- Sol Peruano ---> Dolar
                5.- Dolar ---> Real Brasileño
                6.- Real Brasileño ---> Dolar
                7.- Conversion personalizada
                8.- Salir
                ####################################################################
                """;


        while(true){
            System.out.println(menu);
            opciones = teclado.nextInt();

            switch (opciones){
                case 1:
                    moneda = requestApi.requestData("USD");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("EUR");
                    System.out.printf("""
                            ******************************************************

                            El monto de %.2f [USD] convertido es de : %.2f [EUR]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 2:

                    moneda = requestApi.requestData("EUR");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("USD");
                    System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [EUR] convertido es de : %.2f [USD]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 3:

                    moneda = requestApi.requestData("USD");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("PEN");
                    System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [USD] convertido es de : %.2f [PEN]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 4:

                    moneda = requestApi.requestData("PEN");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("USD");
                    System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [PEN] convertido es de : %.2f [USD]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 5:

                    moneda = requestApi.requestData("USD");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("BRL");
                    System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [USD] convertido es de : %.2f [BRL]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 6:

                    moneda = requestApi.requestData("BRL");

                    System.out.println("Ingrese la cantidad a convertir");
                    currancy = teclado.nextDouble();

                    nextcurrancy = currancy * moneda.conversion_rates().get("USD");
                    System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [BRL] convertido es de : %.2f [USD]"
                            
                            ******************************************************
                            %n""", currancy, nextcurrancy);

                    break;

                case 7:

                    try{
                        System.out.println("ingresa el codigo de la currancy de origen");
                        String codcurrancy = teclado.next();

                        moneda = requestApi.requestData(codcurrancy);

                        System.out.println("ingresa el codigo de la currancy de destino");
                        String nextcodcurrancy = teclado.next();

                        System.out.println("Ingrese la cantidad a convertir");
                        currancy = teclado.nextDouble();

                        nextcurrancy = currancy * moneda.conversion_rates().get(nextcodcurrancy);
                        System.out.printf("""
                            ******************************************************
    
                            El monto de %.2f [%s] convertido es de : %.2f [%s]"
                            
                            ******************************************************
                            %n""", currancy, codcurrancy, nextcurrancy, nextcodcurrancy);
                    }catch (NullPointerException e){
                        System.out.println("""
                        ******************************************************
                        
                        ERROR AL CONVERTIR LAS DIVISAS:
                        
                        Uno de los codigos de la currancy no es correcta
                        Intentelo nuevamente usando codigos de currancy validos
                        
                        ******************************************************
                        """);
                    }

                    break;

                default:
                    System.out.println("No se reconoce la opcion ingresada, favor de ingresar una opcion valida");
                    break;
                case 8:
                    System.out.println("""
                           ####################################################################
                                                  _          \s
                                                 (_)         \s
                              __ _ _ __ __ _  ___ _  __ _ ___\s
                             / _` | '__/ _` |/ __| |/ _` / __|
                            | (_| | | | (_| | (__| | (_| \\__ \\
                             \\__, |_|  \\__,_|\\___|_|\\__,_|___/
                              __/ |                          \s
                             |___/  \s
                            """);
                    System.out.println("Gracias por usar este programa!");
                    System.out.println("####################################################################");
                    System.exit(0);
                    break;
            }
        }

    }
}
