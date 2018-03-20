/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.locadora.bean;

import com.ibm.locadora.control.JPAUtil;
import com.ibm.locadora.model.Automovel;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Leandro Paz <leandro.paz at ibm.com>
 */
@ManagedBean
@ViewScoped
public class AutomovelBean {

    private Automovel automovel = new Automovel();

    private List<Automovel> automoveis;
    private Marca marca;    //utilitario para buscar os modelos

    public List<Automovel> getAutomoveis() {
        if (automoveis == null) {
            EntityManager em = JPAUtil.getEntityManager();

            Query q = em.createQuery("select a from Automovel a", Automovel.class);
            this.automoveis = q.getResultList();
            em.close();
        }

        return automoveis;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public void salva(Automovel automovel) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.persist(automovel);
        em.getTransaction().commit();
        em.close();

        System.out.println("Carro " + automovel.getMarca() + " salvo com sucesso!");
    }
    
    public void exclui(Automovel automovel) {
        EntityManager em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        automovel = em.merge(automovel); //?
        em.remove(automovel);
        em.getTransaction().commit();
        em.close();
    }
}
