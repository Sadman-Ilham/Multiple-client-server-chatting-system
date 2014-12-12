/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import GUI.dataDirectory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 *
 * @author Sadman
 */
public class serverConnection extends Thread{
        
    private String userName, password, path;
    public void setConnection(String path){
        this.path = path;
        try{
            ServerSocket ss = new ServerSocket(6689);
            dataOutputStreamStorage doss = new dataOutputStreamStorage();
            
            while(true){                
                Socket con = ss.accept();                
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                DataOutputStream dos = new DataOutputStream(con.getOutputStream());
                
                String securityData = br.readLine();
                
                userName = securityData.substring(0, securityData.indexOf(":")-1);
                password = securityData.substring(securityData.indexOf(":")+3,securityData.length());                                
                      
                clientCheck clntChk = new clientCheck(securityData, path);
                boolean valid = clntChk.checkClientInfo();
                
                if(valid){
                    dos.writeBytes("0\n");
                    doss.storeDataOutputStream(userName, dos);                                                                       
                    Thread t = new Thread(new serverConnectionThread(userName, doss, br, dos));                             
                    t.start();                    
                }
                else{
                    dos.writeBytes("1\n");
                }
            }
        }catch(Exception e){}
    }
    
}
