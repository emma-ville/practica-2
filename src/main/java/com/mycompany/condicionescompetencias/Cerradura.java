/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condicionescompetencias;

/**
 *
 * @author Manev
 */
public class Cerradura {
    
    boolean cerradura;//una bandera o en este caso una cerradura de dos valores 
    public Cerradura() {
         cerradura = false; //la cerradura empieza con cero, es decir, que se puede ocupar el recurso compartido, cuando es 1 no se puede
    }
    public void setCerradura(boolean ban){//Este metodo cambiara el valor de mi cerradura si se ocupa o no el RC
        this.cerradura = ban;
    }
   public boolean getCerradura(){//Retorna el valor actual de mi cerradura
       return(cerradura);
    }
    
}
