import com.duolingo.utilidades.Diccionario;
import java.util.Scanner;
import java.util.Set;
import java.util.List;
public class Main {
    private static Diccionario diccionario;
    private static Scanner scanner;
    public static void main(String[] args) throws Exception {
        diccionario = new Diccionario();
        scanner = new Scanner(System.in);

        mostrarMensajeBienvenida();

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            System.out.println();

            switch (opcion) {
                case 1:
                    agregarPalabra();
                    break;
                case 2:
                    eliminarPalabra();
                    break;
                case 3:
                    buscarPalabra();
                    break;
                case 4:
                    mostrarInicialesDisponibles();
                    break;
                case 5:
                    mostrarPalabrasPorInicial();
                    break;
                case 6:
                salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido al diccionario de Duolingo");
        System.out.println("--------------------------------------");
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Añadir palabra");
        System.out.println("2. Eliminar palabra");
        System.out.println("3. Existe palabra");
        System.out.println("4. Mostrar iniciales disponibles");
        System.out.println("5. Ver palabras por inicial");
        System.out.println("6. Cerrar programa");
    }


    private static int leerOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    private static void agregarPalabra() {
        System.out.print("Introduce la palabra a añadir: ");
        scanner.nextLine(); 
        String palabra = scanner.nextLine();
        diccionario.agregarPalabra(palabra);
        System.out.println("Palabra añadida correctamente.");
    }

    private static void eliminarPalabra() {
        System.out.print("Introduce la palabra a eliminar: ");
        scanner.nextLine(); 
        String palabra = scanner.nextLine();
        boolean eliminada = diccionario.eliminarPalabra(palabra);
        if (eliminada) {
            System.out.println("Palabra eliminada correctamente del diccionario.");
        } else {
            System.out.println("La palabra no estaba almacenada en el diccionario.");
        }
    }

    private static void buscarPalabra() {
        System.out.print("Introduce la palabra a buscar: ");
        scanner.nextLine(); 
        String palabra = scanner.nextLine();
        boolean existe = diccionario.existePalabra(palabra);
        if (existe) {
            System.out.println("La palabra se ha encontrado en el diccionario.");
        } else {
            System.out.println("La palabra no se ha encontrado en el diccionario.");
        }
    }


    private static void mostrarInicialesDisponibles() {
        Set<Character> iniciales = diccionario.getInicialesDisponibles();
        if (!iniciales.isEmpty()) {
            System.out.println("Iniciales disponibles:");
            for (char inicial : iniciales){
                System.out.println(inicial);
            }
        } else {
            System.out.println("No hay iniciales disponibles en el diccionario.");
        }
    }

    private static void mostrarPalabrasPorInicial() {
        System.out.print("Introduce la inicial: ");
        scanner.nextLine();
        char inicial = scanner.nextLine().charAt(0);
        List<String> palabras = diccionario.getPalabrasPorInicial(inicial);
        if (!palabras.isEmpty()) {
            System.out.println("Palabras que empiezan con la inicial '" + inicial + "':");
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        } else {
            System.out.println("No hay palabras que empiecen con la inicial '" + inicial + "'.");
        }
    }


}
















