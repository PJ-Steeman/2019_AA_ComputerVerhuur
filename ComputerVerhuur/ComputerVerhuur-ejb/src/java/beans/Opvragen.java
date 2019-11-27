/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Jonas Michiels en Pieter-Jan Steeman
 */
@Stateless
public class Opvragen implements OpvragenRemote {
    
    @PersistenceContext private EntityManager em;

    public List<Object> opvragenComp(){
        List<Object> comp = em.createNamedQuery("Computers.findAll").getResultList();
        return comp;
    }
    
    public Object opvragenCompById(int cid){
        Object comp = em.createNamedQuery("Computers.findByCId").setParameter("cId",cid).getResultList().get(0);
        return comp;
    }
}
