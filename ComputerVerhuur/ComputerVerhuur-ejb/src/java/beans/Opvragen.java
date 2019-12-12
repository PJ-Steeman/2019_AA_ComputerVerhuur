/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
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
    
    public List<Object> opvragenMom(int cid){ 
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId",cid).getResultList().get(0);
        System.out.println(comp.toString());
        List<Object> mom = em.createNamedQuery("Momenten.findByMComp").setParameter("mComp",comp).getResultList();
        System.out.println(mom.toString());
        return mom;
    }
    
    public List<Object> opvragenVrijeMom(int cid){ 
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId",cid).getResultList().get(0);
        System.out.println(comp.toString());
        List<Object> mom = em.createNamedQuery("Momenten.findByMComp").setParameter("mComp",comp).getResultList();
        List<Object> freeMom = new ArrayList<Object>();
        for(int i = 0; i < mom.size(); i++)
        {
            if(((Momenten) mom.get(i)).getMRes().getRId() == 0)
            {
                Momenten temp = (Momenten) mom.get(i);
                freeMom.add(temp);
            }
        }
        System.out.println(freeMom.toString());
        return freeMom;
    }
    
    public int opvragenPrijs(int mId)
    {
        Momenten mom = (Momenten) em.createNamedQuery("Momenten.findByMId").setParameter("mId", mId).getResultList().get(0);
        Computers comp = mom.getMComp();
        long verschil = mom.getMTot().getTime() - mom.getMVan().getTime();
        int aantalUren = (int) verschil / (60 * 60 * 1000);
        System.out.println("UREN: " + aantalUren);
        return comp.getCHuur()*aantalUren;
    }
}
