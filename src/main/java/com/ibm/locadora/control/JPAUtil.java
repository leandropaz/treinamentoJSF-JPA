/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.locadora.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leandro Paz <leandro.paz at ibm.com>
 */
public class JPAUtil {
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("JsfJpa_war_1.0");
    
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
