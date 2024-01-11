import java.util.Scanner;

public class PEP2T_1_JMMM {
    // Atributos de la clase
    float saldoInicio;
    float topeRetirar;

    // Constructor privado para inicializar saldo y tope de retiro
    private PEP2T_1_JMMM(float saldazo, float topazo) {
        saldoInicio = saldazo;
        topeRetirar = topazo;
    }

    // Método privado para verificar el tope de retiro
    private void VerificacionTope(float retirado) {
        if (retirado > topeRetirar) {
            System.out.println("Intenta retirar " + retirado + " €");
            System.out.println("Tiene establecido ahora un tope de " + String.format("%.0f", topeRetirar) + "€");
            System.out.println("Su saldo actual es de " + saldoInicio + " €");
        } else if (retirado <= topeRetirar) {
            System.out.println("Usted retiró " + retirado + " €");
            topeRetirar -= retirado;
            System.out.println("Su saldo actual es de " + saldoInicio + " €");
        }
    }

    // Método privado para verificar el saldo antes de retirar
    private void VerificacionSaldo(float retirado) {
        if (retirado <= topeRetirar) {
            saldoInicio -= retirado;
        }
    }

    // Método privado para realizar la operación de retiro
    private void Retirar() {
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
        System.out.println("Teclee dinero a retirar: ");
        Scanner leer = new Scanner(System.in);
        float retirado = leer.nextFloat();
        VerificacionSaldo(retirado);
        VerificacionTope(retirado);
    }

    // Método privado para realizar la operación de ingreso
    private void Ingresar() {
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
        System.out.println("Teclee dinero a ingresar: ");
        Scanner leer = new Scanner(System.in);
        float ingresado = leer.nextFloat();
        System.out.println("Usted ingresó " + ingresado + " €");
        saldoInicio += ingresado;
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
    }

    // Método principal
    public static void main(String[] args) {
        boolean menu = true;
        // Crear objeto de la clase con valores iniciales proporcionados por los argumentos
        PEP2T_1_JMMM objeto = new PEP2T_1_JMMM(Float.parseFloat(args[0]), Float.parseFloat(args[1]));
        System.out.println("\033[1m\u001B[4mPROGRAMA CAJERO AUTOMÁTICO\033[0m");
        // Bucle para mostrar el menú y realizar operaciones hasta que el usuario elija salir
        while (menu) {
            System.out.println("\033[1m\t Menú de Opciones\033[0m");
            System.out.println("\033[1m\t ================\033[0m");
            System.out.println("1) Retirada de dinero");
            System.out.println("2) Ingreso de dinero");
            System.out.println("3) Salir");
            System.out.println("Opción: ");
            Scanner teclado = new Scanner(System.in);
            int opcion = teclado.nextInt();
            // Estructura switch para manejar la opción seleccionada
            switch (opcion) {
                case 1:
                    objeto.Retirar();
                    break;
                case 2:
                    objeto.Ingresar();
                    break;
                case 3:
                    menu = false;
                    break;
                default:
                    System.out.println("Esta opción no es válida, elija otra opción.");
                    break;
            }
        }
    }
}