package dev.kalarianathecila.schoolStuff.tutelini;

import java.awt.*;

class Turtle
{
  protected double posX, posY;        // Current position of the turtle
  protected double angle;            // Current looking direction
  protected Color color =Color.black;  // Default drawing color
  protected Container c;             // Container
  protected double homeX, homeY;      // Home coordinates
  protected boolean draw;
  protected int width, height;
  protected Graphics g;

  public Turtle(Container cont, Graphics graphics)
  {
        angle =0;
        draw = true;

        c=cont;
        g=graphics;
        width = c.getBounds().width;
        height = c.getBounds().height;
        posX = width / 2.0;
        posY = height / 2.0;
        homeX = posX;
        homeY = posY;
  }

  public Turtle(Container cont)
  {
      this(cont, cont.getGraphics());
  }

  public void homePosition()
  {
    posX=homeX;
    posY=homeY;
    angle =0;
  }

  public void move(double length)
  {
    if (g == null) return;
    g.setColor(color);
    double newWidth = posX + Math.cos(curve(angle))*length;
    double newHeight;
    newHeight = posY - Math.sin(curve(angle))*length;
    if (draw) g.drawLine((int) posX, (int) posY, (int) newWidth, (int) newHeight);

    posX = newWidth;
    posY = newHeight;
  }

  public void turnLeft(double degrees)
  {
    angle = angle + degrees;
    //   if (winkel > 360) winkel = winkel -360;
  }

  public void turnRight(double degrees)
  {
    angle = angle - degrees;
    //    if (winkel<0) winkel = 360+winkel ;

  }

  public void back(int length){
      turnLeft(180);
      stopDraw();
      move(length);
      turnRight(180);
      startDraw();
  }


  public void delete()
  {
    homePosition();

    int x=c.getBounds().width;
    int y=c.getBounds().height;
    if (g != null) g.clearRect(0, 0, x, y);
  }

  public void setColor(Color c)
  {
    color = c;
  }

  public void stopDraw()
  {
    draw =false;
  }

  public void startDraw()
  {
    draw =true;
  }


  public void draw()
  {
    if (g != null) g.setPaintMode();
  }

  private double curve(double angle)
  {
    return angle*Math.PI/180;
  }

}//Turtle.class
