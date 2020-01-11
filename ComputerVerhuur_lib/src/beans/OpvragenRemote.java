/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Remote;

/**
 * @author Jonas Michiels en Pieter-Jan Steeman
 */
@Remote
public interface OpvragenRemote {
    public List<Object> opvragenComp();
    public Object opvragenCompById(int cid);
    public List<Object> opvragenMom(int cid);
    public List<Object> opvragenVrijeMom(int cid);
    public int opvragenPrijs(int mId);
    public Object opvragenUser(String uid);
    public List<String> opvragenCompClient();
    public List<String> opvragenResClient(int cid);
    public String opvragenRichting(String uid);
}
