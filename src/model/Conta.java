package model;

import exceptions.IdadeInvalidaException;
import interfaces.IConta;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta {

    private int numero;

    private String agencia;

    private double saldo;

    private Cliente titular;

    public Conta(int numero, String agencia, double saldo, Cliente titular) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (saldo > valor){
            this.saldo -= valor;
        }
    }

    @Override
    public void transferir(double valor, Conta destino) {
        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public void verificarMaiorIdade(LocalDate dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(dataAtual, dataNascimento).getYears();
        if (idade < 18){
            throw new IdadeInvalidaException("Você precisa ser maior de idade para criar uma conta");
        }
    }
}

