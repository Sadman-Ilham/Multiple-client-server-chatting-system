/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

import GUI.chatFrame;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Sadman
 */
public class clientConnection {
    
    private String un,pass;
    public clientConnection(String un, String pass){
        this.un = un;
        this.pass = pass;        
    }
    
    public void setConnection(){
        try{
            Socket clientSocket = new Socket("localhost", 6689);
            
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            
            dos.writeBytes(un + " :: " + pass + "\n");
            
            String code = br.readLine();
            if(code.equals("0")){
                chatFrame cf = new chatFrame(un, dos);                        

                while(true){                    
                    String message = br.readLine();
                    cf.receivedMessageArea.append(message + "\n");                    
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD!!TRY AGAIN");
            }
        }catch(Exception e){}
    }
    
}
