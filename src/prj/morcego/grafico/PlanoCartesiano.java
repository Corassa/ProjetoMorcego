/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.morcego.grafico;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ricardo
 */
public class PlanoCartesiano extends JPanel {

    private double eixo_x;
    private double eixo_y;
    private ArrayList<Ponto> pontos;

    public PlanoCartesiano() {

        this.setFocusable(true);
        this.setBackground(Color.WHITE);
        eixo_x = 0;
        eixo_y = 0;
        pontos = new ArrayList<Ponto>();
    }

    /*
     * Adiciona todos os pontos que forem medidos
     */
    public void addPonto(Ponto p) {
        Ponto p_aux = new Ponto();

        if (p.getAngulo() >= 90 && p.getAngulo() <= 270) {
            p_aux.setX(eixo_x - p.getX());
        } else {
            p_aux.setX(eixo_x + p.getX());
        }

        if (p.getAngulo() >= 180 && p.getAngulo() <= 360) {
            p_aux.setY(eixo_y - p.getY());
        } else {
            p_aux.setY(eixo_y + p.getY());
        }

        pontos.add(p_aux);
    }

    /**
     * @return the eixo_x
     */
    public double getEixo_x() {
        return eixo_x;
    }

    /**
     * @param eixo_x the eixo_x to set
     */
    public void setEixo_x(int eixo_x) {
        this.eixo_x = eixo_x;
    }

    /**
     * @return the eixo_y
     */
    public double getEixo_y() {
        return eixo_y;
    }

    /**
     * @param eixo_y the eixo_y to set
     */
    public void setEixo_y(int eixo_y) {
        this.eixo_y = eixo_y;
    }

    /**
     * @return the pontos
     */
    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }
}
