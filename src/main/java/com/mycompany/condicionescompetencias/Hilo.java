
package com.mycompany.condicionescompetencias;

import static java.lang.Thread.sleep;
import javax.swing.JTextArea;

public class Hilo extends Thread {
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    
    Hilo(JTextArea area, RCompartido rc){
        this.area = area;
        this.rc = rc;
        muerto = false;
        
    }
    public void run(){
       while(true){
          try{
              if(rc.getCerradura() == false){//Si nadie esta ocupando el RC y la cerradura esta en cero
                  
                rc.setCerradura(true);//Cambiamos el valor de la cerradura a 1, avisando que alguien esta usando el RC*/
                rc.setDatoCompartido(this.getName());//USA EL RECURSO COMPAERTIDO
                if(muerto == true){
                        this.stop();}
                
               rc.setCerradura(false);//se mete de nuevo 1 a la cerradura dejando libre el RC a los demas hilos 
              }else{
                System.out.println("Un hilo esta esperando");//mensaje que se muestra en terminal comprobando que los hilos esperan
                area.append("Esperando... "+"\n");//TERMINA EL USO COMPARTIDO
              }
              
              area.append(rc.getDatoCompartido()+"\n");//TERMINA EL USO COMPARTIDO
              sleep(2000);
              
          }catch(Exception e){ e.printStackTrace();}
         
       }//EL HILO UNO VA A ESCRIBR SOLO 1
    }

   public void matar(){
        this.muerto = true;
    }

   
}
