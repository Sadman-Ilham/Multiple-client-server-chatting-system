/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Sadman
 */
public class clientCheck {
    
    private String clientInfo, path;
    public clientCheck(String clientInfo, String path){
        this.clientInfo = clientInfo;
        this.path = path;
    }
    public boolean checkClientInfo(){
        try{
            File file = new File(path);
            BufferedReader brForFile = new BufferedReader(new FileReader(file));
            String line = null;                
            while((line = brForFile.readLine()) != null){                
                if(line.equals(clientInfo)) return true;
            }
            return false;
        }catch(Exception e){ return false; }
    }
}
