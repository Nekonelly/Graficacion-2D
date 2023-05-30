/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacionesgeometricas.ema;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author emeji
 */
public class VentanaPrincipal extends JFrame {

    private JPanel lienzo; //CANVAS
    
    private JButton btnPintarLinea; 
    private JButton btnPintarCuadrado;
    private JButton btnPintarCubo;
    private JButton btnPintarTriangulo;
    private JButton btnPintarElipse;
    private JButton btnPintarCirculo;
    
    private JSlider slider;
    private JSlider sliderX;
    private JSlider sliderY;
    private JSlider sliderz;
    private JSlider sliderRX;
    private JSlider sliderRZ;
    private JSlider sliderEsc;
    
    private int idActual;
    private int value;
    
    private Graphics2D g2d;
    
    private int lnx1,lnx2;
    private int lny1,lny2;
    private int trx1,trx2,trx3;
    private int try1,try2,try3;
    private int cuax1,cuax2,cuax3,cuax4;
    private int cuay1,cuay2,cuay3,cuay4;
    private int cbx1,cbx2,cbx3,cbx4;
    private int cby1,cby2,cby3,cby4;
    private int elCX,elCY,elA,elB;
    private int cirCX,cirCY,rad;
    
    private int hLinea;
    private int wLinea;

    public VentanaPrincipal() {
        this.setLayout(null);
        this.setBounds(0, 0, 800, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar lienzo y otros componentes
        this.add(getLienzo());

        this.add(getBtnPintarLinea());
        this.add(getBtnPintarTriangulo());
        this.add(getBtnPintarCuadrado());
        this.add(getBtnPintarElipse());
        this.add(getBtnPintarCubo());
        this.add(getBtnPintarCirculo());
        
        this.add(getSliderColorLienzo());
        this.add(getSliderMovimientoX());
        this.add(getSliderMovimientoY());
        this.add(getSliderMovimientoZ());
        this.add(getSliderRotarX());
        this.add(getSliderRotarZ());
        
        this.add(getSliderEsc());

        this.setVisible(true);

    }

    public JPanel getLienzo() {

        if (lienzo == null) { //Toda la config
            lienzo = new JPanel() {
                @Override
                public void paint(Graphics g) {
                    super.paint(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    //
                    AccionesGraficas.pintarPlanoCartesiano(g);

                }

            };
            //configuracion del lienzo
            lienzo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //super.mouseClicked(e); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    System.out.println(e.getX() + " - " + e.getY());
                }
            });
            lienzo.setBounds(250, 25, 500, 500);
            lienzo.setBackground(Color.WHITE);
        }
        return lienzo;
    }

    public JButton getBtnPintarLinea() {
        if (btnPintarLinea == null) { //Toda la config
            btnPintarLinea = new JButton("Pintar Linea con Bresenham");
            
        }
        btnPintarLinea.setBounds(10, 25, 220, 40);
        
            lnx1=10;lnx2=10;
            lny1=10;lny2=100;
        btnPintarLinea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idActual=1;
                borrarLienzo(); // Borra el contenido anterior del lienzo
                AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(),
                        lnx1, lny1, lnx2, lny2);
                hLinea=lny2-lny1;
                wLinea=lnx2-lnx1;
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
            }
        });
        return btnPintarLinea;
    }

    public JButton getBtnPintarTriangulo() {
        if (btnPintarTriangulo == null) { //Toda la config
            btnPintarTriangulo = new JButton("Pintar Triangulo");
        }
        btnPintarTriangulo.setBounds(10, 75, 220, 40);
        trx1=10;trx2=100;trx3=50;
        try1=10;try2=10;try3=100;
        btnPintarTriangulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            idActual=2;       
            borrarLienzo(); // Borra el contenido anterior del lienzo
                AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(),
                        new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));
            
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
            }
        });
        return btnPintarTriangulo;
    }
    
    public JButton getBtnPintarCuadrado() {
        if (btnPintarCuadrado == null) { //Toda la config
            btnPintarCuadrado = new JButton("Pintar Cuadrado");
        }
        btnPintarCuadrado.setBounds(10, 125, 220, 40);
        cuax1=10;cuax2=100;cuax3=100;cuax4=10;
        cuay1=10;cuay2=10;cuay3=100;cuay4=100;
        
        btnPintarCuadrado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idActual=3;
                borrarLienzo(); // Borra el contenido anterior del lienzo
                AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(),
                        new Punto(cuax1, cuay1), new Punto(cuax2, cuay2), 
                        new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
            }
        });
        return btnPintarCuadrado;
    }
    public JButton getBtnPintarCubo() {
        if (btnPintarCubo == null) { //Toda la config
            btnPintarCubo = new JButton("Pintar Cubo");
        }
        btnPintarCubo.setBounds(10, 175, 220, 40); 
        cbx1=10;cbx2=100;cbx3=100;cbx4=10;
        cby1=10;cby2=10;cby3=100;cby4=100;
        
        btnPintarCubo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idActual=4;
                borrarLienzo(); // Borra el contenido anterior del lienzo
                        AccionesGraficas.pintarCubo(getLienzo().getGraphics(),
                        new Punto(cbx1, cby1), new Punto(cbx2, cby2), 
                        new Punto(cbx3, cby3), new Punto(cbx4, cby4));
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
            }
        });
        return btnPintarCubo;
    }
    public JButton getBtnPintarElipse() {
        if (btnPintarElipse == null) { //Toda la config
            btnPintarElipse = new JButton("Pintar Elipse");
        }
        btnPintarElipse.setBounds(10, 225, 220, 40);
        elCX=0;elCY=0;elA=50;elB=50;
        btnPintarElipse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idActual=5;
                borrarLienzo(); // Borra el contenido anterior del lienzo
                AccionesGraficas.pintarElipse(getLienzo().getGraphics(), 
                        elCX, elCY, elA, elB);
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
                 }
        });
        return btnPintarElipse;
    }
    
        public JButton getBtnPintarCirculo() {
        if (btnPintarCirculo == null) { //Toda la config
            btnPintarCirculo = new JButton("Pintar Circulo");
        }
        btnPintarCirculo.setBounds(10, 275, 220, 40);
        cirCX=0;cirCY=0;rad=50;
        btnPintarCirculo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idActual=6;
                borrarLienzo(); // Borra el contenido anterior del lienzo
                AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), 
                        cirCX, cirCY, rad);
                sliderX.setValue(0); // Valor inicial del slider
                sliderY.setValue(0); // Valor inicial del slider
                sliderz.setValue(0); // Valor inicial del slider
                sliderEsc.setValue(0); // Valor inicial del slider
                sliderRX.setValue(0); // Valor inicial del slider
                sliderRZ.setValue(0); // Valor inicial del slider
            }
        });
        return btnPintarCirculo;
    }
