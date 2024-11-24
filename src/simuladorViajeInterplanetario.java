
import java.util.ArrayList;
import java.util.List;
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
            System.out.println("|3. Gestiona e inicia tu viaje        |");
            System.out.println("|4. Salir                             |");
            System.out.println("|_____________________________________|");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
    
            switch (opcion) {
                case 1:
                    verDestinos();    
                    break;
    
                case 2:
                    verNaves();
                    break;
    
                case 3:
    
                    break;
    
                case 4:
                    System.out.println("Fue un gusto atenderte, te espeamos pronto!!!");
                    break;
    
                default:
                    System.out.println("Elegiste una opción no válida. Por favor elige una opción del 1 al 4");
    
            }
            if(opcion <= 2){
                pressEnter(scanner);
                
            }
            
        } while(opcion !=4);
    }

    private static void pressEnter(Scanner scanner){
        System.out.println("Presione ENTER para volver al Menú principal");
        scanner.nextLine();
        //Se crea esta opcion para que el usuario vea los planetas y las naves disponibles antes de elegir la opcion
        //que mas le guste y pueda regresar al menú presionando <ENTER>
    }
    private static void verDestinos(){

        List<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta("MERCURIO", 92));
        planetas.add(new Planeta("VENUS", 61));
        planetas.add(new Planeta("MARTE", 55));
        planetas.add(new Planeta("JUPITER", 587));
        planetas.add(new Planeta("SATURNO", 1345));
        planetas.add(new Planeta("URANO", 2721));
        planetas.add(new Planeta("NEPTUNO", 4496));

        System.out.println("\n*****DESTINOS DISPONIBLES*****");
        for (Planeta planeta : planetas){
            System.out.println(planeta);
        }

    }
    private static void verNaves(){

        List<Naves> naves = new ArrayList<>();
        naves.add(new Naves("PARKER", 692000));
        naves.add(new Naves("VOYAGER", 61500));
        naves.add(new Naves("HELIOS", 252792));
        naves.add(new Naves("CASSINI", 158272));
        naves.add(new Naves("PIONEER", 54000));

        System.out.println("\n*****NAVES DISPONIBLES*****");
        for (Naves nave : naves){
        System.out.println(nave);
        }    
        
    } 

    
}
class Planeta {
    private String nombre;
    private int distancia;

    public Planeta(String nombre, int distancia){
        this.nombre = nombre;
        this.distancia = distancia;
    }
    @Override
    public String toString() {
        return "Planeta: " + nombre + ", Se encuentra a " + distancia + " Millones de kilómetros de la Tierra";
    }
}
 class Naves {
    private String nombre;
    private int velocidad;

    public Naves(String nombre, int velocidad){
        this.nombre = nombre;
        this.velocidad = velocidad;
    }
    @Override
    public String toString(){
        return "Nave: " + nombre + ". Velocidad Máxima: " + velocidad + " KM/H";
    }
 
}   
       

