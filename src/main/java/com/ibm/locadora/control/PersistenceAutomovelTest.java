/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.locadora.control;

import com.ibm.locadora.model.Automovel;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Leandro Paz <leandro.paz at ibm.com>
 */
public class PersistenceAutomovelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        
        Automovel auto = new Automovel();
        
        auto.setAnoFabricacao(2014);
        auto.setAnoModelo(2015);
        auto.setMarca("GM");
        auto.setModelo("Onix");
        auto.setObservacoes("Diversos sinistros...");
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(auto);
        tx.commit();
        
        em.close();
    }
    
}
