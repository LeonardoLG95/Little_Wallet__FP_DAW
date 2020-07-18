import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Usuario usuario = new Usuario();

        System.out.println("Introduce el nombre de usuario");
        boolean repetir = false;

        // En todas las opciones uso un do while con una booleana
        // para volver a preguntar al usuario en caso de equivocarse al introducir datos.
        do {
            String respuesta = "";
            if(repetir){System.out.println("Nombre introducido incorrecto");}
            respuesta = entrada.nextLine();
            usuario.setNombre(respuesta);
            // En esta he aprovechado la idea de la comprobación
            // en el set de DNI y la he aplicado tambien al nombre.
            repetir = usuario.setNombre(respuesta);
        }while(repetir);


        System.out.println("Introduce la edad del usuario");
        repetir = false;
        do{
            int respuesta = 0;
            if(repetir) System.out.println("Edad introducida incorrecta");
            // He añadido comprobaciones try-catch como esta en todos los apartados que pedian un número
            // para evitar que el programa diese error y se saliese. Intente aplicar la idea de la comprobación en el set,
            // pero daba error y navegando me encontre con varios consejos con los que pude formular este try-catch.
            // Página de referencia https://stackoverflow.com/questions/19287265/try-catch-statement-with-a-nextline-input
            try{
                respuesta = entrada.nextInt();
                usuario.setEdad(respuesta);
                repetir = usuario.setEdad(respuesta);
                entrada.nextLine();
            }catch (Exception e){
                entrada.nextLine();
                repetir = true;
            };
        }while(repetir);

        System.out.println("Introduce el DNI del usuario");
        repetir = false;
        do{
            String respuesta;
            if(repetir) System.out.println("DNI introducido incorrecto");
            respuesta = entrada.nextLine();
            usuario.setDNI(respuesta);
            repetir = usuario.setDNI(respuesta);
        }while(repetir);
        System.out.println("Usuario creado correctamente");

        Cuenta cuenta = new Cuenta(usuario);
        int opcion;
        do{
            opcion = 6; //Inicializo a un número que no este en el rango de opciones.
            System.out.println("Realiza una nueva acción");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");
            do {
                if(repetir) System.out.println("Elige una opción correcta, entre 0 y 5, 0 para salir:");
                try{
                    opcion = entrada.nextInt();
                }catch(Exception e){
                    entrada.nextLine();
                    repetir = true;
                }
                if(opcion < 0 || opcion > 5){
                    repetir = true;
                }else{
                    repetir = false;
                }
            }while(repetir);

            switch (opcion){
                case 0:
                    break;
                case 1:
                    String descripcionG = "";
                    System.out.println("Introduce la descripción de tu gasto");
                    entrada.nextLine();
                    descripcionG = entrada.nextLine();
                    System.out.println("Introduce la cantidad de tu gasto");
                    boolean repetirG = false;
                    do {
                        if(repetirG) System.out.println("Cantidad de gasto incorrecta");
                        double gasto = 0;
                        try{
                            gasto = entrada.nextDouble();
                            if(gasto == 0) break;
                            cuenta.addGastos(descripcionG, gasto);
                            repetirG = false;
                        } catch (GastoException e) {
                            entrada.nextLine();
                            repetirG = true;
                        }
                    }while(repetirG);
                    System.out.println("Saldo restante: " + cuenta.getSaldo());
                    break;

                case 2:
                    String descripcionI = "";
                    System.out.println("Introduce la descripción de tu ingreso");
                    entrada.nextLine();
                    descripcionI = entrada.nextLine();
                    System.out.println("Introduce la cantidad de tu ingreso");
                    boolean repetirI = false;
                    do {
                        if(repetirI) System.out.println("Cantidad de ingreso incorrecta");
                        double ingreso = 0;
                        try {
                            ingreso = entrada.nextDouble();
                            if(ingreso == 0) break;
                            cuenta.addIngresos(descripcionI, ingreso);
                            repetirI = false;
                        } catch (Exception e) {
                            entrada.nextLine();
                            repetirI = true;
                        }
                    }while(repetirI);
                    break;

                case 3:
                    List<Gasto> listaGastos = cuenta.getGastos();
                    for (Gasto g : listaGastos) {
                        System.out.println(g);
                    }
                    break;

                case 4:
                    List<Ingreso> listaIngresos = cuenta.getIngresos();
                    for (Ingreso i : listaIngresos) {
                        System.out.println(i);
                    }
                    break;

                case 5:
                    System.out.println("El saldo actual de tu cuenta es: " + cuenta.getSaldo() + "€");
                    break;
            }
        }while(opcion != 0);

        System.out.println("Fin del programa.");
        System.out.println("Gracias por utilizar la aplicación.");
    }
}
