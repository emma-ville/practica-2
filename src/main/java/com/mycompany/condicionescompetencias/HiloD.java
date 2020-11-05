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
public class HiloD extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    //---
    private String name;
    private int m_iId;
    private ModeloExclusion m_oExc;
   

    HiloD(JTextArea area, RCompartido rc, String sName, int iId, ModeloExclusion oExc){
        this.area = area;
        this.rc = rc;
        name = sName;
        m_iId = iId;
        m_oExc = oExc;
    }
    /*public HiloD(String sName, int iId, ModeloExclusion oExc, RCompartido rc) {
    name = sName;
    m_iId = iId;
    m_oExc = oExc;
    this.rc = rc;
    }*/

    public void matar(){
        this.muerto = true;
    }
    @SuppressWarnings("empty-statement")
    public void run(){
       while(true){
          try{
              //--------
              while (true) {
                System.out.println(name + "desea entrar a la SC");
                m_oExc.entrarSC(m_iId);
                System.out.println(name + "entro a la SC");
                rc.setDatoCompartido(this.getName());//USA EL RECURSO COMPAERTIDO
                area.append(rc.getDatoCompartido()+"\n");//TERMINA EL USO COMPARTIDO
                ModeloExclusion.SC();
                if(muerto == true)
                        this.stop();
                m_oExc.salirSC(m_iId);
                System.out.println(name + "salio de la SC");
                ModeloExclusion.noSC();
}

              //----
              
              
              //sleep(2000);
              
          }catch(Exception e){ e.printStackTrace();}
         
       }//EL HILO UNO VA A ESCRIBR SOLO 1
    }
}
