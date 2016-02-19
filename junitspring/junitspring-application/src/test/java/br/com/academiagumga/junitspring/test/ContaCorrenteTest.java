/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.test;

import br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.domain.domains.GumgaBoolean;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gyowannyqueiroz
 */
public class ContaCorrenteTest extends AbstractTestCase{
    
    @Autowired
    private ContaCorrenteService service;

    @Override
    protected void before() {
        assertNotNull(service);
    }

    @Override
    protected void after() {
    }
    
    @Test
    public void testCriarContaCorrente() {
        ContaCorrente cc = new ContaCorrente();
        cc.setTitular("Claudiomar dos SAntos");
        cc.setNumero("3123123-2");
        cc.setLimite(1000);
        cc.setEncerrada(new GumgaBoolean(false));
        ContaCorrente saved = service.save(cc);
        
        assertNotNull(saved.getId());
        assertEquals(saved.getTitular(), cc.getTitular());
    }
}
