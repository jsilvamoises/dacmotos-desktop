/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.beans;

import com.jms.dacmotos.controller.UnidadeController;
import com.jms.dacmotos.model.Unidade;
import com.jms.dacmotos.util.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Moises
 */
@Named(value = "beanUnidade")
@ConversationScoped

public class BeanUnidade implements Serializable {

    @Inject
    private Conversation conversation;

    private boolean disableCampo = true;

    @Inject
    private Unidade unidade;

    @Inject
    private UnidadeController controller;

    private List<Unidade> unidades;// = new ArrayList<>();
    
    private Unidade unidadeSelecionada;

    public void habilitarCampos() {
        disableCampo = false;

    }
    
   

    @PostConstruct
    public void iniciaConversacao() {
        if (conversation.isTransient()) {
            disableCampo = false;
            conversation.begin();
        }
    }

    public void terminaConversacao() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public boolean isDisableCampo() {
        return disableCampo;
    }

    public void listarTodos() {
        unidades = controller.unidades();
    }

    public void save() {
        System.out.println("Passou aqui xa");
        try {
            if (controller.salvar(unidade)) {
                disableCampo = true;
                unidades = null;
            }

           // iniciarConversacao();
        } catch (Exception e) {
        }
    }
    
    
    public void delete(){
        if(controller.excluir(unidadeSelecionada)){
            unidades = null;
        }
    }
    
    

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public List<Unidade> getUnidades() {
        if (unidades == null) {
            unidades = controller.unidades();
        }

        return unidades;
    }

    public void setUnidades(List<Unidade> unidades) {
        this.unidades = unidades;
    }

    public UnidadeController getController() {
        return controller;
    }

    public void setController(UnidadeController controller) {
        this.controller = controller;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public Unidade getUnidadeSelecionada() {
        return unidadeSelecionada;
    }

    public void setUnidadeSelecionada(Unidade unidadeSelecionada) {
        
        this.unidadeSelecionada = unidadeSelecionada;
    }

}
