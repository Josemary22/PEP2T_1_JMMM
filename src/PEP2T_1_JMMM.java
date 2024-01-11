import java.util.Scanner;

public class PEP2T_1_JMMM {
    float saldoInicio;
    float topeRetirar;

    private PEP2T_1_JMMM(float saldazo, float topazo){
        saldoInicio = saldazo;
        topeRetirar = topazo;
    }

    private void VerificacionTope(float retirado){
        if (retirado > topeRetirar){
            System.out.println("Intenta retirar " + retirado + " €");
            System.out.printf("Tiene establecido ahora un tope de " + topeRetirar + "€");
            System.out.println("Su saldo actual es de " + saldoInicio + " €");
        }
        else if (retirado <= topeRetirar){
            System.out.println("Usted retiró " + retirado + " €");
            topeRetirar -= retirado;
            System.out.println("Su saldo actual es de " + saldoInicio + " €");
        }
    }

    private void VerificacionSaldo(float retirado){
        if (retirado <= topeRetirar){
            saldoInicio -= retirado;
        }
    }

    private void Retirar(){
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
        System.out.println("Teclee dinero a retirar: ");
        Scanner leer = new Scanner(System.in);
        Float retirado = leer.nextFloat();
        VerificacionSaldo(retirado);
        VerificacionTope(retirado);
    }

    private void Ingresar(){
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
        System.out.println("Teclee dinero a ingresar: ");
        Scanner leer = new Scanner(System.in);
        Float ingresado = leer.nextFloat();
        System.out.println("Usted ingreso " + ingresado + " €");
        saldoInicio += ingresado;
        System.out.println("Su saldo actual es de " + saldoInicio + " €");
    }

    public static void main(String[] args){
        boolean menu = true;
        PEP2T_1_JMMM objeto = new PEP2T_1_JMMM(Float.parseFloat(args[0]), Float.parseFloat(args[1]));
        System.out.println("PROGRAMA CAJERO AUTOMÁTICO");
        while(menu){
            System.out.println("\t Menú de Opciones");
            System.out.println("\t ================");
            System.out.println("1) Retirada de dinero");
            System.out.println("2) Ingreso de dinero");
            System.out.println("3) Salir");
            System.out.println("Opción: ");
            Scanner teclado = new Scanner(System.in);
            int opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    objeto.Retirar();
                    break;
                case 2:
                    objeto.Ingresar();
                    break;
                case 3:
                    menu = false;
                    break;
            }
        }
    }
}