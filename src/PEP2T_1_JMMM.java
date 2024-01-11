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
}