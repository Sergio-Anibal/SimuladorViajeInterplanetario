import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class simuladorViajeInterplanetario{

    private static List<Planeta> planetas = new ArrayList<>();
    private static List<Naves> naves = new ArrayList<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        cargarListas();//Metodo crado para cargar las listas de planetas y naves
        var scanner = new Scanner(System.in);
        mostrarMenu(scanner);
        scanner.close();
    }  
    private static void cargarListas() {
        //Lista de plantas que se van a mostrar en las opciones 1 y 3
        planetas.add(new Planeta("MERCURIO", "Es el planeta más pequeño y cercano al Sol", 92));
        planetas.add(new Planeta("VENUS", "El segundo planeta del sistema solar y el más caluroso", 61));
        planetas.add(new Planeta("MARTE", "Conocido como el planeta rojo y el más cercano a nuestra Tierra", 55));
        planetas.add(new Planeta("JÚPITER", "El gigante gaseoso es el planeta más grande de nuestro sistema solar", 587));
        planetas.add(new Planeta("SATURNO", "Famoso por sus colores y sus anillos", 1345));
        planetas.add(new Planeta("URANO", "El gigante de hielo con una rotación de 90°", 2721));
        planetas.add(new Planeta("NEPTUNO", "El planeta más lejano del Sol con una atmósfera rica en metano", 4496));

        //Lista de naves que se van a mostrar en las opciones 2 y 3
        naves.add(new Naves("PARKER", 6920000, 1000000, 1000));
        naves.add(new Naves("VOYAGER", 6150000, 900000, 900));
        naves.add(new Naves("HELIOS", 2527920, 800000, 800));
        naves.add(new Naves("CASSINI", 1582720, 700000, 700));
        naves.add(new Naves("PIONEER", 540000, 600000, 600));
    }

    private static void mostrarMenu(Scanner scanner) {
        int opcion;
        do {//Menu de opciones que vera el usuario
            System.out.println("\n|*************************************|");
            System.out.println("|--------- BIENVENIDO VIAJERO --------|");
            System.out.println("|*************************************|");
            System.out.println("|----------- ELIGE UNA OPCIÓN --------|");
            System.out.println("| 1. Ver destinos disponibles         |");
            System.out.println("| 2. Ver naves disponibles            |");
            System.out.println("| 3. Gestionar e iniciar tu viaje     |");
            System.out.println("| 4. Salir                            |");
            System.out.println("|_____________________________________|");
            System.out.print("Elige una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingresa un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> verDestinos();
                case 2 -> verNaves();
                case 3 -> gestionarViaje(scanner);
                case 4 -> System.out.println("¡Gracias por tu visita, ¡¡¡ TE ESPERAMOS PRONTO !!!");
                default -> System.out.println("Opción no válida. Por favor elige una opción del 1 al 4.");
            }

            if (opcion <= 2) {
                presionarEnterParaContinuar(scanner);
            }
        } while (opcion != 4);
    }

    private static void presionarEnterParaContinuar(Scanner scanner) {
        System.out.println("------Presiona ENTER para volver al menú principal.------");
        scanner.nextLine();
    }

    private static void verDestinos() {
        System.out.println("\n***** DESTINOS DISPONIBLES *****");
        for (Planeta planeta : planetas) {
            System.out.println(planeta);
        }
    }

    private static void verNaves() {
        System.out.println("\n***** NAVES DISPONIBLES *****");
        for (Naves nave : naves) {
            System.out.println(nave);
        }
    }

    private static void gestionarViaje(Scanner scanner) {
        System.out.println("\n****** GESTIONA TU VIAJE ******");
        //Aqui selecciona el planeta al que se desea ir
        Planeta destino = seleccionarDestino(scanner);
        
        //Aqui se selecciona la nave
        Naves nave = seleccionarNave(scanner);
        scanner.nextLine();//Limpia el buffer, por que quedaba el ENTER y siempre cancelaba el viaje en la opcion de confirmacion Y/N
        
        //Confirmacion del usuario para iniciar viaje
        System.out.println("\nHas elegido");
        System.out.println("El " + destino);
        System.out.println("La " + nave);
        System.out.println("Para confirmar inicio de viaje presiona (Y), para cancelar oprime cualquier tecla");
        String Confirmacion = scanner.nextLine().trim().toUpperCase(); //Metodo usado para eliminar espacios y convertir minuscula a Mayuscula

        if(Confirmacion.equals("Y")){
        iniciarViaje(destino, nave);
        } else{
            System.out.println("Viaje cancelado");
        }

    }

    private static Planeta seleccionarDestino(Scanner scanner) {
        System.out.println("\n****** SELECCIONA TU DESTINO ******");
        for (int i = 0; i < planetas.size(); i++) {
            System.out.println((i + 1) + ". " + planetas.get(i));
        }
        int indice = -1;
        while(indice < 0 || indice >= planetas.size()){
            System.out.print("Elige el planeta al cual desear ir: " );
            while (!scanner.hasNextInt()) {//Esta opcion sirve para que para que el usuario no ingrese otro valor que no sea númerico
                System.out.println("Por favor ingresa una opción valida!!!");
                scanner.next();
                
                }
            indice = scanner.nextInt() - 1;

            if (indice < 0 || indice >= planetas.size()) {
                System.out.println("Opción inválida.");
            }

                  
        }
        return planetas.get(indice);
    }

    private static Naves seleccionarNave(Scanner scanner) {
        System.out.println("\n****** SELECCIONA TU NAVE ******");
        for (int i = 0; i < naves.size(); i++) {
            System.out.println((i + 1) + ". " + naves.get(i));
        }
        int indice = -1;
        while (indice < 0 || indice >= naves.size()) {
            System.out.print("Elige una nave: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingresa una opción valida!!!");
                scanner.next();
                
            }
            indice = scanner.nextInt() - 1;

            if (indice < 0 || indice >= naves.size()) {
                System.out.println("Opción inválida.");
            }

        }
        return naves.get(indice);
    }
    //Metodo que simula el viaje
    private static void iniciarViaje(Planeta destino, Naves nave) {
        double distancia = destino.getDistancia() * 1_000_000.0;//Se multiplica por un millon por que los valores se tomaron sin incluir los millones de kilometros
        double tiempoTotalHoras = distancia / nave.getVelocidad();
        int oxigeno = nave.getOxigeno();
        int combustible = nave.getCombustible();
        double distanciaRecorrida = 0;

        System.out.println("\n****** INICIO DE VIAJE ******");
        System.out.printf("Destino: %s | Distancia: %.0f km | Tiempo estimado: %.2f días%n",
                destino.getNombre(), distancia, tiempoTotalHoras / 24);

        Scanner scanner = new Scanner(System.in);

        while (distanciaRecorrida < distancia) {
            distanciaRecorrida += nave.getVelocidad();
            oxigeno -= 1;
            combustible -= 100;

            //Lista de eventos aleatorios(Lluvia de asteorides)
            if (random.nextInt(100) < 1) {
                System.out.println("\n****** ¡ALERTA! ******");
                System.out.println("¡Lluvia de asteroides detectada!");
                System.out.println("Elige una opción:");
                System.out.println("1. Continuar rumbo y acelerar(Aumenta consumo de recursos)");
                System.out.println("2. Tomar un desvío (Es mas seguro pero aumenta el tiempo de llegada)");

                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    combustible -= 300;
                    oxigeno -= 3; 
                    System.out.println("Elegiste continuar. ¡¡TEN MUCHO CUIDADO!!");
                }else{
                    distanciaRecorrida -= nave.getVelocidad() * 0.10; //Retraso del 10%
                    System.out.println("Decidiste tomar un desvío, aunque se retrasa un poco el tiempo es más seguro");
                }
                
            }//Lista de eventos aleatorios (tormenta solar)
            if (random.nextInt(100) < 2) {
                System.out.println("\n****** ¡ALERTA! ******");
                System.out.println("¡Tormenta Solar detectada!");
                System.out.println("Elige una opción:");
                System.out.println("1. Continuar rumbo y acelerar(Aumenta consumo de recursos)");
                System.out.println("2. Tomar un desvío (Es mas seguro pero aumenta el tiempo de llegada)");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    combustible -= 200;
                    oxigeno -= 2; 
                    System.out.println("Elegiste continuar. ¡¡TEN MUCHO CUIDADO!!");
                }else{
                    distanciaRecorrida -= nave.getVelocidad() * 0.05; //Retraso del 5%
                    System.out.println("Decidiste tomar un desvío, aunque se retrasa un poco el tiempo es más seguro");
                }
            }if (random.nextInt(100) < 2) {
                System.out.println("\n****** ¡ALERTA! ******");
                System.out.println("¡Sistema de navegacion averiado!");
                System.out.println("Elige una opción:");
                System.out.println("1. Reparar el sistema (Aumenta consumo de recursos)");
                System.out.println("2. Continuar sin reparar (Riesgo de fallo futuro)");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    oxigeno -= 2; 
                    distanciaRecorrida -= nave.getVelocidad() * 0.05; //Retraso del 5%
                    System.out.println("Falla corregida, puedes continuar sin fallas");
                }else{
                    
                    System.out.println("Decidiste continuar. ¡Riesgo de no terminar el viaje");
                }
            }

            // Formula que calcula el progreso
            double progreso = (distanciaRecorrida / distancia) * 100;
            //Mensaje enviado al usuario del pregreso y estado de recursos
            System.out.printf("Progreso: %d%% | Oxígeno: %d | Combustible: %d%n", Math.round(progreso), oxigeno, combustible);//Se utiliza Math.round para aproximar los decimales

            if (combustible <= 0 || oxigeno <= 0) {
                System.out.println("\n****** ¡ALERTA! ******");
                System.out.println("¡Recursos insuficientes! El viaje no puede continuar.");
                System.out.println("Elige una opción:");
                System.out.println("1. Recargar recursos (Añadir +1000 combustible + 10 oxígeno)");
                System.out.println("2. Finalizar viaje");
                int opcion = scanner.nextInt();

                if (opcion == 1) {
                    combustible += 1000;
                    oxigeno += 10;
                    System.out.println("Excelente!! Haz recargado recursos. Continua el viaje");
                } else{
                    System.out.println("Es una lástima no llegar al destino. Hasta pronto!!!");
                    return;
                }
                
            }
        }

        System.out.println("\n***** ¡HAS LLEGADO A TU DESTINO! *****");
        return;
    }
}
class Planeta {
    private String nombre;
    private String descripcion;
    private int distancia;

    public Planeta(String nombre, String descripcion, int distancia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescipcion(){
        return descripcion;
    }
    public int getDistancia() {
        return distancia;
    }
    @Override
    public String toString() {
        return "Planeta: " + nombre + ". " + descripcion + " y se encuentra a " + distancia + " millones de kilómetros de la Tierra.";
    }
}

class Naves {
    private String nombre;
    private int velocidad;
    private int combustible;
    private int oxigeno;

    public Naves(String nombre, int velocidad, int combustible, int oxigeno) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.combustible = combustible;
        this.oxigeno = oxigeno;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public int getCombustible() {
        return combustible;
    }
    public int getOxigeno() {
        return oxigeno;
    }
    @Override
    public String toString() {
        return "Nave: " + nombre + ". Velocidad: " + velocidad + " KM/H, Capacidad de combustible: " + combustible + " galones, Oxígeno: " + oxigeno + " toneladas";
    }
}