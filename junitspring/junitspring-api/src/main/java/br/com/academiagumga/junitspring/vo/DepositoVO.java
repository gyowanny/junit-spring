package br.com.academiagumga.junitspring.vo;

import java.io.Serializable;

public class DepositoVO implements Serializable{

    private String numeroConta;

    private Double valor;

    public DepositoVO() {
    }

    public DepositoVO(String numeroConta, Double valor) {
        this.numeroConta = numeroConta;
        this.valor = valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
