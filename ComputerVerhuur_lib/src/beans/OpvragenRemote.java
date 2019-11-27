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
        List<Object> opvragenComp();
        Object opvragenCompById(int cid);
}
