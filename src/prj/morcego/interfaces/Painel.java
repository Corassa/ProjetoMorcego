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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import sun.awt.image.codec.JPEGImageEncoderImpl;

/**
 *
 * @author ricardo
 */
public class Painel extends JPanel implements RenderedImage {

    Graphics2D g2d;

    public Painel() {
        this.setFocusable(true);
        this.setBackground(Color.WHITE);
    }
    Polygon pol;

    void desenharPlano(PlanoCartesiano plano) {

        ArrayList<Ponto> pontos = plano.getPontos();
        g2d = (Graphics2D) this.getGraphics();
        
        /*Determinando a cor randomicamente*/
        float r = new Random().nextFloat();
        float g = new Random().nextFloat();
        float b = new Random().nextFloat();
        Color randomColor = new Color(r, g, b);
        g2d.setColor(randomColor);

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
        g2d = (Graphics2D) this.getGraphics();
        g2d.drawString("L", x, y);
        /*BufferedImage img = ImageIO.read(new File("/home/ricardo/NetBeansProjects/ProjetoMorcego/src/prj/morcego/img/morcego-icone.png"));
        g2d.drawImage(img, x, y, null);*/
    }

    public void salvarImagem(String str, int x, int y) throws IOException {
        BufferedImage bImg = new BufferedImage(this.getWidth(), this.getWidth(), BufferedImage.TYPE_INT_RGB);
        this.paintAll((Graphics) g2d);
        try {
            if (ImageIO.write(bImg, "png", new File("/home/ricardo/output_image.png"))) {
                System.out.println("-- saved");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Vector<RenderedImage> getSources() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProperty(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getPropertyNames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SampleModel getSampleModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumXTiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumYTiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinTileX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMinTileY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTileWidth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTileHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTileGridXOffset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTileGridYOffset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Raster getTile(int tileX, int tileY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Raster getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Raster getData(Rectangle rect) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WritableRaster copyData(WritableRaster raster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
