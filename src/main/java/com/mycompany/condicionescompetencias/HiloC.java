/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condicionescompetencias;

import static java.lang.Thread.sleep;
import javax.swing.JTextArea;

/**
 *
 * @author Manev
 */
public class HiloC extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    HiloC(JTextArea area, RCompartido rc){
        this.area = area;
        this.rc = rc;
    }
    public void matar(){
        this.muerto = true;
    }
    public void run(){
       while(true){
          try{
              rc.setDatoCompartido(this.getName());//USA EL RECURSO COMPAERTIDO
              area.append(rc.getDatoCompartido()+"\n");//TERMINA EL USO COMPARTIDO
              sleep(2000);
              if(muerto == true)
                        this.stop();
          }catch(Exception e){ e.printStackTrace();}
         
       }//EL HILO UNO VA A ESCRIBR SOLO 1
    }
}
