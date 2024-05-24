package interfaces;

import model.Conta;

import java.time.LocalDate;

public interface IConta {

    public void depositar(double valor);

    public void sacar(double valor);

    public void transferir(double valor, Conta destino);

    public void verificarMaiorIdade(LocalDate dataNascimento);
}
