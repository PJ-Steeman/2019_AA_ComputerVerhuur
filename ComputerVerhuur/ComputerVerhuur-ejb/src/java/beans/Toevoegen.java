/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Pieter-Jan Steeman
 */
@Stateless
public class Toevoegen implements ToevoegenRemote {

    @PersistenceContext private EntityManager em;
    
    public void toevoegenComp(String cNaam, String cOmsch, String cLok, String cOpl, int cSerie, int cAankoop, int cHuur)
    {
        Integer lastId = (Integer)em.createNamedQuery("Computers.findLast").getResultList().get(0);
        Integer nextId = lastId + 1;
        System.out.println("------------"+nextId);
        Computers newComp = new Computers(nextId, cNaam, cOmsch, cLok, cOpl, cSerie, cAankoop, cHuur);
        em.persist(newComp);
    }
    
    public void wijzigComp(int cId, String cNaam, String cOmsch, String cLok, int cSerie, int cAankoop, int cHuur)
    {
        Computers comp = (Computers) em.createNamedQuery("Computers.findByCId").setParameter("cId",cId).getResultList().get(0);
        em.remove(comp);
        comp.setCNaam(cNaam);
        comp.setCOmsch(cOmsch);
        comp.setCLok(cLok);
        comp.setCSerie(cSerie);
        comp.setCAankoop(cAankoop);
        comp.setCHuur(cHuur);
        em.persist(comp);
    }
    
}
