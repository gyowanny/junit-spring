package br.com.academiagumga.junitspring.application.service;
import gumga.framework.application.GumgaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academiagumga.junitspring.application.repository.TransacaoRepository;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.domain.model.Transacao;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransacaoService extends GumgaService<Transacao, Long> {
	
	private TransacaoRepository repository;
	
	@Autowired
	public TransacaoService(TransacaoRepository repository) {
		super(repository);
		this.repository = repository;
	}
        
        @Transactional(readOnly = true)
        public List<Transacao> getExtrato(ContaCorrente conta) {
            return repository.findByTransacaoConta(conta);
        }

}

