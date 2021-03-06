/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 http://playground.arduino.cc/Interfacing/Java
 */
package prj.morcego.serial;

/**
 *
 * @author ricardo
 */
import prj.morcego.interfaces.Principal;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import prj.morcego.grafico.Ponto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

public class Serial implements SerialPortEventListener {

    SerialPort serialPort;
    /**
     * The port we're normally going to use.
     */
    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results codepage independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 9600;

    private ArrayList<Integer> lidos = new ArrayList<Integer>();

    private ArrayList<Ponto> pontos_lidos = new ArrayList<Ponto>();

    public Serial() throws IOException {
    }
    
    private String port = "/dev/ttyUSB0";

    public void initialize() {
        // the next line is for Raspberry Pi and 
        // gets us into the while loop and was suggested here was suggested http://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
        System.setProperty("gnu.io.rxtx.SerialPorts", getPort() /*"/dev/ttyUSB0"*/ );

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * This should be called when you stop using the port. This will prevent
     * port locking on platforms like Linux.
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                String[] lp = inputLine.split(" ");
                double dist = Double.parseDouble(lp[0]);
                int ang = Integer.parseInt(lp[1]);
                System.out.println("dist " + dist + " ang " + ang);
                Ponto p = new Ponto();
                p.setDist(dist);
                p.setAngulo(ang);
                pontos_lidos.add(p);
            } catch (Exception e) {
                System.err.println("Erro aqui tchê ! " + e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }

    public void enviaDados(int opcao) {
        try {
            output.write(opcao);//escreve o valor na porta serial para ser enviado
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }

    /**
     * @return the lidos
     */
    public ArrayList<Integer> getLidos() {
        return lidos;
    }

    /**
     * @param lidos the lidos to set
     */
    public void setLidos(ArrayList<Integer> lidos) {
        this.lidos = lidos;
    }

    /**
     * @return the pontos_lidos
     */
    public ArrayList<Ponto> getPontos_lidos() {
        return pontos_lidos;
    }

    /**
     * @param pontos_lidos the pontos_lidos to set
     */
    public void setPontos_lidos(ArrayList<Ponto> pontos_lidos) {
        this.pontos_lidos = pontos_lidos;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }
}
