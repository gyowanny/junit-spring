package br.com.academiagumga.junitspring.api;

import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.vo.DepositoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agencia")
public class GerenciadorFinanceiroAgenciaAPI {

    @Autowired
    private GerenciadorFinanceiroAgenciaService agenciaService;

    @RequestMapping(value = "/depositar", method = RequestMethod.POST)
    public ResponseEntity<String> depositar(@RequestBody DepositoVO vo) {
        ResponseEntity<String> response;
        try {
            ContaCorrente cc = 
                    agenciaService.findContaCorrenteByNumero(vo.getNumeroConta());
            agenciaService.depositar(cc, vo.getValor());
            response = new ResponseEntity<>("Deposito efetuado com sucesso!", 
                    HttpStatus.OK);
        } catch (Exception ex) {
            response = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    
}
