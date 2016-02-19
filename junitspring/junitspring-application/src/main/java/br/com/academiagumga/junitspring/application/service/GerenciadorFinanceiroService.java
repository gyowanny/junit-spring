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
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GerenciadorFinanceiroService {
    
    @Autowired
    protected TransacaoService transacaoService;
    
    protected void registrarTransacao(ContaCorrente conta, Double valor, String descricao)
            throws TransacaoException {
        Transacao t = new Transacao();
        t.setDescricao(descricao);
        t.setValor(valor);
        t.setTransacaoConta(conta);
        transacaoService.save(t);
    }
    
    public abstract void depositar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public abstract void sacar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public abstract void emprestar(ContaCorrente conta, Double valor) throws TransacaoException;
    
    public abstract Double getSaldo(ContaCorrente conta) throws ExtratoException;
    
    public abstract List<Transacao> getExtrato(ContaCorrente conta) throws ExtratoException;
    
    public abstract void encerrarConta(ContaCorrente conta) throws TransacaoException;
    
}
