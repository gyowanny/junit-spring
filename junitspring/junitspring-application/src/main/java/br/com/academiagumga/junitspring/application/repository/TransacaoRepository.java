package br.com.academiagumga.junitspring.application.repository;

import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.domain.repository.GumgaCrudRepository;
import br.com.academiagumga.junitspring.domain.model.Transacao;
import java.util.List;

public interface TransacaoRepository extends GumgaCrudRepository<Transacao, Long> {

    public List<Transacao> findByTransacaoConta(ContaCorrente transacaoConta);
    
}

