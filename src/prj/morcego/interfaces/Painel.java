/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.morcego.interfaces;

import prj.morcego.grafico.PlanoCartesiano;
import prj.morcego.grafico.PlanoCartesiano;
import prj.morcego.grafico.Ponto;
import prj.morcego.grafico.Ponto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ricardo
 */
public class Painel extends JPanel {
    
    public Painel() {
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
    }
    
    void desenharPlano(PlanoCartesiano plano) {
        
        ArrayList<Ponto> pontos = plano.getPontos();
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.black);
        
        Ponto p_aux = new Ponto();
        Polygon pol = new Polygon();
        
        for (int i = 0; i < pontos.size(); i++) {
            pol.addPoint((int) pontos.get(i).getX(), (int) pontos.get(i).getY());
        }
        
        pol.addPoint((int) pontos.get(0).getX(), (int) pontos.get(0).getY());
        g2d.fillPolygon(pol);

        //g2d.drawString("o", (int) pontos.get(pontos.size() - 1).getX(), (int) pontos.get(pontos.size() - 1).getY());
        g2d.draw(new Line2D.Double(pontos.get(0).getX(), pontos.get(0).getY(), pontos.get(pontos.size() - 1).getX(), pontos.get(pontos.size() - 1).getY()));
        
    }
}
