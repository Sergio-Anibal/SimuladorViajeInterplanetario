import java.util.Scanner;

public class simuladorViajeInterplanetario {
    public static void main(String[] args) throws Exception {

        var scanner = new Scanner(System.in);

        Menu(scanner);
        
        scanner.close();

    }

    private static void Menu(Scanner scanner) {

    int opcion;
        do{ 
            System.out.println("|*************************************|");
            System.out.println("|--------- BIENVENIDO VIAJERO---------|");
            System.out.println("|*************************************|");
            System.out.println("|/////////////////////////////////////|");
            System.out.println("|-----------ELIGE UNA OPCIÓN----------|");
            System.out.println("|1. Ver nuestros destinos disponibles |");
            System.out.println("|2. Ver nuestras naves disponibles    |");
            System.out.println("|3. Programa tu viaje                 |");
            System.out.println("|4. Salir                             |");
            System.out.println("|_____________________________________|");
            System.out.print("Elige una opción");
            opcion = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcion) {
                case 1:
    
                    break;
    
                case 2:
    
                    break;
    
                case 3:
    
                    break;
    
                case 4:
    
                    break;
    
                default:
                    System.out.println("Elegiste una opción no válida. Por favor elige una opción del 1 al 4");
    
            }
            if(opcion <= 2){
                pressEnter(scanner);
                
            }
            
        } while(opcion !=0);
    }

    private static void pressEnter(Scanner scanner){
        System.out.println("Presione ENTER para volver al Menú principal");
        scanner.nextLine();
        //Se crea esta opcion para que el usuario vea los planetas y las naves disponibles antes de elegir la opcion
        //que mas le guste
    }
        
}