private void borrarLienzo() {
    // Obtener el gráfico del lienzo
    g2d = (Graphics2D) getLienzo().getGraphics();

    // Obtener el color de fondo del lienzo
    Color backgroundColor = getLienzo().getBackground();

    // Borrar todo el contenido del lienzo utilizando el color de fondo
    g2d.setColor(backgroundColor);
    g2d.fillRect(0, 0, getLienzo().getWidth(), getLienzo().getHeight());
    
    AccionesGraficas.pintarPlanoCartesiano(g2d);
}
    public JSlider getSliderColorLienzo() {
        if (slider == null) {

            slider = new JSlider();

            slider.setMinimum(0); // Valor mínimo del slider
            slider.setMaximum(250); // Valor máximo del slider
            slider.setValue(125); // Valor inicial del slider

            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = slider.getValue();
                    repaintLienzoColor(value);
                }
            });

            slider.setBounds(10, 330, 200, 55);

            // Agregar texto al slider
            slider.setPaintLabels(true);
            slider.setPaintTicks(true);
            slider.setMajorTickSpacing(25);
            slider.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(0, new JLabel("N"));
            labelTable.put(125, new JLabel("Color"));
            labelTable.put(250, new JLabel("B"));

            slider.setLabelTable(labelTable);
        }
        return slider;
    }

    public void repaintLienzoColor(int value) {
        // Actualizar el lienzo con el nuevo valor del slider
        lienzo.setBackground(new Color(value, value, value));
        lienzo.repaint();
    }

    public JSlider getSliderMovimientoX() {
        if (sliderX == null) {

            sliderX = new JSlider();

            sliderX.setMinimum(-250); // Valor mínimo del slider
            sliderX.setMaximum(250); // Valor máximo del slider
            sliderX.setValue(0); // Valor inicial del slider

            sliderX.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = sliderX.getValue();
                    repaintLienzoX(value,idActual);
                }
            });

            sliderX.setBounds(10, 385, 200, 55);

            // Agregar texto al slider
            sliderX.setPaintLabels(true);
            sliderX.setPaintTicks(true);
            sliderX.setMajorTickSpacing(25);
            sliderX.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("-X"));
            labelTable.put(0, new JLabel("0"));
            labelTable.put(250, new JLabel("+X"));

            sliderX.setLabelTable(labelTable);
            
        }
        return sliderX;
    }

