
package com.mycompany.condicionescompetencias;
public class RCompartido {

    private String datoCompartido;
    private Cerradura cerradura;
    private interrupcion[] inter;
    RCompartido(){//CONSTRUCTOR
      datoCompartido="";
      cerradura = new Cerradura();//CERRADURA
      inter = new interrupcion[2]; //tiene minimo dos interrupciones
        for(int i =0; i<inter.length; i++)//INTERRUPCIONES
            inter[i] = new interrupcion();
    }
    public String getDatoCompartido() {
        return datoCompartido;
    }

   
    public void setDatoCompartido(String datoCompartido) {
        this.datoCompartido = datoCompartido;
    }
    //-------------CERRADURA----------------------------
    public boolean getCerradura(){
      boolean c = cerradura.getCerradura();
      return (c);
    }
    
    public void setCerradura(boolean v){
      cerradura.setCerradura(v);
    }
 //------------INTERRUPCIONES--------------------
    public int largo(){
        return inter.length;
    }
    
    public boolean comprobarInter(int i){
        return inter[i].getInter();
    }
    
    public void estadoInter(int i, boolean estado){
       inter[i].setDatoInter(estado);
    }
//-------------------------------------------------------
}
