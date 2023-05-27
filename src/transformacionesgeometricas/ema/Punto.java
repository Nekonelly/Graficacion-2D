/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacionesgeometricas.ema;

import java.awt.Graphics;

/**
 *
 * @author emeji
 */
public class Punto {
    private double x,y;


    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
   public double getCoordnadaCartesianaX(){
       return x+250;
   }
   
   public double getCoordenadaCartesianaY(){
       return 250-y;
   }
   
   
   //getters y setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void pintar(Graphics g) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    g.drawLine((int)getCoordnadaCartesianaX(),(int) getCoordenadaCartesianaY(),
            (int)getCoordnadaCartesianaX(),(int) getCoordenadaCartesianaY());
    
    }
   
    
    
}