public void repaintLienzoX(int value, int idActual) {
    this.value = value;
    this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            lnx1 = value;
            lnx2 = value;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);
            break;

        case 2: // triángulo
            if (value>=0) {
            trx1 = trx1 + 1;
            trx2 = trx2 + 1;
            trx3 = trx3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));
            }else{
            trx1 = trx1 -1;
            trx2 = trx2 -1;
            trx3 = trx3 -1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            cuax1 = cuax1 + 1;
            cuax2 = cuax2 + 1;
            cuax3 = cuax3 + 1;
            cuax4 = cuax4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            cuax1 = cuax1 - 1;
            cuax2 = cuax2 - 1;
            cuax3 = cuax3 - 1;
            cuax4 = cuax4 - 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo
            if (value>=0) {
            cbx1 = cbx1 + 1;
            cbx2 = cbx2 + 1;
            cbx3 = cbx3 + 1;
            cbx4 = cbx4 + 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            cbx1 = cbx1 - 1;
            cbx2 = cbx2 - 1;
            cbx3 = cbx3 - 1;
            cbx4 = cbx4 - 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            if (value>=0) {
            elCX = elCX + 1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }else {
            elCX = elCX -1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }
            break;

        case 6: // círculo
            if (value>0) {
            cirCX = cirCX + 1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }else {
            cirCX = cirCX -1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }
            break;

        default:
            break;
    }
}

    public JSlider getSliderMovimientoY() {
        if (sliderY == null) {

            sliderY = new JSlider();

            sliderY.setMinimum(-250); // Valor mínimo del slider
            sliderY.setMaximum(250); // Valor máximo del slider
            sliderY.setValue(0); // Valor inicial del slider

            sliderY.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    value = sliderY.getValue();
                    repaintLienzoY(value,idActual);
                }
            });

            sliderY.setBounds(10, 440, 200, 55);

            // Agregar texto al slider
            sliderY.setPaintLabels(true);
            sliderY.setPaintTicks(true);
            sliderY.setMajorTickSpacing(25);
            sliderY.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("-Y"));
            labelTable.put(0, new JLabel("0"));
            labelTable.put(250, new JLabel("+Y"));

            sliderY.setLabelTable(labelTable);
        }
        return sliderY;
    }

    public void repaintLienzoY(int value, int idActual) {
        this.value = value;
        this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            if (value>=0){
            lny1 = value;
            lny2 = value+hLinea;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);    
            }else{
            lny1 = value;
            lny2 = value-hLinea;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);
            
            }
            break;

        case 2: // triángulo
            if (value>=0) {
            try1 = try1 + 1;
            try2 = try2 + 1;
            try3 = try3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));
            }else{
            try1 = try1 -1;
            try2 = try2 -1;
            try3 = try3 -1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            cuay1 = cuay1 + 1;
            cuay2 = cuay2 + 1;
            cuay3 = cuay3 + 1;
            cuay4 = cuay4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            cuay1 = cuay1 - 1;
            cuay2 = cuay2 - 1;
            cuay3 = cuay3 - 1;
            cuay4 = cuay4 - 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo
            if (value>=0) {
            cby1 = cby1 + 1;
            cby2 = cby2 + 1;
            cby3 = cby3 + 1;
            cby4 = cby4 + 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            cby1 = cby1 - 1;
            cby2 = cby2 - 1;
            cby3 = cby3 - 1;
            cby4 = cby4 - 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            if (value>=0) {
            elCY = elCY + 1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }else {
            elCY = elCY -1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }
            break;

        case 6: // círculo
            if (value>0) {
            cirCY = cirCY +1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }else {
            cirCY = cirCY-1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }
            break;

        default:
            break;
    }
    }
    public JSlider getSliderMovimientoZ() {
        if (sliderz == null) {

            sliderz = new JSlider();

            sliderz.setMinimum(-250); // Valor mínimo del slider
            sliderz.setMaximum(250); // Valor máximo del slider
            sliderz.setValue(0); // Valor inicial del slider

            sliderz.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = sliderz.getValue();
                    repaintLienzoZ(value,idActual);
                }
            });

            sliderz.setBounds(10, 495, 200, 55);

            // Agregar texto al slider
            sliderz.setPaintLabels(true);
            sliderz.setPaintTicks(true);
            sliderz.setMajorTickSpacing(25);
            sliderz.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("-Z"));
            labelTable.put(0, new JLabel("0"));
            labelTable.put(250, new JLabel("+Z"));

            sliderz.setLabelTable(labelTable);
            
        }
        return sliderz;
    }
        public void repaintLienzoZ(int value, int idActual) {
    this.value = value;
    this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            if (value>=0){
            lnx1 = value;
            lnx2 = value+hLinea;
            lny1 = value;
            lny2 = value+hLinea;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);    
            }else{
            lnx1 = value;
            lnx2 = value-hLinea;
            lny1 = value;
            lny2 = value-hLinea;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);
            
            }
            break;

        case 2: // triángulo//
            if (value>=0) {
            trx1 = trx1 + 1;
            trx2 = trx2 + 1;
            trx3 = trx3 + 1;
            try1 = try1 + 1;
            try2 = try2 + 1;
            try3 = try3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));
            }else{
            trx1 = trx1 -1;
            trx2 = trx2 -1;
            trx3 = trx3 -1;
            try1 = try1 - 1;
            try2 = try2 - 1;
            try3 = try3 - 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            cuax1 = cuax1 + 1;
            cuax2 = cuax2 + 1;
            cuax3 = cuax3 + 1;
            cuax4 = cuax4 + 1;
            cuay1 = cuay1 + 1;
            cuay2 = cuay2 + 1;
            cuay3 = cuay3 + 1;
            cuay4 = cuay4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            cuax1 = cuax1 - 1;
            cuax2 = cuax2 - 1;
            cuax3 = cuax3 - 1;
            cuax4 = cuax4 - 1;
            cuay1 = cuay1 - 1;
            cuay2 = cuay2 - 1;
            cuay3 = cuay3 - 1;
            cuay4 = cuay4 - 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo ////aun no funciona bien
            if (value>=0) {
            cbx1 = cbx1 + 1;
            cbx2 = cbx2 + 1;
            cbx3 = cbx3 + 1;
            cbx4 = cbx4 + 1;
            cby1 = cby1 + 1;
            cby2 = cby2 + 1;
            cby3 = cby3 + 1;
            cby4 = cby4 + 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            cbx1 = cbx1 - 1;
            cbx2 = cbx2 - 1;
            cbx3 = cbx3 - 1;
            cbx4 = cbx4 - 1;
            cby1 = cby1 - 1;
            cby2 = cby2 - 1;
            cby3 = cby3 - 1;
            cby4 = cby4 - 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            elCX = value;
            elCY = value;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            break;

        case 6: // círculo
            cirCX = value;
            cirCY = value;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            break;

        default:
            break;
    }
    }

    public JSlider getSliderRotarX() {
        if (sliderRX == null) {

            sliderRX = new JSlider();

            sliderRX.setMinimum(-250); // Valor mínimo del slider
            sliderRX.setMaximum(250); // Valor máximo del slider
            sliderRX.setValue(0); // Valor inicial del slider

            sliderRX.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = sliderRX.getValue();
                    repaintLienzoRotaX(value,idActual);
                }
            });

            //sliderRX.setBounds(10, 495, 200, 55);
            //sliderRX.setBounds(10, 545, 200, 55);
            sliderRX.setBounds(240, 545, 200, 55);

            // Agregar texto al slider
            sliderRX.setPaintLabels(true);
            sliderRX.setPaintTicks(true);
            sliderRX.setMajorTickSpacing(25);
            sliderRX.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("Izq"));
            labelTable.put(0, new JLabel("Rotar en X"));
            labelTable.put(250, new JLabel("Der"));

            sliderRX.setLabelTable(labelTable);
        }
        return sliderRX;
    }
    
    
