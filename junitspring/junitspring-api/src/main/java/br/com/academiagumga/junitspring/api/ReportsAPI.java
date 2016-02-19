/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.academiagumga.junitspring.api;

import br.com.academiagumga.junitspring.application.service.GerenciadorFinanceiroAgenciaService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.application.service.ReportType;
import gumga.framework.presentation.api.AbstractReportAPI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportsAPI extends AbstractReportAPI{

    @Autowired
    private GerenciadorFinanceiroAgenciaService gerenciadorAgenciaService;
    
    public ReportsAPI() {
        super("/WEB-INF/reports");
    }
    
    @RequestMapping(value = "/extrato/{id}/{type}", method = RequestMethod.GET)
    public void extrato(@PathVariable("id") Long contaId, 
            @PathVariable("type") ReportType type, 
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        ContaCorrente cc = gerenciadorAgenciaService.findContaCorrenteById(contaId);
        generateAndExportReport("extrato.jasper", gerenciadorAgenciaService.getExtrato(cc), 
                null, request, response, type);
    }
}