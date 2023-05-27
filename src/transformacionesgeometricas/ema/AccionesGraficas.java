/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transformacionesgeometricas.ema;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emeji
 */
public class AccionesGraficas {

    public static void pintarPlanoCartesiano(Graphics g) {

        g.setColor(Color.LIGHT_GRAY);
        // Linea de las X
        g.drawLine(475, 250, 25, 250); // X

        g.drawLine(475, 250, 460, 240); // X flechaP
        g.drawLine(475, 250, 460, 260); // X flechaP
        g.drawString("X", 480, 250);

        g.drawLine(25, 250, 40, 240); // X flechaN
        g.drawLine(25, 250, 40, 260); // X flechaN
        g.drawString("-X", 10, 250);

        // Linea de las Y
        g.drawLine(250, 25, 250, 475); // Y 

        g.drawLine(250, 25, 240, 40); // Y flechaP
        g.drawLine(250, 25, 260, 40); // Y flechaP
        g.drawString("Y", 245, 20);
        g.drawLine(250, 475, 240, 460); // Y flechaN
        g.drawLine(250, 475, 260, 460); // Y flechaN
        g.drawString("-Y", 242, 490);

        // Linea de las Z
         g.drawLine(25, 475, 475, 25); // Z 
            
            g.drawLine(475, 40, 475, 25); // Z flechaP
            g.drawLine(460, 25, 475, 25); // Z flechaP
            g.drawString("Z", 480, 20);
            g.drawLine(25, 475, 25, 460); // Z flechaP
            g.drawLine(25, 475, 40, 475); // Z flechaP
            g.drawString("-Z", 10, 490);
        
    }

    //tarea instancias desde el 10,10 y 20,20 lineas , 
    //usar arreglo de puntos muchos puntos con un for
    //AccionesGraficas.pintarLinea(getLienzo().getGraphics(),x1:10,y1: 10,x2: 20,y2: 20);
    public static void pintarLinea(Graphics gr, int x1, int y1, int x2, int y2) {
        //Punto origen: 250,250,250,250
        //Cambio de color para distinguirlo mejor
        gr.setColor(Color.MAGENTA);

        //gr.drawString("11", 260, 240);
        //gr.drawString("22", 270, 230);
        int[] cX1 = new int[x2 - x1 + 1];
        int[] cX2 = new int[x2 - x1 + 1];
        int[] cY1 = new int[y2 - y1 + 1];
        int[] cY2 = new int[y2 - y1 + 1];

        // Calcular los valores de los arreglos
        for (int i = 0; i < cX1.length; i++) {
            //x1:  incrementamos en 1   ej.250+x1(10)+i= 260,261,262...270
            cX1[i] = 250 + x1 + i;
            //:  incrementamos en 1   ej.250+x1(10)+i= 260,261,262...270 
            cX2[i] = 250 + x1 + i;
        }
        for (int j = 0; j < cY1.length; j++) {
            //y1:  decrementamos en 1   ej.250-y1(10)-i= 240,239,238,..230
            cY1[j] = 250 - y1 - j;
            //y2:  decrementamos en 1   ej.250-y1(10)-i= 240,239,238,..230
            cY2[j] = 250 - y1 - j;
        }

        // Dibujar la línea
        for (int line = 0; line < cX1.length; line++) {
            gr.drawLine(cX1[line], cY1[line], cX2[line], cY2[line]);
        }

        //gr.drawLine(cX1[0], cY1[0], cX2[0], cY2[0]);Punto inicial
        //gr.drawLine(cX1[10], cY1[10], cX2[10], cY2[10]);Punto final
    }

