package br.com.academiagumga.junitspring.api;

import  br.com.academiagumga.junitspring.application.service.ContaCorrenteService;
import br.com.academiagumga.junitspring.domain.model.ContaCorrente;
import gumga.framework.application.GumgaService;
import gumga.framework.presentation.GumgaAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import gumga.framework.presentation.RestResponse;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import gumga.framework.application.GumgaTempFileService;
import gumga.framework.domain.domains.GumgaImage;
import gumga.framework.presentation.GumgaAPI;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/contacorrente")
public class ContaCorrenteAPI extends GumgaAPI<ContaCorrente, Long> {

    @Autowired
    public ContaCorrenteAPI(GumgaService<ContaCorrente, Long> service) {
        super(service);
    }


}

