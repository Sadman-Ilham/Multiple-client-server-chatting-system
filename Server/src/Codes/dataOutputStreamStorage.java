/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.io.DataOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sadman
 */
public class dataOutputStreamStorage {
    
    public Map<String, DataOutputStream>conMap = new HashMap<>();
    public void storeDataOutputStream(String userName, DataOutputStream dos){        
        conMap.put(userName, dos);        
    }
    
}