    /*
Formula de la pendiente:
    y=m.x+b
    m=(Yfinal-Yinicial)/(Xfinal-Xinicial)
    b=Yinicial - m.Xinicial
     */
    /*
    Positiva: m>0       Negativa: m<0
    0: m=0              Indefinida: 
    */
    public static void pintarLineaConFPendiente(Graphics g, int x1, int y1, int x2, int y2) {
        //int m=0;
        //m=(y1-y2)/(x1-x2);  

        List<Punto> linea = new ArrayList();
        //Pintamos el punto inicial//
        linea.add(new Punto(x1, y1));
        //Pintamos el punto final
        linea.add(new Punto(x2, y2));
        //Calculamos la pendiente
        double m = (double) (y2 - y1) / (double) (x2 - x1);
        //Calculamos b
        double b = y1 - m * x1;
        
        if (x2<x1) {
            int x01=x2;
            int x02=x1;
       
        if (x1==x2) {
            //Acciones para la indefinida que es una: |
                for (int y = y1+1; y < y2; y++) {
                    // La x1=x2 se mantienen solo cambia y 
                    linea.add(new Punto(x1, y));
                }
        } else {
        
        if (m>=0) {// Observacion la linea se pinta desde los 1 hasta los 2 ejemplo:/ o -
           for (int x = x1 + 1; x < x2; x++) {
            //Calculamos y
            double y = m * x + b;
            //Movimiento en las X y  en ambas, sirve para dos tipos
            linea.add(new Punto(x, y));
        } 
        } else {
            if (m<0) { // Hay que dibujar la linea de 2 a 1, del mas bajo al mas alto: \ 
            for (int y = y1+1; y < y2; y++) {
            //Calculamos x,hay que despejar la x de: double y =Math.abs(m) * x + b;
            double x =(y - b)/m;
            //Movimiento en las X y  en ambas, sirve para dos tipos
            linea.add(new Punto(x, y)); 
            } 
            } 
        }
        
        }
        }
        
        //Pintamos la linea y puntos
        for (Punto p : linea) {
            p.pintar(g);
        }
    }


    /*
Algoritmo DDA:

     */
 /*
DDA de tarea
 analizador diferenciador digital (DDA - Digital Differential Analyzer) 
es un algoritmo de conversion de rastreo
que se basa en el calculo ya sea de Dy o Dx 
     */
//No funciona totalmente
    public static void pintarLineaConAlgoritmoDDA(Graphics g, int x1, int y1, int x2, int y2) {

        //Creacion de array
        List<Punto> linea = new ArrayList();
        //punto de inicio
        linea.add(new Punto(x1, y1));
        //Diferencia de X y Y, final-inicial
        int dx, dy;
        dx = x2 - x1;
        dy = y2 - y1;
        //pasos
        int steps;

        //verificar si la "pendiente" es mayor de x o y, para luego asignarla a steps
        if (dx > dy) { //si dx es mayor se asigna a steps
            steps = dx;
        } else {
            steps = dy;//sino la que se asigna es dy
        }
        //Si steps es 0 agregamos la coordenada final
        //Solo pintara un punto
        if (steps == 0) {
            linea.add(new Punto(x2, y2));
        }
        //Calculamos el incremento 
        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;

        float y = 0, x = 0;
        //for hasta llegar al numero de steps máximo
        for (int i = 0; i <= steps; i++) {
            y = y + yInc;
            x = x + xInc;
            linea.add(new Punto(Math.round(x), Math.round(y)));
        }

        //Pinta la linea
        for (Punto p : linea) {
            p.pintar(g);

        }

    }

    /*
Algoritmo Bresenham:
     */
    public static void pintarLineaConAlgoritmoBresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int x0 = x1;
        int y0 = y1;
        int xf = x2;
        int yf = y2;

        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        new Punto(x0, y0).pintar(g);
        new Punto(xf, yf).pintar(g);

