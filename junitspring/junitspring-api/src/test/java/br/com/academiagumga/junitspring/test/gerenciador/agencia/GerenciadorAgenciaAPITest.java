package br.com.academiagumga.junitspring.test.gerenciador.agencia;

import br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import br.com.academiagumga.junitspring.domain.model.Transacao;
import br.com.academiagumga.junitspring.test.AbstractWebTestCase;
import br.com.academiagumga.junitspring.vo.DepositoVO;
import gumga.framework.domain.domains.GumgaBoolean;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GerenciadorAgenciaAPITest extends AbstractWebTestCase{

    @Autowired
    private GerenciadorFinanceiroAgenciaService agenciaService;
    
    @Autowired
    private ContaCorrenteService contaCorrenteService;
    
    private ContaCorrente conta;
    
    @Override
    protected void before() {
        buildMockMvc();
        assertNotNull(mockMvc);
        assertNotNull(agenciaService);
        criarContaCorrente();
    }

    @Override
    protected void after() {
    }

    @Test
    public void testDepositarComSucesso() throws Exception{
        DepositoVO vo = new DepositoVO(conta.getNumero(), new Double(100.0));
        String json = toJSONString(vo);
        mockMvc.perform(post("/api/agencia/depositar")
            .content(json)
            .contentType(MediaType.parseMediaType("application/json;charset=UTF-8")))
            .andExpect(status().isOk());
        
        List<Transacao> extrato = agenciaService.getExtrato(conta);
        assertFalse("Nenhuma transacao gerada!", extrato.isEmpty());
        extrato.stream()
           .forEach(
           t -> System.out.println(t.getData()+" "+t.getDescricao()+" "+t.getValor()));
    }
    
    private void criarContaCorrente() {
        conta = new ContaCorrente();
        conta.setTitular("Claudiomar dos SAntos");
        conta.setNumero("3123123-2");
        conta.setLimite(1000);
        conta.setEncerrada(new GumgaBoolean(false));
        ContaCorrente saved = contaCorrenteService.save(conta);
        
        assertNotNull(saved.getId());
        assertEquals(saved.getTitular(), conta.getTitular());
    }
}
