
package com.mycompany.condicionescompetencias;

import static java.lang.Thread.sleep;
import javax.swing.JTextArea;

public class Hilo extends Thread {
    private JTextArea area;
    private RCompartido rc;
    
    Hilo(JTextArea area, RCompartido rc){
        this.area = area;
        this.rc = rc;
    }
    public void run(){
       while(true){
          try{
              rc.setDatoCompartido(this.getName());//USA EL RECURSO COMPAERTIDO
              area.append(rc.getDatoCompartido()+"\n");//TERMINA EL USO COMPARTIDO
              sleep(2000);
          }catch(Exception e){ e.printStackTrace();}
         
       }//EL HILO UNO VA A ESCRIBR SOLO 1
    }

   

   
}
