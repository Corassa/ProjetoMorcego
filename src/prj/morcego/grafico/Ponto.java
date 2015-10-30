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
    private int anguloInicial;
    
    public void Ponto(){
        setX(0);
        setY(0);
        setAngulo(0);
        setDist(0);
    }
    
    //crias as coordenadas a partir da distancia e do angulo
    public void decompoePonto(double escalax,double escalay){
        setX((Math.cos(angulo+anguloInicial) * dist)*escalax);
        setY((Math.sin(angulo+anguloInicial) * dist)*escalay);
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

    /**
     * @return the anguloInicial
     */
    public double getAnguloInicial() {
        return anguloInicial;
    }

    /**
     * @param anguloInicial the anguloInicial to set
     */
    public void setAnguloInicial(int anguloInicial) {
        this.anguloInicial = anguloInicial;
    }
    
}
