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
public abstract class ModeloExclusion {
    public static final int TURN_0 = 0;
    public static final int TURN_1 = 1;
    public static final int TIME = 2000;
    public static void SC() {
    try {
    Thread.sleep((int) (Math.random() * TIME + 1000));
    } catch (InterruptedException e) {}
    }
    public static void noSC() {
    try {
    Thread.sleep((int) (Math.random() * TIME));
    } catch (InterruptedException e) {}
    }
    public abstract void entrarSC(int iId);
    public abstract void salirSC(int iId);

}
