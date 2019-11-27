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
    
    void toevoegenComp(String cNaam, String cOmsch, String cLok, String cOpl, int cSerie, int cAankoop, int cHuur);
    void wijzigComp(int cId, String cNaam, String cOmsch, String cLok, int cSerie, int cAankoop, int cHuur);
    
}
