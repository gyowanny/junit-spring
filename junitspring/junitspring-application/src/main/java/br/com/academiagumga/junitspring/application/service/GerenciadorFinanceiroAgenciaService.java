/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.application.service;

import br.com.academiagumga.junitspring.application.exception.ContaCorrenteNaoEncontradaException;
import br.com.academiagumga.junitspring.application.exception.ExtratoException;
import br.com.academiagumga.junitspring.application.exception.TransacaoException;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.domain.model.Transacao;
import com.sun.corba.se.impl.ior.ObjectReferenceFactoryImpl;
import gumga.framework.domain.domains.GumgaBoolean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GerenciadorFinanceiroAgenciaService
        extends AbstractGerenciadorFinanceiroService {

    @Autowired
    private ContaCorrenteService contaService;

    @Transactional
    @Override
    public void depositar(ContaCorrente conta, Double valor) throws TransacaoException {
        System.out.println(">>> Deposito!!!!");
        registrarTransacao(conta, valor, "Depósito agência");
    }

    @Transactional
    @Override
    public void sacar(ContaCorrente conta, Double valor) throws TransacaoException {
        //registrar o valor negativo
        double valorNegativo = valor * -1;
        registrarTransacao(conta, valorNegativo, "Saque agência");
    }

    @Transactional
    @Override
    public void emprestar(ContaCorrente conta, Double valor) throws TransacaoException {
        registrarTransacao(conta, valor, "Empréstimo agência");
    }

    @Transactional(readOnly = true)
    @Override
    public Double getSaldo(ContaCorrente conta) throws ExtratoException {
        double saldo = 0;
        for (Transacao t : transacaoService.getExtrato(conta)) {
            saldo += t.getValor();
        }
        return saldo;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Transacao> getExtrato(ContaCorrente conta) throws ExtratoException {
        return transacaoService.getExtrato(conta);
    }

    @Transactional
    @Override
    public void encerrarConta(ContaCorrente conta) throws TransacaoException {
        conta.setEncerrada(new GumgaBoolean(true));
        contaService.save(conta);
        registrarTransacao(conta, new Double(0), "Conta encerrada.");
    }

    public ContaCorrente findContaCorrenteByNumero(String numero) throws ContaCorrenteNaoEncontradaException {
        return contaService.findByNumero(numero);
    }
}
