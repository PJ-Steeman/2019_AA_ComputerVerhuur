/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Pieter-Jan Steeman
 */
@Stateless
public class Toevoegen implements ToevoegenRemote {
    
    @PersistenceContext private EntityManager em;

    public void toevoegenComp(String cNaam, String cOmsch, String cLok, String cOpl, int cSerie, int cAank, int cHuur)
    {
        int lastID = (int) em.createNamedQuery("Computers.findLast").getResultList().get(0)+1;
        Computers comp = new Computers(lastID, cNaam, cOmsch, cLok, cOpl, cSerie, cAank, cHuur);
        em.persist(comp);
    }
    
    public void wijzigComp(int cId, String cNaam, String cOmsch, String cLok, int compSerie, int compAank, int compHuur)
    {
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId",cId).getResultList().get(0);
        comp.setCNaam(cNaam);
        comp.setCOmsch(cOmsch);
        comp.setCLok(cLok);
        comp.setCSerie(compSerie);
        comp.setCAankoop(compAank);
        comp.setCHuur(compHuur);
        em.merge(comp);
    }
    
    public void toevoegenMoment(String van, String tot, int compId)
    {
        int lastId = (int) em.createNamedQuery("Momenten.findLast").getResultList().get(0)+1;
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId",compId).getResultList().get(0);
        Reservaties res = (Reservaties) em.createNamedQuery("Reservaties.findByRId").setParameter("rId",0).getResultList().get(0);
        
        try {
            Date vanDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(van);
            Date totDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(tot);
            
            Momenten mom = new Momenten(lastId, vanDate, totDate);
            mom.setMComp(comp);
            mom.setMRes(res);
            em.persist(mom);
            
        } catch (ParseException ex) {
            System.out.println("Verkeerde date format");
        }
    }
    
    public void reserveer(int betalen, String uid, int mid)
    {
        int lastId = (int) em.createNamedQuery("Reservaties.findLast").getResultList().get(0)+1;
            
        Users user = (Users) em.createNamedQuery("Users.findByUId").setParameter("uId", uid).getResultList().get(0);
        Momenten mom = (Momenten) em.createNamedQuery("Momenten.findByMId").setParameter("mId", mid).getResultList().get(0);
        Computers comp = mom.getMComp();
        
        long verschil = mom.getMTot().getTime() - mom.getMVan().getTime();
        int aantalUren = (int) verschil / (60 * 60 * 1000);
        System.out.println("UREN: " + aantalUren);
        int prijs = comp.getCHuur()*betalen*aantalUren;
        
        Reservaties res = new Reservaties(lastId, prijs);
        res.setRUser(user);
        em.persist(res);
        
        mom.setMRes(res);
        em.merge(mom);
    }
}
