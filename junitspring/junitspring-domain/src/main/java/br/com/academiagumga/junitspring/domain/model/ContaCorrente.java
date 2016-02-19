/*
* Gerado automaticamente por GUMGAGenerator em 18/02/2016 14:29:55
*/


package br.com.academiagumga.junitspring.domain.model;

import gumga.framework.domain.GumgaModel;
import gumga.framework.domain.GumgaMultitenancy;
import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;
import gumga.framework.domain.domains.*;
import org.hibernate.annotations.Columns;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonIgnore;

@GumgaMultitenancy
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_CONTACORRENTE")
@Indexed
@Audited
@Entity
public class ContaCorrente extends GumgaModel<Long> {

    @Version
    private Integer version;
    //@Field //Descomente para ser utilizado na busca multientidades
    private String titular;
    //@Field //Descomente para ser utilizado na busca multientidades
    private String numero;
    //@Field //Descomente para ser utilizado na busca multientidades
    private double limite;
    //@Field //Descomente para ser utilizado na busca multientidades
    private GumgaBoolean encerrada;

    public ContaCorrente(){
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public GumgaBoolean getEncerrada() {
        return encerrada;
    }

    public void setEncerrada(GumgaBoolean encerrada) {
        this.encerrada = encerrada;
    }

}
