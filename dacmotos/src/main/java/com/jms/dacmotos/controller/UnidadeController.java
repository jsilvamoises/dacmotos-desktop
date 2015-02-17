/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jms.dacmotos.controller;

import com.jms.dacmotos.beans.MensagensParaFacesUtil;
import com.jms.dacmotos.model.Unidade;
import com.jms.dacmotos.util.FacesUtil;
import com.jms.dacmotos.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Moises
 */
public class UnidadeController implements Serializable {

    @Inject
    MensagensParaFacesUtil msg;
    Session session;

    /**/
    /**
     *
     * @param unidade
     * @return
     *
     */
    //SALVA OU ATUALIZA O OBJETO
    public boolean salvar(Unidade unidade) {
        try {
            session = getSession();
            session.getTransaction().begin();
            session.saveOrUpdate(unidade);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage(msg.getSALVO_COM_SUCESSO());
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage(msg.getERRO_AO_SALVAR() + e.getCause().toString());
            return false;
        }
    }

    public boolean excluir(Unidade unidade) {
        try {
            session = getSession();
            session.getTransaction().begin();
            session.delete(unidade);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage(msg.getEXCLUIDO_COM_SUCESSO());
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage(msg.getERRO_AO_EXCLUIR() + e.getCause().toString());
            return false;
        }
    }

    public boolean merge(Unidade unidade) {
        try {
            session = getSession();
            session.getTransaction().begin();
            session.merge(unidade);
            session.getTransaction().commit();
            FacesUtil.addInfoMessage(msg.getSALVO_COM_SUCESSO());
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            FacesUtil.addInfoMessage(msg.getERRO_AO_SALVAR() + e.getCause().toString());
            return false;
        }
    }

    public Unidade getUnidadeById(Long id) {
        try {
            session = getSession();
            session.getTransaction().begin();
            return (Unidade) session.get(Unidade.class, id);
        } catch (Exception e) {
            return null;
        }finally{
            session.getTransaction().commit();
        }

    }
    
    public List<Unidade> unidades(){
        try {
            session = getSession();
            session.getTransaction().begin();
            Criteria criteria = session.createCriteria(Unidade.class);
            return criteria.list();
        } catch (Exception e) {
            return null;
        }finally{
            session.getTransaction().commit();
           
        }
    }

    private Session getSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }
}