public void repaintLienzoRotaX(int value, int idActual) {
    this.value = value;
    this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            //Aqui no se hace nada ya que solo es una linea, sin ancho, auqnue rotara no se visualizaria 
            break;

        case 2: // triángulo
            if (value>=0) {
            //trx1 = trx1 + 1;
            /*
            trx2 = trx2 -1;
            trx3 = trx3 +1;
            try2 = try2 + 1;
            try3 = try3 - 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), 
                    new Punto(trx1, try1), new Punto(trx2, try2), 
                    new Punto(trx3, try3));
            }else{
            //trx1 = trx1 -1;
            trx2 = trx2 + 1;
            trx3 = trx3 - 1;
            try2 = try2 - 1;
            try3 = try3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }*/
            
            //trx2 = trx2;
            //trx3 = trx3 +1;
            //try2 = try2;
            try3 = try3 - 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), 
                    new Punto(trx1, try1), new Punto(trx2, try2), 
                    new Punto(trx3, try3));
            }else{
            //trx1 = trx1 -1;
            //trx2 = trx2 + 1;
            //trx3 = trx3 - 1;
            //try2 = try2 - 1;
            try3 = try3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            //cuax1 = cuax1 + 1;
            //cuax2 = cuax2+1;
            //cuax3 = cuax3;
            //cuax4 = cuax4-1;
            //cuay2 = cuay2 ;
            cuay3 = cuay3-1 ;
            cuay4 = cuay4 -1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            //cuax1 = cuax1 - 1;
            //cuax2 = cuax2 - 1;
            //cuax3 = cuax3;
            //cuax4 = cuax4 + 1;
            //cuay2 = cuay2;
            cuay3 = cuay3 + 1;
            cuay4 = cuay4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo
            if (value>=0) {
            /*cbx1 = cbx1 + 1;
            cbx2 = cbx2 - 1;
            cbx3 = cbx3 - 1;
            cbx4 = cbx4 + 1;*/
            cby3 = cby3-1 ;
            cby4 = cby4-1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            /*cbx1 = cbx1 - 1;
            cbx2 = cbx2 + 1;
            cbx3 = cbx3 + 1;
            cbx4 = cbx4 - 1;*/
            cby3 = cby3+1 ;
            cby4 = cby4+1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            if (value>=0) {
            //elCX = elCX + 1;
            //elA=elA+1;
            elB=elB-1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), 
                    elCX, elCY, elA, elB);
            }else {
            //elCX = elCX -1;
            //elA=elA-1;
           elB=elB+1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }
            break;

        case 6: // círculo
            /*if (value>0) {
            cirCX = cirCX + 1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }else {
            cirCX = cirCX -1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }*/
            break;

        default:
            break;
    }
}

