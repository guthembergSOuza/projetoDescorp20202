package br.com.projetodescorp.model;

import br.com.projetodescorp.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidadorCompanhiaDiretor implements ConstraintValidator<ValidaCompanhiaDiretor, String> {
    private ArrayList companhias;
    
    @Override
    public void initialize(ValidaCompanhiaDiretor validaDiretorTipo) {
        this.companhias = new ArrayList();
        this.companhias.add("Risadaria");
        this.companhias.add("Melhores do mundo");
        this.companhias.add("Teatro dos Quatro");
        this.companhias.add("Praxis Dramatica");
        this.companhias.add("Escola de Teatro de Camaragibe");

    }
    
    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        return valor == null ? false : companhias.contains(valor);
    }
}