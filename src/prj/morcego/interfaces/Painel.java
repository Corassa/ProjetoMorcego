/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj.morcego.interfaces;

import com.sun.image.codec.jpeg.JPEGImageEncoder;
import prj.morcego.grafico.PlanoCartesiano;
import prj.morcego.grafico.Ponto;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import sun.awt.image.codec.JPEGImageEncoderImpl;

/**
 *
 * @author ricardo
 */
public class Painel extends JPanel {

    Graphics2D g2d;

    public Painel() {
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
    }
    Polygon pol;

    void desenharPlano(PlanoCartesiano plano) {

        ArrayList<Ponto> pontos = plano.getPontos();
        g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.GREEN);

        pol = new Polygon();

        for (int i = 0; i < pontos.size(); i++) {
            pol.addPoint((int) pontos.get(i).getX(), (int) pontos.get(i).getY());
        }

        pol.addPoint((int) pontos.get(0).getX(), (int) pontos.get(0).getY());
        g2d.fillPolygon(pol);

        //g2d.drawString("o", (int) pontos.get(pontos.size() - 1).getX(), (int) pontos.get(pontos.size() - 1).getY());
        g2d.draw(new Line2D.Double(pontos.get(0).getX(), pontos.get(0).getY(), pontos.get(pontos.size() - 1).getX(), pontos.get(pontos.size() - 1).getY()));

    }

    void escreveNaTela(String str) {
        g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(str, 10, 20);
    }

    public void desenhaRobo(int x, int y) throws IOException {
        BufferedImage img = ImageIO.read(new File("/home/ricardo/NetBeansProjects/ProjetoMorcego/src/prj/morcego/img/morcego-icone.png"));
        g2d.drawImage(img, x, y, null);
    }

    public void salvarImagem(String str, int x, int y) throws IOException {
        escreveNaTela("EM DESENVOLVIMENTO TCHÊ !");
    }
}
