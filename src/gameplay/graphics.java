/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameplay;

/**
 *
 * @author SOURAV
 */
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JPanel;
public class graphics extends JPanel{
    int[][] table=new int[3][3];
    int rule=-1,up=0,user=0;
     public void repaintIt(int[][] board,int usr,int line,int u)
     {      
         table=board;rule=line;
         user=usr;
         repaint();
         up=u;
     }
     public void paint(Graphics g)
     {  
         Font f = new Font("Dialog", Font.BOLD,20);            
         g.setColor(Color.LIGHT_GRAY);
         g.setFont(f);
         refresh(g);  
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
               setPic(i,j,g);
            
     }
     public void setPic(int x,int y,Graphics g2)
     {
         int val=table[x][y];
         Graphics2D g = (Graphics2D) g2;
         g.setStroke(new BasicStroke(10)); 
         switch(x)
         {
             case 0:    switch(y)
                        {
                            case 0:     if(val==-1)
                                        {
                                            g.drawOval(50, 50,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(50, 50, 100, 100);
                                            g.drawLine(100, 50, 50, 100);
                                        }
                                        break;
                            case 1:     if(val==-1)
                                        {
                                            g.drawOval(185, 50,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(185, 50, 235, 100);
                                            g.drawLine(235, 50, 185, 100);                                            
                                        }
                                        break;
                            case 2:     if(val==-1)
                                        {
                                            g.drawOval(310, 50,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(310, 50, 360, 100);
                                            g.drawLine(360, 50, 310, 100);                                            
                                        }
                                        break;
                        }
                        break;
             case 1:    switch(y)
                        {
                            case 0:     if(val==-1)
                                        {
                                            g.drawOval(50, 190,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(50, 190, 100, 240);
                                            g.drawLine(100, 190, 50, 240);
                                        }
                                        break;
                            case 1:     if(val==-1)
                                        {
                                            g.drawOval(185, 190,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(185, 190, 235, 240);
                                            g.drawLine(235, 195, 185, 240);                                            
                                        }
                                        break;
                            case 2:     if(val==-1)
                                        {
                                            g.drawOval(310, 190,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(310, 190, 360, 240);
                                            g.drawLine(360, 190, 310, 240);                                            
                                        }
                                        break;
                        }
                        break;
             case 2:      switch(y)
                        {
                            case 0:     if(val==-1)
                                        {
                                            g.drawOval(50, 310,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(50, 310, 100, 360);
                                            g.drawLine(100, 310, 50, 360);
                                        }
                                        break;
                            case 1:     if(val==-1)
                                        {
                                            g.drawOval(185, 310,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(185, 310, 235, 360);
                                            g.drawLine(235, 310, 185, 360);                                            
                                        }
                                        break;
                            case 2:     if(val==-1)
                                        {
                                            g.drawOval(310, 310,50, 50);
                                        }
                                        else if(val==1)
                                        {
                                            g.drawLine(310, 310, 360, 360);
                                            g.drawLine(360, 310, 310, 360);                                            
                                        }
                                        break;
                        }
                        break;
         }
         String str=new String();
         int x1=-5;
         switch(rule)
         {
             case 0:    g.drawLine(40, 80, 370,80);     x1=table[0][0];
                        break;
             case 1:    g.drawLine(40, 210, 370,210);     x1=table[1][0];
                        break;
             case 2:    g.drawLine(40, 335, 370,335);     x1=table[2][0];
                        break;
             case 3:    g.drawLine(70, 40, 70,370);     x1=table[0][0];
                        break;
             case 4:    g.drawLine(205, 40, 205,370);     x1=table[0][1];
                        break;
             case 5:    g.drawLine(330, 40, 330,370);     x1=table[0][2];
                        break;
             case 6:    g.drawLine(40, 40, 370,370);     x1=table[1][1];
                        break;
             case 7:    g.drawLine(370, 40, 40,370);     x1=table[1][1];
                        break;
             case 8:    x1=0; break;
         }
         if(x1==0)
             str="GAME DRAW...";
         else if(x1==1)
             str="COMP WON...";
         else if(x1==-1)
             str="YOU WON...";
         g.setColor(Color.YELLOW);
         g.drawString(str, 20,450);
         g.setColor(Color.BLACK);
     }
     public void refresh(Graphics g)
     {
         super.paintComponent(g);
         this.setBackground(Color.black);
         g.fill3DRect(10, 10,400,400,false);
         g.setColor(Color.BLUE);
         g.fill3DRect(20, 20,120,120,false);    g.fill3DRect(150, 20,120,120,false); g.fill3DRect(280, 20,120,120,false);
         g.fill3DRect(20,150,120,120,false);    g.fill3DRect(150, 150,120,120,false); g.fill3DRect(280, 150,120,120,false);
         g.fill3DRect(20,280,120,120,false);    g.fill3DRect(150, 280,120,120,false); g.fill3DRect(280, 280,120,120,false);
         
         g.setColor(Color.LIGHT_GRAY);
         g.fill3DRect(280, 425,130, 40, true);
         g.fill3DRect(170, 425, 100, 40, true);
         g.setColor(Color.black);
         g.drawString("NEW GAME", 290, 450);
         if(up==0)
            g.drawString("LEVEL 1", 180, 450);
         else
            g.drawString("LEVEL 2", 180, 450);
         
         if(user==1)
         {
            g.setColor(Color.WHITE);
            g.drawString("YOUR TURN..", 20,450);
            g.setColor(Color.BLACK);
         }
     }
}
