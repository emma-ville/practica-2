/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.condicionescompetencias;

import static com.mycompany.condicionescompetencias.ModeloExclusion.TURN_0;

/**
 *
 * @author Manev
 */
public class Decker extends ModeloExclusion{
    
    private volatile int m_iTurn;
     public Decker() {
                m_iTurn = TURN_0;
         }
     public void entrarSC(int iId) {
                while (m_iTurn != iId)
                Thread.yield();
            }
     public void salirSC(int iId) {
                m_iTurn = 1 - iId;
            }
                
                
}
