/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import java.io.BufferedReader;
import java.io.DataOutputStream;

/**
 *
 * @author Sadman
 */
public class serverConnectionThread extends Thread{
    
    private String userName = null;
    private dataOutputStreamStorage doss = null;
    private BufferedReader br = null;
    private DataOutputStream dos = null;
    public serverConnectionThread(String userName, dataOutputStreamStorage doss, BufferedReader br, DataOutputStream dos){
        this.userName = userName;
        this.doss = doss;
        this.br = br;
        this.dos = dos;
    }
    
    public void run(){
        while(true){
            try{
                String message = br.readLine();                  
                String sender = message.substring(0, message.indexOf(">")+2);                
                String receiver = message.substring(message.indexOf(">")+3, message.indexOf(":")); 
                String msg = message.substring(message.indexOf(":")+1, message.length());                
                message = sender + " " + msg;
                if(!receiver.equals("") && !receiver.equals(userName)) doss.conMap.get(receiver).writeBytes(message + "\n");
                else if(!receiver.equals(userName)){
                    for(String receiverKey: doss.conMap.keySet()){
                        if(!receiverKey.equals(userName)) doss.conMap.get(receiverKey).writeBytes(message + "\n");
                    }
                }
            }catch(Exception e){}
        }
    }
    
}
