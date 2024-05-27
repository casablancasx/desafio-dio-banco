package model;

import exceptions.IdadeInvalidaException;
import interfaces.IConta;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public abstract class Conta implements IConta {

    private String numero;

    private String agencia;

    private double saldo;

    private Cliente titular;

    public Conta() {
    }

    public Conta(double saldo, Cliente titular) {
        verificarMaiorIdade(titular.getDataNascimento());
        gerarConta();
        gerarAgencia();
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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
        int idade = Period.between(dataNascimento, dataAtual).getYears();
        if (idade < 18){
            throw new IdadeInvalidaException("Você precisa ter mais de 18 anos");
        }
    }

    @Override
    public void gerarAgencia() {
        Random rd = new Random();

        int numero = rd.nextInt(100000);

        String numeroFormatado = String.format("%05d", numero);

        String agenciaFormatado = numeroFormatado.substring(0,4) + "-" + numeroFormatado.substring(4);

        this.agencia = agenciaFormatado;

    }

    @Override
    public void gerarConta() {

        Random rd = new Random();

        int numero = rd.nextInt(10000000);

        String numeroFormatado = String.format("%08d", numero);

        this.numero = numeroFormatado;

    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + numero + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}

