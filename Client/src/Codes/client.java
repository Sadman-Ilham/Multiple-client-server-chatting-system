/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Codes;

/**
 *
 * @author Sadman
 */
public class client extends Thread{
    
    private String un,pass;
    public client(String un, String pass){
        this.un = un;
        this.pass = pass;                        
    }
    
    public void run(){
        clientConnection cc = new clientConnection(un,pass);
        cc.setConnection();
    }

}