        if (deltaX == 0) {
          for (int i = y0 + 1; i < yf; i++) {
                        new Punto(x0, i).pintar(g);
                    }  
        } else {

            double m = Math.abs((double) deltaY / deltaX);

            if (m > 0 && m < 1) {
                int yk = y0;
                int pk = 2 * deltaY - deltaX;
                for (int xk = x0; xk < xf; xk++) {
                    if (pk < 0) {
                        new Punto(xk + 1, yk).pintar(g);
                        pk = pk + 2 * deltaY;

                    } else {
                        yk++;
                        new Punto(xk + 1, yk + 1).pintar(g);
                        pk = pk + 2 * deltaY - 2 * deltaX;
                    }

                }
            } else {
                if (m <= 0) {
                    for (int i = x0 + 1; i < xf; i++) {
                        new Punto(i, y0).pintar(g);
                    }
                } else {
                    if (m >= 1) {
                        int i = x0 + 1;
                        int j = y0 + 1;
                        while (i < xf) {
                            new Punto(i, j).pintar(g);
                            i++;
                            j++;
                        }
                    }
                }
            }
        }

    }

        //Codigo de hindu
    public static void pintarLineaCBresenham(Graphics g, int x0, int y0, int x1, int y1) {
         g.setColor(Color.MAGENTA);
        //diferenciaX y diferenciaY
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        //signo de la direccion Si x1 > x0, sx será igual a 1 y la línea se 
        //dicuja hacia la derecha. Si x1 < x0, sx será igual a -1 y la línea se dibuja hacia la izquierda.
        int sx = (x0 < x1) ? 1 : -1;
        int sy = (y0 < y1) ? 1 : -1;
        //variable de desicion, para saber a donde moverse 
        int err = dx - dy;

        int contador = 0;
        while (true) {
            new Punto(x0, y0).pintar(g);
            contador++;

            if (x0 == x1 && y0 == y1) {
                break;
            }

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x0 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y0 += sy;
            }
        }
    }
    //Pintar un triangulo recibiendo 3 puntos
    public static void pintarTriangulo(Graphics g, Punto p1, Punto p2, Punto p3){
        //Triangulo triangulo= new Triangulo(punto1, punto2, punto3);
        pintarLineaCBresenham(g, (int)p1.getX(),(int)p1.getY(),(int)p2.getX(), (int)p2.getY());
        pintarLineaCBresenham(g, (int)p2.getX(),(int)p2.getY(),(int)p3.getX(), (int)p3.getY());
        pintarLineaCBresenham(g, (int)p3.getX(),(int)p3.getY(),(int)p1.getX(), (int)p1.getY());
    }
    //Pintar un cuadrado recibiendo 4 puntos
    public static void pintarCuadrado(Graphics g, Punto p1, Punto p2, Punto p3,Punto p4){
        pintarLineaCBresenham(g, (int)p1.getX(),(int)p1.getY(),(int)p2.getX(), (int)p2.getY());
        pintarLineaCBresenham(g, (int)p2.getX(),(int)p2.getY(),(int)p3.getX(), (int)p3.getY());
        pintarLineaCBresenham(g, (int)p3.getX(),(int)p3.getY(),(int)p4.getX(), (int)p4.getY());
        pintarLineaCBresenham(g, (int)p4.getX(),(int)p4.getY(),(int)p1.getX(), (int)p1.getY());
        
    } 
    
    //Pintar un cubo recibiendo 4 puntos
    public static void pintarCubo(Graphics g, Punto p1, Punto p2, Punto p3, Punto p4) {
        //Pintando el primer cuadrado, el de "enfrente"
        pintarLineaCBresenham(g, (int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
        pintarLineaCBresenham(g, (int) p2.getX(), (int) p2.getY(), (int) p3.getX(), (int) p3.getY());
        pintarLineaCBresenham(g, (int) p3.getX(), (int) p3.getY(), (int) p4.getX(), (int) p4.getY());
        pintarLineaCBresenham(g, (int) p4.getX(), (int) p4.getY(), (int) p1.getX(), (int) p1.getY());
        
        //Usamos la diferencia del punto con mayor numero de pixeles
        double diferenciaXP3 = p3.getX() / 2.0;//100/2=50
        double diferenciaYP3 = p3.getY() / 2.0;//100/2=50
       
        //Creamos nuevos puntos para pintar el nuevo cuadrado 
        Punto nuevoP1 = new Punto((p1.getX()*.5) + diferenciaXP3, (p1.getY()*.5) + diferenciaYP3);
        Punto nuevoP2 = new Punto(p2.getX() + diferenciaXP3, (p2.getY()*.5) + diferenciaYP3);
        //Toman la diferencia del punto 
        Punto nuevoP3 = new Punto(p3.getX() + diferenciaXP3, p3.getY() + diferenciaYP3);
        Punto nuevoP4 = new Punto((p4.getX()*.5) + diferenciaXP3, p4.getY() + diferenciaYP3);
        
        //Pintando el segundo cuadrado, el de "atras"
        pintarLineaCBresenham(g, (int) nuevoP1.getX(), (int) nuevoP1.getY(), (int) nuevoP2.getX(), (int) nuevoP2.getY());
        pintarLineaCBresenham(g, (int) nuevoP2.getX(), (int) nuevoP2.getY(), (int) nuevoP3.getX(), (int) nuevoP3.getY());
        pintarLineaCBresenham(g, (int) nuevoP3.getX(), (int) nuevoP3.getY(), (int) nuevoP4.getX(), (int) nuevoP4.getY());
        pintarLineaCBresenham(g, (int) nuevoP4.getX(), (int) nuevoP4.getY(), (int) nuevoP1.getX(), (int) nuevoP1.getY());

        //Pintamos las lineas que unen los dos cuadrados, para que ya se vea como un cubo
        pintarLineaCBresenham(g, (int) p1.getX(), (int) p1.getY(), (int) nuevoP1.getX(), (int) nuevoP1.getY());
        pintarLineaCBresenham(g, (int) p2.getX(), (int) p2.getY(), (int) nuevoP2.getX(), (int) nuevoP2.getY());
        pintarLineaCBresenham(g, (int) p3.getX(), (int) p3.getY(), (int) nuevoP3.getX(), (int) nuevoP3.getY());
        pintarLineaCBresenham(g, (int) p4.getX(), (int) p4.getY(), (int) nuevoP4.getX(), (int) nuevoP4.getY());
    }
    
    //Dibujando una elipse usando el algoritmo del punto medio
    public static void pintarElipse(Graphics g, int xCenter, int yCenter, int a, int b) {
    g.setColor(Color.BLUE);

    int x = 0;
    int y = b;

    int aSquared = a * a;
    int bSquared = b * b;
    int twoASquared = 2 * aSquared;
    int twoBSquared = 2 * bSquared;
    int fourASquared = 4 * aSquared;
    int fourBSquared = 4 * bSquared;

    int p = (int) Math.round(bSquared - (aSquared * b) + (0.25 * aSquared));

    pintarElipsePuntosSimetricos(g, xCenter, yCenter, x, y);

    while (fourBSquared * x < fourASquared * y) {
        x++;
        if (p < 0) {
            p += fourBSquared * (2 * x + 3);
        } else {
            y--;
            p += fourBSquared * (2 * x + 3) + twoASquared * (1 - y);
        }
        pintarElipsePuntosSimetricos(g, xCenter, yCenter, x, y);
    }

    p = (int) Math.round(bSquared * (x + 0.5) * (x + 0.5) + aSquared * (y - 1) * (y - 1) - aSquared * bSquared);

    while (y > 0) {
        y--;
        if (p > 0) {
            p += fourASquared * (1 - y);
        } else {
            x++;
            p += fourASquared * (1 - y) + twoBSquared * (2 * x + 2);
        }
        pintarElipsePuntosSimetricos(g, xCenter, yCenter, x, y);
    }
}

private static void pintarElipsePuntosSimetricos(Graphics g, int xCenter, int yCenter, int x, int y) {
    new Punto(xCenter + x, yCenter + y).pintar(g); // Punto 1: (xCenter + x, yCenter + y)
    new Punto(xCenter - x, yCenter + y).pintar(g); // Punto 2: (xCenter - x, yCenter + y)
    new Punto(xCenter + x, yCenter - y).pintar(g); // Punto 3: (xCenter + x, yCenter - y)
    new Punto(xCenter - x, yCenter - y).pintar(g); // Punto 4: (xCenter - x, yCenter - y)
}

//Dibujando una circulo usando el algoritmo del punto medio
public static void pintarCirculo(Graphics g, int xCenter, int yCenter, int radius) {
    g.setColor(Color.GREEN);

    int x = 0;
    int y = radius;
    int p = 1 - radius;

    pintarCirculoPuntosSimetricos(g, xCenter, yCenter, x, y);

    while (x < y) {
        x++;
        if (p < 0) {
            p += 2 * x + 1;
        } else {
            y--;
            p += 2 * (x - y) + 1;
        }
        pintarCirculoPuntosSimetricos(g, xCenter, yCenter, x, y);
    }
}

private static void pintarCirculoPuntosSimetricos(Graphics g, int xCenter, int yCenter, int x, int y) {
    new Punto(xCenter + x, yCenter + y).pintar(g); // Punto 1: (xCenter + x, yCenter + y)
    new Punto(xCenter - x, yCenter + y).pintar(g); // Punto 2: (xCenter - x, yCenter + y)
    new Punto(xCenter + x, yCenter - y).pintar(g); // Punto 3: (xCenter + x, yCenter - y)
    new Punto(xCenter - x, yCenter - y).pintar(g); // Punto 4: (xCenter - x, yCenter - y)
    new Punto(xCenter + y, yCenter + x).pintar(g); // Punto 5: (xCenter + y, yCenter + x)
    new Punto(xCenter - y, yCenter + x).pintar(g); // Punto 6: (xCenter - y, yCenter + x)
    new Punto(xCenter + y, yCenter - x).pintar(g); // Punto 7: (xCenter + y, yCenter - x)
    new Punto(xCenter - y, yCenter - x).pintar(g); // Punto 8: (xCenter - y, yCenter - x)
}

    
    
    
    
}
