/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.morcego.grafico;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prj.morcego.interfaces.Painel;
import prj.morcego.interfaces.Principal;
import static prj.morcego.interfaces.Principal.centro_x;
import static prj.morcego.interfaces.Principal.centro_y;

/**
 *Ciaçao e um plano cartesiano
 * @author ricardo
 */
public class Ponto {
    
    private double x;
    private double y;
    private double angulo;
    private double dist;
    
    public void Ponto(){
        setX(0);
        setY(0);
        setAngulo(0);
        setDist(0);
    }
    
    //crias as coordenadas a partir da distancia e do angulo
    public void decompoePonto(){
        setX((Math.cos(angulo) * dist)*10);
        setY((Math.sin(angulo) * dist)*10);
    }
     /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @return the angulo
     */
    public double getAngulo() {
        return angulo;
    }

    /**
     * @param angulo the angulo to set
     */
    public void setAngulo(int angulo) {
        //converte o angulo para radianos
        this.angulo = angulo * 0.0174532925;
    }

    /**
     * @return the dist
     */
    public double getDist() {
        return dist;
    }

    /**
     * @param dist the dist to set
     */
    public void setDist(int dist) {
        this.dist = dist;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    
}
