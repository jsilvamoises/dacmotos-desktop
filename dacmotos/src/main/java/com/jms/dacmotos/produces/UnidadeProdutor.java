/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.produces;

import com.jms.dacmotos.model.Unidade;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Moises
 */
public class UnidadeProdutor {
    @Produces
    public Unidade getUnidade(){
        return new Unidade();
    }
}
