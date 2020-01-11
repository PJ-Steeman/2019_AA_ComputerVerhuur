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
    public List<String> opvragenCompClient(){
        List<Object> comp = em.createNamedQuery("Computers.findAll").getResultList();
        List<String> comps = new ArrayList();
        for(int i = 0; i < comp.size(); i++){
            comps.add(((Computers)comp.get(i)).getCId() + " - " + ((Computers)comp.get(i)).getCNaam() + " - " + ((Computers)comp.get(i)).getCOmsch());
        }
        return comps;
    }
    
    public List<String> opvragenResClient(int cid){
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId", cid).getResultList().get(0);
        List<Object> res = em.createNamedQuery("Momenten.findByMComp").setParameter("mComp",comp).getResultList();
        
        List<String> reservaties = new ArrayList<>();
        
        for(int i = 0; i<res.size();i++){
            if(((Momenten)res.get(i)).getMRes().getRId() != 0){
                reservaties.add(((Momenten)res.get(i)).getMVan().toString() + " - " + ((Momenten)res.get(i)).getMTot().toString() + " - " + ((Momenten)res.get(i)).getMRes().getRUser().getUNaam());
            }
        }
        return reservaties;
        
    }
    public Object opvragenUser(String uid){
        Object user = em.createNamedQuery("Users.findByUId").setParameter("uId", uid).getResultList().get(0);
        return user;
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
    
    public String opvragenRichting(String uid)
    {
        Users gebruiker = (Users) em.createNamedQuery("Users.findByUId").setParameter("uId", uid).getResultList().get(0);
        return gebruiker.getURichting();
    }
}
