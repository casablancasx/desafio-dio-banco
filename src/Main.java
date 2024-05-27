import model.Cliente;
import model.Conta;
import model.ContaCorrente;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cliente maria = new Cliente("Maria","22222222-22", LocalDate.of(2004,2,20),"999999999");
        Conta conta = new ContaCorrente(200.00,maria);

        System.out.println(conta.toString());

    }
}
