/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condicionescompetencias;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
/**
 *
 * @author Manev
 */
public class HiloInt extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean muerto;
    private int tiempo;
    
    HiloInt(JTextArea area, RCompartido rc, int tiempo){
        this.area = area; 
        this.rc = rc;
        this.muerto = false;
        this.tiempo = tiempo;
    }
    
    public void matar(){
        this.muerto = true;
    }
    
    public void run(){
        boolean bandera = false;
        while(true){
            try{
                //Nuestro hilo recorre nuestro arreglo de interrupciones.
                int largo = rc.largo();
                bandera = false;
                sleep(tiempo);
                //Este for nos ayuda a determinar si nuestro arreglo 
                //de interrupciones nos indica si alguno
                //de nuestros hilos esta usando la sección critica
                for(int i = 0; i<largo; i++)
                    if(rc.comprobarInter(i) == true)
                        
                        bandera = true;
                //area.append("Esperando..."+ "\n");
                //Si la bandera es verdadera, quiere decir que 
                //otro hilo esta ocupando la sección critica.
                //System.out.println(bandera);
                if (bandera == false){
                    //Aca entra a su sección critica
                    rc.setDatoCompartido(this.getName());
                    //Dado que esta en su seccion critica debemos marcar
                    //interrupcion en true
                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, true);
                    
                    if(muerto == true)
                        this.stop();

                    area.append(rc.getDatoCompartido()+ "\n");

                    sleep(1000);

                    for(int i = 0; i<largo; i++)
                        rc.estadoInter(i, false);
                }
            }catch(Exception e){e.printStackTrace();}
        }
    }
}
