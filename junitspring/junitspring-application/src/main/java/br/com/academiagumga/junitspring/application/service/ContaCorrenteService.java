package br.com.academiagumga.junitspring.application.service;

import br.com.academiagumga.junitspring.application.exception.ContaCorrenteNaoEncontradaException;
import gumga.framework.application.GumgaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiagumga.junitspring.application.repository.ContaCorrenteRepository;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;

@Service
public class ContaCorrenteService extends GumgaService<ContaCorrente, Long> {

    private ContaCorrenteRepository repository;

    @Autowired
    public ContaCorrenteService(ContaCorrenteRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public ContaCorrente findByNumero(String numero) throws ContaCorrenteNaoEncontradaException {
        if (numero == null || numero.isEmpty()){
            throw new ContaCorrenteNaoEncontradaException("O numero da conta corrente nao foi informado");
        }
        ContaCorrente cc = repository.findOneByNumero(numero);
        if (cc == null){
            throw new ContaCorrenteNaoEncontradaException("Conta corrente nao existe para o numero "+numero);
        }
        
        return cc;
    }
}
