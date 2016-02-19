/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.test;

import br.com.academiagumga.junitspring.application.exception.TransacaoException;
import br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.domain.domains.GumgaBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gyowannyqueiroz
 */
public class GerenciadorAgenciaTest extends AbstractTestCase{

    @Autowired
    private GerenciadorFinanceiroAgenciaService service;
    
    @Autowired
    private ContaCorrenteService contaService;
    
    @Override
    protected void before() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void after() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Test
    public void testDepositar(){
        ContaCorrente cc = criarContaCorrente();
        try {
            service.depositar(cc, new Double(100));
        } catch (TransacaoException ex) {
            Assert.fail();
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
