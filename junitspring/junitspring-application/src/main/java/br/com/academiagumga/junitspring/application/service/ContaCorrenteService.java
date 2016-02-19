package br.com.academiagumga.junitspring.application.service;
import gumga.framework.application.GumgaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;

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

}

