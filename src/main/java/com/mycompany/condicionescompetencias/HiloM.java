/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condicionescompetencias;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JTextArea;
/**
 *
 * @author Manev
 */
public class HiloM extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    //mutex
    static Semaphore semaphore = new Semaphore(1);
    boolean lock;
    char c = ' ';
    
    HiloM(JTextArea area, RCompartido rc, boolean lock){
        this.area = area;
        this.rc = rc;
        this.lock = lock;//mutex
    }
    public void matar(){
        this.muerto = true;
    }
    public void run(){
       while(true){
          try{
               if(lock) semaphore.acquire();
               try {
                  
                     rc.setDatoCompartido(this.getName());//USA EL RECURSO COMPAERTIDO
                    area.append(rc.getDatoCompartido()+"\n");//TERMINA EL USO COMPARTIDO
                    sleep(2000);
                  if(muerto == true)
                        this.stop();
               } finally {
                  if(lock) {
                  semaphore.release();
                  }
               }
          }catch(Exception e){ e.printStackTrace();}
         
       }//EL HILO UNO VA A ESCRIBR SOLO 1
    }
}
