/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.application.service;

import br.com.academiagumga.junitspring.application.exception.ExtratoException;
import br.com.academiagumga.junitspring.application.exception.TransacaoException;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.domain.model.Transacao;
import java.util.List;

/**
 *
 * @author gyowannyqueiroz
 */
public interface GerenciadorFinanceiroService {
    public void depositar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public void sacar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public void emprestar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public Double getSaldo(ContaCorrente conta) throws ExtratoException;
    
    public List<Transacao> getExtrato(ContaCorrente conta) throws ExtratoException;
    
    public void encerrarConta(ContaCorrente conta) throws TransacaoException;
    
}
