/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.seed;

import br.com.academiagumga.junitspring.application.exception.TransacaoException;
import br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.domain.seed.AppSeed;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContaSeed implements AppSeed {

    @Autowired
    private ContaCorrenteService contaService;
    
    @Autowired
    private GerenciadorFinanceiroAgenciaService gerenciadorService;
    
    @Override
    public void loadSeed() throws IOException {
        try {
            ContaCorrente cc = new ContaCorrente();
            cc.setTitular("Sexta-feira todo mundo cansado");
            cc.setNumero("171");
            cc.setLimite(1000);
            
            cc = contaService.save(cc);
            
            gerenciadorService.depositar(cc, 300.0);
            gerenciadorService.sacar(cc, 100.0);
            gerenciadorService.depositar(cc, 1000.0);
        } catch (TransacaoException ex) {
            throw new IOException(ex);
        }
    }
    
}
