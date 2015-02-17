/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.beans;

/**
 *
 * @author Moises
 */
public class MensagensParaFacesUtil {

    private static final String SALVO_COM_SUCESSO = "Registro salvo com sucesso!";
    private static final String ERRO_AO_SALVAR = "Não foi possível salvar o registro!!!!";
    private static final String ERRO_AO_EXCLUIR = "Não foi possível excluir o registro!!!!";
    private static final String EXCLUIDO_COM_SUCESSO = "Registro excluído com sucesso!!!!";

    public String getERRO_AO_EXCLUIR() {
        return ERRO_AO_EXCLUIR;
    }

    public String getEXCLUIDO_COM_SUCESSO() {
        return EXCLUIDO_COM_SUCESSO;
    }

    public String getERRO_AO_SALVAR() {
        return ERRO_AO_SALVAR;
    }

    public String getSALVO_COM_SUCESSO() {
        return SALVO_COM_SUCESSO;
    }

}