public JSlider getSliderRotarZ() {
        if (sliderRZ == null) {

            sliderRZ = new JSlider();

            sliderRZ.setMinimum(-250); // Valor mínimo del slider
            sliderRZ.setMaximum(250); // Valor máximo del slider
            sliderRZ.setValue(0); // Valor inicial del slider

            sliderRZ.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = sliderRZ.getValue();
                    repaintLienzoRotaZ(value,idActual);
                }
            });

            //sliderRX.setBounds(10, 495, 200, 55);
            //sliderRX.setBounds(10, 545, 200, 55);
            sliderRZ.setBounds(450, 545, 200, 55);

            // Agregar texto al slider
            sliderRZ.setPaintLabels(true);
            sliderRZ.setPaintTicks(true);
            sliderRZ.setMajorTickSpacing(25);
            sliderRZ.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("Izq"));
            labelTable.put(0, new JLabel("Rotar en Z"));
            labelTable.put(250, new JLabel("Der"));

            sliderRZ.setLabelTable(labelTable);
        }
        return sliderRZ;
    }
    
    
public void repaintLienzoRotaZ(int value, int idActual) {
    this.value = value;
    this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            //Aqui no se hace nada ya que solo es una linea, sin ancho, auqnue rotara no se visualizaria 
            break;

        case 2: // triángulo
            if (value>=0) {
            trx1 = trx1 + 1;
            trx2 = trx2 - 1;
            //trx3 = trx3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), 
                    new Punto(trx1, try1), new Punto(trx2, try2), 
                    new Punto(trx3, try3));
            }else{
            trx1 = trx1 -1;
            trx2 = trx2 +1;
            //trx3 = trx3 -1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            cuax1 = cuax1 + 1;
            cuax2 = cuax2 - 1;
            cuax3 = cuax3 - 1;
            cuax4 = cuax4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            cuax1 = cuax1 - 1;
            cuax2 = cuax2 + 1;
            cuax3 = cuax3 + 1;
            cuax4 = cuax4 - 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo
            if (value>=0) {
            cbx1 = cbx1 + 1;
            cbx2 = cbx2 - 1;
            cbx3 = cbx3 - 1;
            cbx4 = cbx4 + 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            cbx1 = cbx1 - 1;
            cbx2 = cbx2 + 1;
            cbx3 = cbx3 + 1;
            cbx4 = cbx4 - 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            if (value>=0) {
            //elCX = elCX + 1;
            elA=elA-1;
            //elB=elB-1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), 
                    elCX, elCY, elA, elB);
            }else {
            //elCX = elCX -1;
            elA=elA+1;
            //elB=elB+1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }
            break;

        case 6: // círculo
            /*if (value>0) {
            //rad = rad + 1;
            //cirCY=rad-1;
            //rad=cirCY-1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }else {
            rad = rad -1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }
            break;*/

        default:
            break;
    }
}
    

