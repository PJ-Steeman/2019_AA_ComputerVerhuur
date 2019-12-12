/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Remote;

/**
 * @author Pieter-Jan Steeman
 */
@Remote
public interface ToevoegenRemote {

    public void toevoegenComp(String cNaam, String cOmsch, String cLok, String cOpl, int cSerie, int cAank, int cHuur);

    public void wijzigComp(int i, String parameter, String parameter0, String parameter1, int compSerie, int compAank, int compHuur);
    
    public void toevoegenMoment(String van, String tot, int compId);
    
    public void reserveer(int betalen, String uid, int mid);
    
}
