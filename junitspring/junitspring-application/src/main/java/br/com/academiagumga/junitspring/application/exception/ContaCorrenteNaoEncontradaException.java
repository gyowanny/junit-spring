/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.application.exception;

/**
 *
 * @author gyowannyqueiroz
 */
public class ContaCorrenteNaoEncontradaException extends Exception {

    public ContaCorrenteNaoEncontradaException(String message) {
        super(message);
    }

    public ContaCorrenteNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

}
