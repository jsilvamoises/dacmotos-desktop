/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.produces;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Moises
 */
public class UnidadeController {
    @Produces
    public UnidadeController getUnidade(){
        return new UnidadeController();
    }
}
