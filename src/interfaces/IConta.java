package interfaces;

import model.Conta;

public interface IConta {

    public void depositar(double valor);

    public void sacar(double valor);

    public void transferir(double valor, Conta destino);
}
