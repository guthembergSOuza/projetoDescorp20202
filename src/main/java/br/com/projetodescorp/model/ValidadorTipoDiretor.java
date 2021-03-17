/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetodescorp.model;

import static br.com.projetodescorp.model.TipoDiretor.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidadorTipoDiretor implements ConstraintValidator<ValidaTipoDiretor, String>{
    private List<String> tipos;
    
    @Override
    public void initialize(ValidaTipoDiretor validaTipoDiretor) {
        this.tipos = new ArrayList<>();
        this.tipos.add("MUSICAL");
        this.tipos.add("GERAL");
        this.tipos.add("ILUMINACAO");
        this.tipos.add("PRODUCAO");
      
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext context) {
        return valor == null ? false : tipos.contains(valor);
    }
    
}