public JSlider getSliderEsc() {
        if (sliderEsc == null) {

            sliderEsc = new JSlider();

            sliderEsc.setMinimum(-250); // Valor mínimo del slider
            sliderEsc.setMaximum(250); // Valor máximo del slider
            sliderEsc.setValue(0); // Valor inicial del slider

            sliderEsc.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    // Manejar el cambio de valor del slider aquí
                    value = sliderEsc.getValue();
                    repaintLienzoEsc(value,idActual);
                }
            });

            //sliderEsc.setBounds(10, 545, 200, 55);
            //sliderEsc.setBounds(240, 545, 200, 55);
            sliderEsc.setBounds(10, 545, 200, 55);

            // Agregar texto al slider
            sliderEsc.setPaintLabels(true);
            sliderEsc.setPaintTicks(true);
            sliderEsc.setMajorTickSpacing(25);
            sliderEsc.setMinorTickSpacing(5);

            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-250, new JLabel("-"));
            labelTable.put(0, new JLabel("Escalar"));
            labelTable.put(250, new JLabel("+"));

            sliderEsc.setLabelTable(labelTable);
        }
        return sliderEsc;
    }
    
    
public void repaintLienzoEsc(int value, int idActual) {
    this.value = value;
    this.idActual = idActual;

    borrarLienzo(); // Borra el contenido anterior del lienzo

    switch (idActual) {
        case 1: // línea
            
            if (value>=0){
            lny1 =value+1;
            lny2 = lny2-1;
            /*Segun yo , aun no probado, esto debe servir si no es recta
            lnx1 = wLinea+1;
            lnx2 = wLinea-1;*/
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);    
            }else{
            lny1 =value-1;
            lny2 = lny2+1;
            AccionesGraficas.pintarLineaCBresenham(getLienzo().getGraphics(), lnx1, lny1, lnx2, lny2);
            
            }
            break;

        case 2: // triángulo
            if (value>=0) {
            trx1 = trx1 - 1;
            trx2 = trx2 + 1;
            //trx3 = trx3 + 1;
            try1 = try1 - 1;
            try2 = try2 - 1;
            //try3 = try3 + 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));
            }else{
            trx1 = trx1 +1;
            trx2 = trx2 -1;
            //trx3 = trx3 -1;
            try1 = try1 +1;
            try2 = try2 + 1;
            //try3 = try3 - 1;
            AccionesGraficas.pintarTriangulo(getLienzo().getGraphics(), new Punto(trx1, try1), new Punto(trx2, try2), new Punto(trx3, try3));  
            }
            break;

        case 3: // cuadrado
             if (value>=0) {
            cuax1 = cuax1 - 1;
            cuax2 = cuax2 + 1;
            cuax3 = cuax3 + 1;
            cuax4 = cuax4 - 1;
            cuay1 = cuay1 - 1;
            cuay2 = cuay2 - 1;
            cuay3 = cuay3 + 1;
            cuay4 = cuay4 + 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4));
            }else{
            cuax1 = cuax1 + 1;
            cuax2 = cuax2 - 1;
            cuax3 = cuax3 - 1;
            cuax4 = cuax4 + 1;
            cuay1 = cuay1 + 1;
            cuay2 = cuay2 + 1;
            cuay3 = cuay3 - 1;
            cuay4 = cuay4 - 1;
            AccionesGraficas.pintarCuadrado(getLienzo().getGraphics(), new Punto(cuax1, cuay1), new Punto(cuax2, cuay2),
                    new Punto(cuax3, cuay3), new Punto(cuax4, cuay4)); 
            }
            break;

        case 4: // cubo ////aun no funciona bien
            if (value>=0) {
            cbx1 = cbx1 - 1;
            cbx2 = cbx2 + 1;
            cbx3 = cbx3 + 1;
            cbx4 = cbx4 - 1;
            cby1 = cby1 - 1;
            cby2 = cby2 - 1;
            cby3 = cby3 + 1;
            cby4 = cby4 + 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4));
            }else{
            cbx1 = cbx1 + 1;
            cbx2 = cbx2 - 1;
            cbx3 = cbx3 - 1;
            cbx4 = cbx4 + 1;
            cby1 = cby1 + 1;
            cby2 = cby2 + 1;
            cby3 = cby3 - 1;
            cby4 = cby4 - 1;
            AccionesGraficas.pintarCubo(getLienzo().getGraphics(), new Punto(cbx1, cby1), new Punto(cbx2, cby2),
                    new Punto(cbx3, cby3), new Punto(cbx4, cby4)); 
            }
            break;

        case 5: // elipse
            /*elCX = value;
            elCY = value;*/
            if (value>=0) {
            elA=elA+1;
            elB=elB+1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            }else{
            elA=elA-1;
            elB=elB-1;
            AccionesGraficas.pintarElipse(getLienzo().getGraphics(), elCX, elCY, elA, elB);
            
            }
            break;

        case 6: // círculo
            /*cirCX = value;
            cirCY = value;*/
            if (value>=0) {
            rad=rad+1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            }else{
            rad=rad-1;
            AccionesGraficas.pintarCirculo(getLienzo().getGraphics(), cirCX, cirCY, rad);
            
            }
            break;

        default:
            break;
    }
}

    public static void main(String[] args) {
        new VentanaPrincipal();
    }

}
