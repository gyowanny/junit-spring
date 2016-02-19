/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.test.gerenciador.agencia;

import br.com.academiagumga.junitspring.application.exception.TransacaoException;
import br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.test.AbstractTestCase;
import gumga.framework.domain.domains.GumgaBoolean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author gyowannyqueiroz
 */
public class GerenciadorAgenciaServiceTest extends AbstractTestCase{

    @Autowired
    private GerenciadorFinanceiroAgenciaService service;
    
    @Autowired
    private ContaCorrenteService contaService;
    
    private ContaCorrente cc;
    
    @Override
    protected void before() {
        cc = criarContaCorrente();
        assertNotNull(cc);
    }

    @Override
    protected void after() {
    }
    
    @Test
    public void testDepositarComSucesso() throws Exception{
        try {
            service.depositar(cc, new Double(100));
            service.getExtrato(cc)
                .stream()
                .forEach(t -> System.out.println(t.getData()+" "+t.getDescricao()+" "+t.getValor()));
        } catch (TransacaoException ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    public ContaCorrente criarContaCorrente() {
        ContaCorrente cc = new ContaCorrente();
        cc.setTitular("Claudiomar dos SAntos");
        cc.setNumero("3123123-2");
        cc.setLimite(1000);
        cc.setEncerrada(new GumgaBoolean(false));
        return contaService.save(cc);
    }    
}
