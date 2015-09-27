/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

        double eixo_x = plano.getEixo_x();
        double eixo_y = plano.getEixo_y();

        for (int i = 1; i < pontos.size(); i++) {

            g2d.draw(new Line2D.Double(pontos.get(i - 1).getX(), pontos.get(i - 1).getY(), pontos.get(i).getX(), pontos.get(i).getY()));

            g2d.drawString("" + i, (int) pontos.get(i).getX(), (int) pontos.get(i).getY());
        }
        //g2d.drawString("o", (int) pontos.get(pontos.size() - 1).getX(), (int) pontos.get(pontos.size() - 1).getY());
        g2d.draw(new Line2D.Double(pontos.get(0).getX(), pontos.get(0).getY(), pontos.get(pontos.size() - 1).getX(), pontos.get(pontos.size() - 1).getY()));

    }
}
